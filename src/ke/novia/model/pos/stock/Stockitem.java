/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.model.pos.stock;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="item")
public class Stockitem {
    @Id
    private int id;
    private int category_id;
    private String name;
    private int qnt;
    private String cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Stockitem{" + "id=" + id + ", category_id=" + category_id + ", name=" + name + ", qnt=" + qnt + ", cost=" + cost + '}';
    }
    
}
