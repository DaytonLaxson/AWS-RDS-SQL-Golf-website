package com.mycompany.golf_website;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class InitService {

    @EJB
    private MenuItemService menuItemService;

    @PostConstruct
    public void init() {
        List<MenuItem> menuitems = menuItemService.selectAll();
        if (menuitems.isEmpty()) {
            insertMenuItem("Bucket of Beers", "4.99");
            insertMenuItem("Bucket of Balls", "9.99");
            insertMenuItem("Combo #1", "12.99");
            insertMenuItem("Combo #2", "14.99");
        }
    }

    private void insertMenuItem(String name, String price) {
        MenuItem MI = new MenuItem();
        MI.setName(name);
        MI.setPrice(new BigDecimal(price));
        menuItemService.persist(MI);
    }
}
