package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "customer")
@NamedQueries(
        @NamedQuery(name = "Customer.findAll",query = "select c from Customer c")
)
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long id;
    @Column(name = "cust_name",length = 150,nullable = false)
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone",length = 15)
    private String phone;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "cust_id",cascade = CascadeType.ALL)
    private List<Order> orderList;

}
