package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
@NamedQueries(
        @NamedQuery(name = "Product.findAll",query = "select p from Product p where p.status = 1")
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long product_id;
    @Column(name = "name",length = 150,nullable = false)
    private String name;
    @Column(name = "description",length = 400,nullable = false)
    private String description;
    @Column(name = "unit",nullable = false)
    private String unit;
    @Column(name="manufacturer_name",nullable = false)
    private String manufacturer_name;
    @Column (name = "status",nullable = false)
    private ProductStatus status;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<ProductImage> productImageList;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<ProductPrice> productPrices;
    @OneToOne(mappedBy = "productOne")
    private ProductPrice productPrice;
}
