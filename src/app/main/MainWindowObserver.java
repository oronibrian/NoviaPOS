package app.main;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public interface MainWindowObserver
{
    void selectMenuItem(JMenuItem item);
    void selectComboBoxItem(JComboBox item);
    void clickButton(JButton button);
    void textFieldAction(JTextField textfield);
}
