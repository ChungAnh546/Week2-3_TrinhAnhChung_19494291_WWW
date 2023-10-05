package vn.edu.iuh.fit.backend.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Order;

import java.util.List;
import java.util.Optional;

public class OrderRepository {
    @Inject
    private EntityManager em;
    private final Logger logger =
            LoggerFactory.getLogger(this.getClass().getName());
    private EntityTransaction trans;

    public OrderRepository() {
        em = Persistence
                .createEntityManagerFactory("mysqlcc")
                .createEntityManager();
        trans = em.getTransaction();
    }

    public void insertOrder(Order o) {

        try {
            trans.begin();
            em.persist(o);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public void updateOrder(Order o) {
       try {
            trans.begin();
            em.merge(o);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
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
