/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.model.pos.sale;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordermaster")//,catalog = "pos"
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String orderno;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    User user;//wiater
    String tableno;
    //@Temporal(TemporalType.DATE)
    java.sql.Timestamp orderdatetime;
    
    @ManyToOne
    @JoinColumn(name="orderdestination_id", nullable = false)
    private OrderDestination orderdestination;
    
    @ManyToOne
    @JoinColumn(name="orderstatus_id", nullable = false) 
    private OrderStatus orderstatus;
    String notes;
    
    public Long getId() {
        return id;
    }

    
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTableno() {
        return tableno;
    }

    public void setTableno(String tableno) {
        this.tableno = tableno;
    }

    public Timestamp getOrderdatetime() {
        return orderdatetime;
    }

    public void setOrderdatetime(Timestamp orderdatetime) {
        this.orderdatetime = orderdatetime;
    }

    public OrderStatus getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(OrderStatus orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderMaster)) {
            return false;
        }
        OrderMaster other = (OrderMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderMaster{" + "id=" + id + ", orderno=" + orderno + ", user=" + user + ", tableno=" + tableno + ", orderdatetime=" + orderdatetime + ", orderstatus=" + orderstatus + ", notes=" + notes + '}';
    }

    public OrderDestination getOrderdestination() {
        return orderdestination;
    }

    public void setOrderdestination(OrderDestination orderdestination) {
        this.orderdestination = orderdestination;
    }

    
}
