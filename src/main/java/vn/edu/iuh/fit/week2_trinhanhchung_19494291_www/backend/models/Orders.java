package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import org.joda.time.DateTime;


@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @Column(name = "order_date")
    private DateTime order_date;
    @Column(name = "emp_id")
    private int emp_id;
    @Column(name= "cust_id")
    private int cust_id;


}
