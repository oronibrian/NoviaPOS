/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.controller.pos.sale;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ke.novia.service.pos.sale.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author oroni
 *
 *
 */
@Component

public class UserController {

    @Autowired
    IUserService userService;
    Userimp form;

    class Userimp extends ke.novia.view.pos.sale.User {

        public Userimp(Frame parent, boolean modal) {
            super(parent, modal);
            adduser.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ke.novia.model.pos.sale.User user = new ke.novia.model.pos.sale.User();

                    user.setFirstname(firstname.getText());
                    user.setLastname(lastname.getText());
                    user.setPost((String) post.getSelectedItem());
                    user.setPin(pin.getText());
                    userService.save(user);

                    if (user.getId() > 0) {
                        JOptionPane.showMessageDialog(UserController.Userimp.this, "Order Saved");

                    } else {
                        JOptionPane.showMessageDialog(UserController.Userimp.this, "Error");
                    }

                }

            });

        }

    }

    public void openUserWindow(JFrame parent) {

        form = new UserController.Userimp(parent, true);
        form.setVisible(true);
    }

}
