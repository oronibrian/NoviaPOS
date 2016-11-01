package ke.novia.controller.pos.sale;

import javax.swing.JFrame;
import org.springframework.stereotype.Component;
import ke.novia.view.pos.sale.OrderForm;
@Component
public class OrderController {
    OrderForm orderForm;
    boolean iskitchenorder=false;
    public OrderController(){}
    public void setIsKitchen(boolean iskitchenorder){this.iskitchenorder=iskitchenorder;}
    public void openOrderWindow(JFrame parent){
        //System.err.println(iskitchenorder);
        orderForm=new OrderForm(parent, true);
        orderForm.setVisible(true);
    }
}
