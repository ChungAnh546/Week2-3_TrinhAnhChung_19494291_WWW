package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.services;

import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Product;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository repository;
    public ProductService(){
        repository = new ProductRepository();
    }
    public void insertProduct(Product product) {
        repository.insertProduct(product);
    }

    public void updateProduct(Product product) {
        repository.updateProduct(product);
    }

    public Optional<Product> findById(long id) {
        return repository.findById(id);
    }

    public List<Product> getAll() {
        return repository.getAllProduct();
    }

    public boolean delete(long id) {
        Optional<Product> op = findById(id);
        if (op.isPresent()) {
            Product e = op.get();
            e.setStatus(ProductStatus.CEASE);
            return true;
        }
        return false;
    }

    public boolean activeProduct(long id) {
        Optional<Product> op = findById(id);
        if (op.isPresent()) {
            Product product = op.get();
            product.setStatus(ProductStatus.ACTION);
            return true;
        }
        return false;
    }
}
