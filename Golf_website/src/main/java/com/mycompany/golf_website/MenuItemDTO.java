package com.mycompany.golf_website;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MenuItemDTO {

    private Long id;
    private String name;
    private BigDecimal price;

    public MenuItemDTO() {
    }

    public MenuItemDTO(MenuItem m) {
        id = m.getId();
        name = m.getName();
        price = m.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
