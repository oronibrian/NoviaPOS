
package ke.novia.service.pos.sale;

import ke.novia.model.pos.sale.*;
import java.util.List;

public interface IOrderMasterService {
    public List<OrderMaster> findAll();;

    public OrderMaster save(OrderMaster orderMaster);
    
}
