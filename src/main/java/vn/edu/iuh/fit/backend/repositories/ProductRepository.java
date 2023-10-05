package vn.edu.iuh.fit.backend.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    @Inject
    private EntityManager em;
    private final Logger logger =
            LoggerFactory.getLogger(this.getClass().getName());

    private EntityTransaction trans;

    public ProductRepository() {
        em = Persistence
                .createEntityManagerFactory("mysqlcc")
                .createEntityManager();
        trans = em.getTransaction();
    }

    public void insertProduct(Product p) {

        try {
            trans.begin();
            em.persist(p);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void updateProduct(Product p) {

        try {
            trans.begin();
            em.merge(p);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
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
