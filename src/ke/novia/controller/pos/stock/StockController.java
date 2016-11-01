package ke.novia.controller.pos.stock;

import ke.novia.service.pos.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class StockController {
    @Autowired
    StockService stockService;
    
    public void getAll(){
        System.err.println(stockService.findAll());
    }
    
}
