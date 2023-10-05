package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.backend.pks.OrderDetailPK;

@Data
@Entity
@Table(name = "order_detail")
@NoArgsConstructor
@AllArgsConstructor
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
