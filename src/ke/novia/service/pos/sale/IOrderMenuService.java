
package ke.novia.service.pos.sale;

import ke.novia.model.pos.sale.*;
import java.util.List;


public interface IOrderMenuService {
    public List<OrderMenu> findAll();   
    public OrderMenu save(OrderMenu orderMenu);   
}
