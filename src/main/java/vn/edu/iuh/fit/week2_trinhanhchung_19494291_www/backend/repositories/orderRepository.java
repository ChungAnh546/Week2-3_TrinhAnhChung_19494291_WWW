package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Order;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Order;

import java.util.List;
import java.util.Optional;

public class orderRepository {
    private EntityManager em;

    public orderRepository() {
        em = Persistence
                .createEntityManagerFactory("mysql")
                .createEntityManager();
    }

    public void insertOrder(Order o) {
        em.persist(o);
    }
    public void updateOrder(Order o) {
        em.merge(o);
    }
    public Optional<Order> findById(long id){
        TypedQuery<Order> query = em.createQuery("select o from Order o where o.id =:id",Order.class);
        query.setParameter("id",id);
        Order order = query.getSingleResult();
        return  order == null? Optional.empty():Optional.of(order);
    }
    public List<Order> getAllOrder(){
        return em.createNamedQuery("Order.findAll",Order.class).getResultList();
    }
}
