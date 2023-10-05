package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.backend.pks.ProductPricePK;

@Data
@Entity
@Table(name= "product_price")
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {
    @EmbeddedId
    private ProductPricePK pk;
    @Column(name="price",nullable = false)
    private double price;
    @Column(name = "note" ,length = 500)
    private String note;
    @ManyToOne
    @JoinColumn(name ="product_id" )
    private Product product;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product productOne;
}
