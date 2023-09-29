package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Employee;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.services.EmployeeService;

public class EmployeeModel {
private final EmployeeService services= new EmployeeService();
    public void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String full_name = req.getParameter("full_name");
        String dob1 = req.getParameter("dob");
        DateTime dob = new DateTime(dob1);
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String status = req.getParameter("status");
        Employee e = new Employee(full_name,dob,email,phone,address, EmployeeStatus.valueOf(status));
        services.insertEmployee(e);
        resp.sendRedirect("");

    }
}
