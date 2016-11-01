/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.service.pos.sale;
import ke.novia.model.pos.sale.User;
import java.util.List;
import ke.novia.dao.pos.sale.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

   @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User ordermenu) {
        return userDao.save(ordermenu);
    }
}
