package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Product;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Product;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private EntityManager em;

    public ProductRepository() {
        em = Persistence
                .createEntityManagerFactory("mysql")
                .createEntityManager();
    }

    public void insertProduct(Product p) {
        em.persist(p);
    }

    public void updateProduct(Product p) {
        em.merge(p);
    }
    public Optional<Product> findById(long id){
        TypedQuery<Product> query = em.createQuery("select e from Product e where e.id =:id ",Product.class);
        query.setParameter("id",id);
        Product product = query.getSingleResult();
        return product == null? Optional.empty():Optional.of(product);
    }

    public List<Product> getAllProduct(){
        return em.createNamedQuery("Product.findAll",Product.class).getResultList();
    }
}
