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
import ke.novia.service.pos.sale.IOrderDestinationService;
import ke.novia.view.pos.sale.OrderDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class OrderDestinationController {
    @Autowired
    IOrderDestinationService orderDestinationService;
    OrderDestination orderDestination;
    OrderDestinationImpl form;
    class OrderDestinationImpl extends OrderDestination
    {
        
        public OrderDestinationImpl(Frame parent, boolean modal) {
            super(parent, modal);
            
            //click event
            btnSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    ke.novia.model.pos.sale.OrderDestination dest
                            = new ke.novia.model.pos.sale.OrderDestination();
                    dest.setDestination(destination.getText());
                    dest.setDescription(description.getText());
                    orderDestinationService.save(dest);
                    if(dest.getId()>0)
                        {
                        JOptionPane.showMessageDialog(OrderDestinationImpl.this, "Item Saved");
                    }
                    else{
                        JOptionPane.showMessageDialog(OrderDestinationImpl.this, "Error");
                    }
                    
                }
            });
        }
        
    }
    public void openOrderWindow(JFrame parent){
        //System.err.println(iskitchenorder);
        form=new OrderDestinationImpl(parent, true);
        form.setVisible(true);
    }
    
}
