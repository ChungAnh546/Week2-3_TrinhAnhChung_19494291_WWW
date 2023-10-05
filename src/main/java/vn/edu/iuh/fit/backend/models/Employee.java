package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;

import java.util.List;

@Data
@Entity

@Table(name = "employee")
@NamedQueries(
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e where e.status = 1")
)

@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name", length = 150, nullable = false)
    private String fullname;
    @Column(name = "dob", nullable = false)
    private DateTime dob;
    @Column(name = "email", unique = true, length = 150)
    private String email;
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;
    @Column(name = "address", length = 250, nullable = false)
    private String address;
    @Column(name = "status", nullable = false)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "emp_id", cascade = CascadeType.ALL)
    private List<Order> LstOrder;


    public Employee(String fullName, DateTime dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullname = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee() {

    }
}
