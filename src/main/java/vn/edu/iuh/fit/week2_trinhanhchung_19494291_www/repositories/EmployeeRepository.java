package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
   // EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
    private EntityManager em;// = emf.createEntityManager();

    // Your JPA code here

//        em.close();
//        emf.close();

    public EmployeeRepository() {
        em = Persistence
                .createEntityManagerFactory("mysql")
                .createEntityManager();
    }

    public void insertEmployee(Employee e) {
        em.persist(e);
    }
    public void setStatus(Employee e, EmployeeStatus status) {
     e.setStatus(status);
    }
    public void updateEmployee (Employee e){
        em.merge(e);
    }
    public Optional<Employee> findById(long id){
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.id =:id ",Employee.class);
        query.setParameter("id",id);
        Employee employee = query.getSingleResult();
        return employee == null? Optional.empty():Optional.of(employee);
    }
    public List<Employee> getAllEmployee(){
        return em.createNamedQuery("Employee.findAll",Employee.class).getResultList();
    }
}
