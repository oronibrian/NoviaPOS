/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.service.pos.sale;
import ke.novia.model.pos.sale.*;
import ke.novia.dao.pos.sale.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMasterService implements IOrderMasterService {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    public List<OrderMaster> findAll() {
        return orderMasterDao.findAll();  
    }

}
