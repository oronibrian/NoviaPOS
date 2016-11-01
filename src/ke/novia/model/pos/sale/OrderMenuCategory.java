/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.model.pos.sale;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author envy
 */
@Entity
@Table(name="ordermenucategory")//,catalog = "pos"
public class OrderMenuCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="orderdestination_id", nullable = false)
    private OrderDestination orderdestination;
    private String description;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    @Override
    public String toString() {
        return description;//"OrderMenuCategory{" + "id=" + id + ", description=" + description + '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderDestination getOrderdestination() {
        return orderdestination;
    }

    public void setOrderdestination(OrderDestination orderdestination) {
        this.orderdestination = orderdestination;
    }
}
