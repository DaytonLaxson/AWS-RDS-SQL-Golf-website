package com.mycompany.golf_website;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerOrder")
@NamedQueries({
    @NamedQuery(name = "Customer.selectAll", query = "select o from CustomerOrder o"),
    @NamedQuery(name="Customer.findByName", query="select o from CustomerOrder o WHERE o.customerName = :customerName"),
    @NamedQuery(name="Customer.findNamebyLargestId", query="select o.customerName from CustomerOrder o WHERE o.id = (select MAX(o.id) FROM CustomerOrder o)")
})
public class CustomerOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 25)
    private String customerName;
    
    @Column(length = 25)
    private String itemName;
    
    @Column(length = 25)
    private String price;
    
    @Column(length = 25)
    private String itemQuantity;
    
    @Column(length = 11)
    private Long phoneNumber;
    
    @Column(length = 16)
    private Long creditNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(Long creditNumber) {
        this.creditNumber = creditNumber;
    }



    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CustomerOrder) {
            CustomerOrder that = (CustomerOrder) obj;
            return Objects.equals(id, that.id);
        }
        return false;
    }
    
}
