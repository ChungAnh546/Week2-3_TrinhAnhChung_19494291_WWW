package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "product_price", schema = "week2", catalog = "")
public class ProductPriceEntity {
    @Basic
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "price_date_time")
    private Timestamp priceDateTime;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "note")
    private String note;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Timestamp getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(Timestamp priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
