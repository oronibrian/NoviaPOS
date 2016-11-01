/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.service.pos.sale;

import java.util.List;
import ke.novia.dao.pos.sale.OrderDestinationDao;
import ke.novia.model.pos.sale.OrderDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDestinationService implements IOrderDestinationService {

    @Autowired
    OrderDestinationDao orderDestinationDao;

    @Override
    public List<OrderDestination> findAll() {
        return orderDestinationDao.findAll();
    }

    @Override
    public OrderDestination save(OrderDestination orderDestination) {
        return orderDestinationDao.save(orderDestination);
    }

}
