
package ke.novia.service.pos.sale;

import java.util.List;
import ke.novia.model.pos.sale.*;

public interface IUserService {
    public List<User> findAll();

    public User save(User user);
    
}
