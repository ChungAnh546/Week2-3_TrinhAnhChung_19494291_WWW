package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.services;

import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.models.Employee;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService() {
        repository = new EmployeeRepository();
    }

    public void insertEmployee(Employee employee) {
        repository.insertEmployee(employee);
    }

    public Optional<Employee> findById(long id) {
        return repository.findById(id);
    }
    public List<Employee> getAll() {
        return repository.getAllEmployee();
    }
    public boolean delete(long id) {
        Optional<Employee> op = findById(id);
        if (op.isPresent()) {
            Employee e = op.get();
            e.setStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }

    public boolean activeEmployee(long id) {
        Optional<Employee> op = findById(id);
        if(op.isPresent())
        {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }
}
