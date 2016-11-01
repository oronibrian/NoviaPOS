
package ke.novia.service.pos.sale;

import ke.novia.model.pos.sale.OrderDetail;
import java.util.List;
import ke.novia.dao.pos.sale.OrderDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderDetailService implements IOrderDetailService{
     @Autowired
        private OrderDetailDao orderDetailDao;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailDao.findAll();  
    }
}
