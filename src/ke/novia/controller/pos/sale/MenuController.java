package ke.novia.controller.pos.sale;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ke.novia.model.pos.sale.OrderDestination;
import ke.novia.model.pos.sale.OrderMenuCategory;
import ke.novia.service.pos.sale.IOrderDestinationService;
import ke.novia.service.pos.sale.IOrderMenuCategoryService;
import ke.novia.service.pos.sale.IOrderMenuService;
import org.springframework.stereotype.Component;
import ke.novia.view.pos.sale.OrderMenu;
import org.springframework.beans.factory.annotation.Autowired;
@Component
public class MenuController {
    @Autowired
    IOrderDestinationService orderDestinationService; 
    
    @Autowired
    IOrderMenuCategoryService orderMenuCategoryService; 
    
    @Autowired
    IOrderMenuService orderMenuService; 
    
    OrderMenuImpl form;
    List<OrderDestination> orderdestinations = null;
    List<OrderMenuCategory>  ordermenucategories = null;
    
    class OrderMenuImpl extends OrderMenu{
        public OrderMenuImpl(Frame parent, boolean modal) {
            super(parent, modal);
            if(orderdestinations!=null && orderdestinations.size()>0){
                JComboBox lo = new JComboBox();
                for(OrderDestination orderdestination : orderdestinations){
                    lo.addItem(orderdestination);
                }
                orderdestination_id.setModel(lo.getModel());
            }

            if(ordermenucategories!=null && ordermenucategories.size()>0){
                JComboBox lo = new JComboBox();
                for(OrderMenuCategory ordermenucategory : ordermenucategories){
                    lo.addItem(ordermenucategory);
                }
                ordermenucategory_id.setModel(lo.getModel());
            }   
            
            btnSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ke.novia.model.pos.sale.OrderMenu menu =new ke.novia.model.pos.sale.OrderMenu();
                    //menu.setId(0);
                    menu.setDescription(description.getText());
                    menu.setMenuname(menuname.getText());
                    menu.setOrderdestination((OrderDestination) orderdestination_id.getSelectedItem());
                    menu.setOrdermenucategory((OrderMenuCategory) ordermenucategory_id.getSelectedItem());
                    menu.setServingdetails(servingdetails.getText());
                    menu.setUnitprice(helpers.Arithmetic.strToLong(unitprice.getText()));
                    orderMenuService.save(menu);
                    if(menu.getId()>0){
                        JOptionPane.showMessageDialog(OrderMenuImpl.this, "Item Saved");
                    }
                    else{
                        JOptionPane.showMessageDialog(OrderMenuImpl.this, "Error");
                    }
                }
            });
        }
    }

    public MenuController(){}
    public void openOrderWindow(JFrame parent){
        orderdestinations=orderDestinationService.findAll();
        ordermenucategories=orderMenuCategoryService.findAll();
        
        form = new OrderMenuImpl(parent, true);
        form.setVisible(true);
    }
    
}
