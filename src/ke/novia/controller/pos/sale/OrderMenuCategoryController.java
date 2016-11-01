package ke.novia.controller.pos.sale;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ke.novia.service.pos.sale.IOrderMenuCategoryService;
import ke.novia.view.pos.sale.OrderMenuCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMenuCategoryController {

    @Autowired
    IOrderMenuCategoryService orderMenuCategoryService;
OrderMenuCategoryServiceImpl form;
    class OrderMenuCategoryServiceImpl extends OrderMenuCategory {

        public OrderMenuCategoryServiceImpl(Frame parent, boolean modal) {
            super(parent, modal);
            btnAddCategory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    ke.novia.model.pos.sale.OrderMenuCategory cat
                            = new ke.novia.model.pos.sale.OrderMenuCategory();
                    cat.setDescription(description.getText());
                    orderMenuCategoryService.save(cat);
                    if(cat.getId()>0)
                        {
                        JOptionPane.showMessageDialog(OrderMenuCategoryServiceImpl.this, "Item Saved");
                    }
                    else{
                        JOptionPane.showMessageDialog(OrderMenuCategoryServiceImpl.this, "Error");
                    }
                }
            });
        }

    }
    public void openOrderWindow(JFrame parent){
        //System.err.println(iskitchenorder);
        form=new OrderMenuCategoryServiceImpl(parent, true);
        form.setVisible(true);
    }

}
