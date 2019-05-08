package com.mycompany.golf_website;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MenuItemService {

    @PersistenceContext
    private EntityManager em;
    
    public List<MenuItem> selectAll() {
        TypedQuery<MenuItem> q = em.createNamedQuery("MenuItem.selectAll", MenuItem.class);
        return q.getResultList();
    }
    
    public void persist(MenuItem menuitem) {
        em.persist(menuitem);
    }
}
