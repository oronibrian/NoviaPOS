package ke.novia.service.pos.sale;
import java.util.List;
import ke.novia.model.pos.sale.OrderDestination;


public interface IOrderDestinationService {
    public List<OrderDestination> findAll();
        public OrderDestination save(OrderDestination orderDestination);   

    
}
