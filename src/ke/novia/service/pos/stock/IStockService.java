/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.service.pos.stock;

import java.util.List;
import ke.novia.model.pos.stock.Stockitem;

public interface IStockService {
    public List<Stockitem> findAll();
    public Stockitem findById(long id);
    public List<Stockitem> findByKeyword(String column,String keyword);
    public Stockitem insert(Stockitem stockitem);
    public Stockitem update(Stockitem stockitem);
    public boolean deleteById(long id);
}
