package com.mycompany.golf_website;

import com.mycompany.golf_website.CustomerOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CustomerOrderService {

    @PersistenceContext
    private EntityManager em;

    public List<CustomerOrder> selectAll() {
        TypedQuery<CustomerOrder> q = em.createNamedQuery("Customer.selectAll", CustomerOrder.class);
        return q.getResultList();
    }

    public List<CustomerOrder> findByName(String name) {
        TypedQuery<CustomerOrder> q = em.createNamedQuery("Customer.findByName", CustomerOrder.class)
                .setParameter("customerName", name);
        return q.getResultList();
    }

    public String findLastOrder() {
        TypedQuery<String> q = em.createNamedQuery("Customer.findNamebyLargestId", String.class);
        List<String> results = q.getResultList();
        String name = (String) results.get(0);
        return name;
    }
    
    public void persist(CustomerOrder user) {
        em.persist(user);
    }
}
