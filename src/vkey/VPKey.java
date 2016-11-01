package vkey;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.text.BadLocationException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * Virtual keyboard and keypad. Used for touch screen systems for input text (method showKeyboard)
 * and input numbers (method showKeypad).
 * @author de-nos (de-nos@ya.ru)
 * @version 0.9 (2010.10.01)
 */
public class VPKey {
	private static JPasswordField field = new JPasswordField();
	private static CollectionKey collectionKey;
	private static boolean is_main_lang = true;
	private static boolean is_shift = false;
	private static boolean is_capslock = false;
	private static String backup_text;
	private static JDialog dialog;

	/** 
	 * @param str - String that need to modify (can be empty).
	 * @return Result of input.
	 */
	public static String showKeypad(String str) {
		return showCustomKeyboard("conf/keypad.xml",str);
	}

	/**
	 * @param str - String that need to modify (can be empty).
	 * @return Result of input.
	 */
	public static String showKeyboard(String str) {
		return showCustomKeyboard("conf/keyboard.xml", str);
	}
	
	private static String showCustomKeyboard(String conffilename, String str) {
		backup_text = str;
		Document doc = loadXML(conffilename);
		collectionKey = loadCollectionKey(doc);
		
		dialog = new JDialog();
                try{
                    BufferedImage image =ImageIO.read(VPKey.class.getResource("/images/novia.jpg"));
                    dialog.setIconImage(image);
                }
                catch(Exception e){
                    System.err.println("Error : "+e.getMessage());
                }
		dialog.setSize(collectionKey.width, collectionKey.height);
                String title="Enter Pasword!";//(lblTitle!=null)?(lblTitle.getText().trim().length()==0?"Keyboard":lblTitle.getText().trim()):"Keyboard";
		dialog.setTitle(title);
		toScreenCenter(dialog);
		dialog.addWindowListener(new WindowAdapter(){
                        @Override
			public void windowClosing(WindowEvent e) {
				field.setText(backup_text);
				dialog.setVisible(false);
			}
			});
		createDialog(str);
		
		dialog.setVisible(true);
		dialog.dispose();
		dialog = null;
		return field.getText();
	}

	private static JDialog createDialog(String str) {
		dialog.setModal(true);
		Container panel = dialog.getContentPane();
		int width = dialog.getWidth();
		field.setText(str);
                field.setEchoChar('-');
		field.setCaretPosition(str.length());
		field.setBounds(0, 0, width-1, 46);
		field.setFont(new Font("sansserif", Font.PLAIN, 28));
		panel.setLayout(null);
		panel.add(field);
		
		for (int i = 0; i < collectionKey.getCount(); i++) {
			SingleKey button = collectionKey.getKey(i);
			button.setFont(new Font("sansserif", Font.PLAIN, (int)(28*button.sizefactor)));
			button.addActionListener(actionListener);
			panel.add(button);
		}
		refreshButtonsText();
		refreshButtonsBounds();
		return dialog;
	}

