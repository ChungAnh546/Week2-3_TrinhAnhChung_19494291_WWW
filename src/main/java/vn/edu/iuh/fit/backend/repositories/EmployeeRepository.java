package vn.edu.iuh.fit.backend.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    // EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
    @Inject
    private EntityManager em;// = emf.createEntityManager();
    private final Logger logger =
            LoggerFactory.getLogger(this.getClass().getName());
    private EntityTransaction trans;

    // Your JPA code here

//        em.close();
//        emf.close();

    public EmployeeRepository() {
        em = Persistence
                .createEntityManagerFactory("mysqlcc")
                .createEntityManager();
        trans = em.getTransaction();
    }

    public void insertEmployee(Employee e) {

        try {
            trans.begin();
            em.persist(e);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void setStatus(Employee e, EmployeeStatus status) {
        e.setStatus(status);
    }

    public void updateEmployee(Employee e) {
        try {
            trans.begin();
            em.merge(e);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            logger.error(ex.getMessage());
        }

    }

    public Optional<Employee> findById(long id) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.id =:id ", Employee.class);
        query.setParameter("id", id);
        Employee employee = query.getSingleResult();
        return employee == null ? Optional.empty() : Optional.of(employee);
    }

    public List<Employee> getAllEmployee() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
