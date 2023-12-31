package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository repository;
    public CustomerService(){
        repository = new CustomerRepository();
    }
    public void insertCustomer(Customer customer) {
        repository.insertCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }

    public Optional<Customer> findById(long id) {
        return repository.findById(id);
    }

    public List<Customer> getAll() {
        return repository.getAllCustomer();
    }

    public void insertCust(Customer customer) {
    }

//    public boolean delete(long id) {
//        Optional<Customer> op = findById(id);
//        if (op.isPresent()) {
//            Customer e = op.get();
//            e.setStatus(CustomerStatus.TERMINATED);
//            return true;
//        }
//        return false;
//    }

//    public boolean activeCustomer(long id) {
//        Optional<Customer> op = findById(id);
//        if (op.isPresent()) {
//            Customer Customer = op.get();
//            Customer.setStatus(CustomerStatus.ACTIVE);
//            return true;
//        }
//        return false;
//    }

}
