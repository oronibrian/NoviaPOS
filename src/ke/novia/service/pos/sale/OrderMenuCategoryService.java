/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.service.pos.sale;
import ke.novia.model.pos.sale.*;
import java.util.List;
import ke.novia.dao.pos.sale.OrderMenuCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMenuCategoryService implements IOrderMenuCategoryService {

   @Autowired
    private OrderMenuCategoryDao orderMenuCategoryDao;

    @Override
    public List<OrderMenuCategory> findAll() {
        return orderMenuCategoryDao.findAll();  
    }

    @Override
    public OrderMenuCategory save(OrderMenuCategory ordermenu) {
        return orderMenuCategoryDao.save(ordermenu);
    }
}
