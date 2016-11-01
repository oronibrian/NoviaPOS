package vkey;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class SingleKey extends JButton{
	public int index;
	public int row;
	public int col;
	public String special;
	public String lang1;
	public String lang1up;
	public String lang2;
	public String lang2up;
	public float width;
	public float sizefactor;
	
	public boolean isSpecial() {
		return (special == null) ? false : true;
	}
}
