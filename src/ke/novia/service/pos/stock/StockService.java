package ke.novia.service.pos.stock;

import java.util.List;
import ke.novia.dao.pos.stock.StockDao;
import ke.novia.model.pos.stock.Stockitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StockService implements IStockService{
    @Autowired
    StockDao stockDao;
    
    @Override
    public List<Stockitem> findAll() {
       return stockDao.findAll();
    }

    @Override
    public Stockitem findById(long id) {
        return stockDao.findOne(id);
    }

    @Override
    public List<Stockitem> findByKeyword(String column, String keyword) {
        return null;
    }

    @Override
    public Stockitem insert(Stockitem stockitem) {
        return stockDao.save(stockitem);
    }

    @Override
    public Stockitem update(Stockitem stockitem) {
        return stockDao.save(stockitem);
    }

    @Override
    public boolean deleteById(long id) {
        stockDao.delete(id);
        Stockitem deleted=stockDao.findOne(id);
        System.err.println(deleted);
        return deleted!=null;
    }
    
}