	private static ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SingleKey sk = (SingleKey)e.getSource();
			int pos = field.getCaretPosition();
			if (sk.isSpecial()) {
				if (sk.special.matches("backspace")) {
					if (pos > 0) {
						try { field.getDocument().remove(pos-1, 1);
						} catch (BadLocationException e1) { e1.printStackTrace(); }
					}
				} else if (sk.special.matches("clear")) {
					field.setText("");
				} else if (sk.special.matches("lang")) {
					switchLanguage();
				} else if (sk.special.matches("shift")) {
					switchShift();
				} else if (sk.special.matches("capslock")) {
					switchCapslock();
				} else if (sk.special.matches("left")) {
					if (pos > 0) field.setCaretPosition(pos-1);
				} else if (sk.special.matches("right")) {
					if (pos < field.getText().length()) field.setCaretPosition(pos+1);
				} else if (sk.special.matches("ok")) {
					dialog.setVisible(false);
				} else if (sk.special.matches("enter")) {
					dialog.setVisible(false);
				} else if (sk.special.matches("cancel")) {
					field.setText(backup_text);
					dialog.setVisible(false);
				} else if (sk.special.matches("plusminus")) {
					if (field.getText().length() == 0) {
						field.setText("-" + field.getText());
					} else if (field.getText().getBytes()[0] == '-') {
						try { field.getDocument().remove(0, 1);
						} catch (BadLocationException e1) { e1.printStackTrace(); }
						field.setCaretPosition(pos-1);
					} else {
						field.setText("-" + field.getText());
						field.setCaretPosition(pos+1);
					}
				}
				
			} else {
				try {
					field.getDocument().insertString(pos, e.getActionCommand(), null);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				if (is_shift) switchShift();
			}
			field.grabFocus();
		}
	};
	
	private static void switchLanguage() {
		is_main_lang = (is_main_lang) ? false : true;
		refreshButtonsText();
	}

	private static void switchShift() {
		is_shift = (is_shift) ? false : true;
		refreshButtonsText();
	}

	private static void switchCapslock() {
		is_capslock = (is_capslock) ? false : true;
		is_shift = false;
		refreshButtonsText();
	}

	private static void refreshButtonsText() {
		for (int i = 0; i < collectionKey.getCount(); i++) {
			SingleKey button = collectionKey.getKey(i);
			if  (button.isSpecial()) {
				if (button.lang1 != null) {
					button.setText(button.lang1);
				} else {
					button.setText(button.special);
				}
			} else {
				if (is_shift || is_capslock) {
					if (is_main_lang) {
						button.setText(button.lang1up);
					} else {
						button.setText(button.lang2up);
					}
				} else {
					if (is_main_lang) {
						button.setText(button.lang1);
					} else {
						button.setText(button.lang2);
					}
				}
			}
		}
	}
	
	private static final int GAP = 2;
	
	private static void refreshButtonsBounds() {
		int frame_width = dialog.getWidth()-1;
		int frame_height = dialog.getHeight()-30;
		float max_length = collectionKey.getLengthInMaxLine();
		int count_lines = collectionKey.getCountOfLine();
		int width = (int) (frame_width / max_length - GAP);
		int height = (frame_height - field.getHeight()) / count_lines - GAP;
		int x = GAP/2, y = GAP/2 + field.getHeight();
		for (int j = 0; j < collectionKey.getCountOfLine(); j++) {
			x = GAP/2;
			y = field.getHeight() + GAP/2 + j*(height + GAP);
			for (int i = 0; i < collectionKey.getCountInLine(j); i++) {
				SingleKey button = collectionKey.getKey(j, i);
				button.setBounds(x, y, (int)(width * button.width), height);
				x += width * button.width + GAP;
			}
		}
	}
	
	private static final String LINE = "line";
	private static final String SPECIAL = "special";
	private static final String WIDTH = "width";
	private static final String HEIGHT = "height";
	private static final String TEXT = "text";
	private static final String KEY = "key";
	private static final String LANG1 = "lang1";
	private static final String LANG1UP = "lang1up";
	private static final String LANG2 = "lang2";
	private static final String LANG2UP = "lang2up";
	private static final String SIZEFACTOR = "sizefactor";
	
	@SuppressWarnings("unchecked")
	private static CollectionKey loadCollectionKey(Document doc) {
		CollectionKey collectionKey = new CollectionKey();
		Element root = doc.getRootElement();
		String s;
		s = root.getAttributeValue(WIDTH, "1024");
		collectionKey.width = Integer.parseInt(s);
		s = root.getAttributeValue(HEIGHT, "450");
		collectionKey.height = Integer.parseInt(s);
		// keys line parse
		for (Element line : (List<Element>) root.getChildren(LINE)) {
			collectionKey.newLine();
			for (Element key : (List<Element>) line.getChildren(KEY)) {
				String spec = key.getAttributeValue(SPECIAL);
				if (spec != null) {
					// special key
					float width = Float.parseFloat(key.getAttributeValue(WIDTH, "1"));
					float sizef = Float.parseFloat(key.getAttributeValue(SIZEFACTOR, "1"));
					String text = key.getAttributeValue(TEXT);
					collectionKey.addKey(spec, text, width, sizef);
				} else {
					// normal key
					String lng1 = key.getAttributeValue(LANG1);
					String lng1up = key.getAttributeValue(LANG1UP);
					String lng2 = key.getAttributeValue(LANG2);
					String lng2up = key.getAttributeValue(LANG2UP);
					if (lng1 == null) lng1 = "";
					if (lng1up == null) lng1up = "";
					if (lng2 == null) lng2 = lng1;
					if (lng2up == null) lng2up = lng1up;
					float width = Float.parseFloat(key.getAttributeValue(WIDTH, "1"));
					collectionKey.addKey(lng1, lng1up, lng2, lng2up, width);
				}
			}
		}
		return collectionKey;
	}

	private static Document loadXML(String filename) {
		InputStream is = ClassLoader.getSystemResourceAsStream(filename);
		if (is == null) {
			System.out.println("Config file not found in system resource (jar): " + filename);
			try {
				FileInputStream file = new FileInputStream("src/" + filename);
				is = file;
			} catch (FileNotFoundException e) {
				System.out.println("Config file not found: " + "src/" + filename);
			}
		}
		Document doc = null;
		try {
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(is);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final TouchTextField text = new TouchTextField("Введите текст");
		text.setBounds(10, 40, 400, 34);
		text.setFont(new Font("", Font.PLAIN, 20));

		final TouchTextField text2 = new TouchTextField(TouchTextField.TYPE_KEYPAD, "Введите число");
		text2.setBounds(10, 80, 400, 34);
		text2.setFont(new Font("", Font.PLAIN, 20));

		frame.setLayout(null);
		frame.add(text);
		frame.add(text2);
		frame.setVisible(true);
	}
	
    public static void toScreenCenter( Component component ) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = component.getSize();
        component.setLocation( ( screenSize.width - frameSize.width ) / 2,
                               ( screenSize.height - frameSize.height ) / 2 );
    }	
}
