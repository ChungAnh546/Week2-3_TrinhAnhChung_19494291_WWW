package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private OrderRepository repository;
    public OrderService(){
        repository = new OrderRepository();
    }
    public void insertOrder(Order order) {
        repository.insertOrder(order);
    }

    public void updateOrder(Order order) {
        repository.updateOrder(order);
    }

    public Optional<Order> findById(long id) {
        return repository.findById(id);
    }

    public List<Order> getAll() {
        return repository.getAllOrder();
    }

//    public boolean delete(long id) {
//        Optional<Order> op = findById(id);
//        if (op.isPresent()) {
//            Order e = op.get();
//            e.setStatus(OrderStatus.TERMINATED);
//            return true;
//        }
//        return false;
//    }

//    public boolean activeOrder(long id) {
//        Optional<Order> op = findById(id);
//        if (op.isPresent()) {
//            Order Order = op.get();
//            Order.setStatus(OrderStatus.ACTIVE);
//            return true;
//        }
//        return false;
//    }
}
