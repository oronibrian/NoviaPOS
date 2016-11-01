package vkey;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class TouchPasswordField extends JPasswordField{
	private int type = TYPE_KEYBOARD;
	public static final int TYPE_KEYBOARD = 1;
	public static final int TYPE_KEYPAD = 2;
	private String def_text = DEF_TEXT;
	private static final String DEF_TEXT = "****";
	private boolean is_empty = true;
	private Color def_color;
	JPasswordField field = this;
	public TouchPasswordField() {
		init();
	}

	public TouchPasswordField(int type,JLabel lablel) {
		this.type = type;
		init();
	}

	public TouchPasswordField(String default_text,JLabel lablel) {
		this.def_text = default_text;
		init();
	}

	public TouchPasswordField(int type, String default_text,JLabel lablel) {
		this.type = type;
		this.def_text = default_text;
		init();
	}
	
	private void init() {
		if (is_empty) {
			field.setText(def_text);
                        field.setEchoChar('-');
			def_color = field.getForeground();
			field.setForeground(Color.GRAY);
		}
		this.addMouseListener(new MouseListener() {
                        @Override
			public void mouseClicked(MouseEvent e) {
				if (is_empty) field.setText("");
				switch (type) {
				case TYPE_KEYBOARD:
					field.setText(VPKey.showKeyboard(field.getText()));
					break;
				case TYPE_KEYPAD:
					field.setText(VPKey.showKeypad(field.getText()));
					break;
				default:
					field.setText(VPKey.showKeyboard(field.getText()));
					break;
				}
				if (field.getText().length() == 0) {
					field.setText(def_text);
					field.setForeground(Color.GRAY);
					is_empty = true;
				} else {
					field.setForeground(def_color);
					is_empty = false;
				}
			}
                        @Override
			public void mouseEntered(MouseEvent e) {}
                        @Override
			public void mouseExited(MouseEvent e) {}
                        @Override
			public void mousePressed(MouseEvent e) {}
                        @Override
			public void mouseReleased(MouseEvent e) {}
		});
		
	}
}
