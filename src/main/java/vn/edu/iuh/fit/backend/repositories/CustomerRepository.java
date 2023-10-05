package vn.edu.iuh.fit.backend.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Customer;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;



public class CustomerRepository {
    @Inject
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger =
            (Logger) LoggerFactory.getLogger(this.getClass().getName());

    public CustomerRepository() {
        em = Persistence
                .createEntityManagerFactory("mysqlcc")
                .createEntityManager();
        trans = em.getTransaction();
    }

    public void insertCustomer(Customer c) {
       try {
           trans.begin();
           em.persist(c);
           trans.commit();
       }catch (Exception ex){
           trans.rollback();
           logger.error(ex.getMessage());
       }
    }

    public void updateCustomer(Customer c) {
        try {
            trans.begin();
            em.merge(c);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public Optional<Customer> findById(long id){
        TypedQuery<Customer> query = em.createQuery("select e from Customer e where e.id =:id ",Customer.class);
        query.setParameter("id",id);
        Customer customer = query.getSingleResult();
        return customer == null? Optional.empty():Optional.of(customer);
    }
    public List<Customer> getAllCustomer(){
        return em.createNamedQuery("Customer.findAll",Customer.class).getResultList();
    }
}
