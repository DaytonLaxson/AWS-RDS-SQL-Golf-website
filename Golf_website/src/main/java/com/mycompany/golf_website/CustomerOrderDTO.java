package com.mycompany.golf_website;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerOrderDTO {

    private Long id;
    private String customerName;
    private String itemName;
    private String itemQuantity;
    private String price;
    private Long phoneNumber;
    private Long creditNumber;

    public CustomerOrderDTO() {
    }
    
    public CustomerOrderDTO(Long id, String customerName, String itemName, String itemQuantity, String price, Long phoneNumber, Long creditNumber) {
        this.id = id;
        this.customerName = customerName;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.creditNumber = creditNumber;
    }
    
    public CustomerOrderDTO(CustomerOrder m) {
        id = m.getId();
        customerName = m.getCustomerName();
        phoneNumber = m.getPhoneNumber();
        creditNumber = m.getCreditNumber();
        itemName = m.getItemName();
        itemQuantity = m.getItemQuantity();
        price = m.getPrice();
    }

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

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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


}
