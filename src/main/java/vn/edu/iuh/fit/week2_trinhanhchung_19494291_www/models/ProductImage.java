package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long id;
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "path")
    private String path;
    @Column(name = "alternavtive")
    private String alternative;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
