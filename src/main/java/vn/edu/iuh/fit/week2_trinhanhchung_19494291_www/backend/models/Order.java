package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import org.joda.time.DateTime;


import java.util.List;

    @Data
    @Entity
    @Table(name = "orders")

    @NamedQueries(
            @NamedQuery(name = "Order.findAll",query = "select o from Order o")
    )
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @Column(name = "order_date",nullable = false)
    private DateTime order_date;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    @Column(name = "emp_id",nullable = false)
    private Employee emp_id;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    @Column(name = "cust_id",nullable = false)
    private Customer cust_id;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    List<OrderDetail> orderDetails;
}
