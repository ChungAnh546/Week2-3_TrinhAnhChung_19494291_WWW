package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.models;

import jakarta.persistence.*;
import lombok.Data;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.pks.OrderDetailPK;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailPK pk;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "price")
    private double price;
    @Column(name = "note",length = 500)
    private String note;
    @ManyToOne
    @JoinColumn(name ="order_id" )
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
