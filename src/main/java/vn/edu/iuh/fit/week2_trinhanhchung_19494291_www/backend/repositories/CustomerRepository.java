package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Customer;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Customer;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager em;

    public CustomerRepository() {
        em = Persistence
                .createEntityManagerFactory("mysql")
                .createEntityManager();
    }

    public void insertCustomer(Customer c) {
       em.persist(c);
    }

    public void update(Customer c) {
        em.merge(c);
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
