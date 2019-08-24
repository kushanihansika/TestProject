package lk.main.first.tech.entity;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "`Order`")
public class Order extends SuperEntitty{
@Id
private String Oid;
private Date date;

@ManyToOne
@JoinColumn(name = "customerId" ,referencedColumnName = "id")
private Customer customer;

    public Order() {
    }

    public Order(String oid, Date date, Customer customer) {
        Oid = oid;
        this.date = date;
        this.customer = customer;
    }

    public String getOid() {
        return Oid;
    }

    public void setOid(String oid) {
        Oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
