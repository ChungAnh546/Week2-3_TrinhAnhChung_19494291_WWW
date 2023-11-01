package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_image")
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long id;
    @Column(name = "product_id")
    private long product_id;
    @Column(name = "path")
    private String path;
    @Column(name = "alternative")
    private String alternative;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
