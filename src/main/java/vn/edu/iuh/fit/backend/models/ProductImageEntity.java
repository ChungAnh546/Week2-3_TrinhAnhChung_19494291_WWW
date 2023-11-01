package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image", schema = "week2", catalog = "")
public class ProductImageEntity {
    @Basic
    @Column(name = "product_id")
    private Integer productId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "image_id")
    private int imageId;
    @Basic
    @Column(name = "path")
    private String path;
    @Basic
    @Column(name = "alternative")
    private String alternative;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }
}
