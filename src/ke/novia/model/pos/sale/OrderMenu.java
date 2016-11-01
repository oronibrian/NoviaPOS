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
@Table(name="ordermenu")//,catalog = "pos"
public class OrderMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name="orderdestination_id", nullable = false)
    private OrderDestination orderdestination;
    
    @ManyToOne
    @JoinColumn(name="ordermenucategory_id", nullable = false)
    private OrderMenuCategory ordermenucategory;
    private String menuname;
    private String description;
    private String servingdetails;
    private double unitprice;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public OrderMenuCategory getOrdermenucategory() {
        return ordermenucategory;
    }

    public void setOrdermenucategory(OrderMenuCategory ordermenucategory) {
        this.ordermenucategory = ordermenucategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServingdetails() {
        return servingdetails;
    }

    public void setServingdetails(String servingdetails) {
        this.servingdetails = servingdetails;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public OrderDestination getOrderdestination() {
        return orderdestination;
    }

    public void setOrderdestination(OrderDestination orderdestination) {
        this.orderdestination = orderdestination;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    @Override
    public String toString() {
        return "OrderMenu{" + "id=" + id + ", orderdestination=" + orderdestination + ", ordermenucategory=" + ordermenucategory + ", menuname=" + menuname + ", description=" + description + ", servingdetails=" + servingdetails + ", unitprice=" + unitprice + '}';
    }
}
