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
import ke.novia.service.pos.sale.IOrderStatusService;
import ke.novia.view.pos.sale.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusController {

    @Autowired
    IOrderStatusService orderStatus;
    OrderStatusImpl form;

    class OrderStatusImpl extends OrderStatus {

        public OrderStatusImpl(Frame parent, boolean modal) {
            super(parent, modal);
            btnAddStatus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    ke.novia.model.pos.sale.OrderStatus st
                            = new ke.novia.model.pos.sale.OrderStatus();
                    st.setStatus(status.getText());
                    orderStatus.save(st);
                    if(st.getId()>0)
                        {
                        JOptionPane.showMessageDialog(OrderStatusImpl.this, "Item Saved");
                    }
                    else{
                        JOptionPane.showMessageDialog(OrderStatusImpl.this, "Error");
                    }
                }
            });
        }

    }
    public void openOrderWindow(JFrame parent){
        //System.err.println(iskitchenorder);
        form=new OrderStatusImpl(parent, true);
        form.setVisible(true);
    }

}
