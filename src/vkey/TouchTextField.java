package vkey;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TouchTextField extends JTextField{
	private int type = TYPE_KEYBOARD;
	public static final int TYPE_KEYBOARD = 1;
	public static final int TYPE_KEYPAD = 2;
	private String def_text = DEF_TEXT;
	private static final String DEF_TEXT = "Input a text";
	private boolean is_empty = true;
	private Color def_color;
	JTextField field = this;
	
	public TouchTextField() {
		init();
	}

	public TouchTextField(int type) {
		this.type = type;
		init();
	}

	public TouchTextField(String default_text) {
		this.def_text = default_text;
		init();
	}

	public TouchTextField(int type, String default_text) {
		this.type = type;
		this.def_text = default_text;
		init();
	}
	
	private void init() {
		if (is_empty) {
			field.setText(def_text);
			def_color = field.getForeground();
			field.setForeground(Color.GRAY);
		}
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if (is_empty) field.setText("");
				switch (type) {
				case TYPE_KEYBOARD:
					field.setText(VKey.showKeyboard(field.getText()));
					break;
				case TYPE_KEYPAD:
					field.setText(VKey.showKeypad(field.getText()));
					break;
				default:
					field.setText(VKey.showKeyboard(field.getText()));
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
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		
	}
}