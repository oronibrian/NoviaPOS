/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.service.pos.sale;
import ke.novia.model.pos.sale.*;
import java.util.List;

/**
 *
 * @author Grand Muller
 */
public interface IOrderMenuCategoryService {
    public List<OrderMenuCategory> findAll();
    public OrderMenuCategory save(OrderMenuCategory ordermenu);
}
