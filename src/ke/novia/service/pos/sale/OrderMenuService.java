/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.service.pos.sale;

import ke.novia.model.pos.sale.*;
import java.util.List;
import ke.novia.dao.pos.sale.OrderMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMenuService implements IOrderMenuService {

    @Autowired
    private OrderMenuDao orderMenuDao;

    @Override
    public List<OrderMenu> findAll() {
        return orderMenuDao.findAll();  
    }

    @Override
    public OrderMenu save(OrderMenu orderMenu) {
       return orderMenuDao.save(orderMenu);
    }
}