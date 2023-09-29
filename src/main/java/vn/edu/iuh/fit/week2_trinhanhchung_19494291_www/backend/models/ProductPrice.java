package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.pks.ProductPricePK;

@Data
@Entity
@Table(name= "product_price")
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
