/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.service.pos.sale;

import ke.novia.model.pos.sale.OrderStatus;
import java.util.List;
import ke.novia.dao.pos.sale.OrderStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusService implements IOrderStatusService {

    @Autowired
    private OrderStatusDao orderStatusDao;

    @Override
    public List<OrderStatus> findAll() {
        return orderStatusDao.findAll();
    }

    @Override
    public OrderStatus save(OrderStatus orderStatus) {
        return orderStatusDao.save(orderStatus);
    }
}
