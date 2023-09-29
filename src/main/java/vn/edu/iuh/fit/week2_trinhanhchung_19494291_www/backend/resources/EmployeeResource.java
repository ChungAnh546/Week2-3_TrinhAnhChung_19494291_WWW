package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Employee;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Path("/employee")
public class EmployeeResource {
    private EmployeeService employeeService;

    public EmployeeResource() {
        employeeService = new EmployeeService();
    }

    @GET
    @Path(("/{id}"))
    @Produces("application/json")
    public Response GetEmployee(@PathParam("id") long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            return Response.ok(employee).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Employee> employees = employeeService.getAll();
        return Response.ok(employees).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee) {
        employeeService.insertEmployee(employee);
        return Response.ok(employee).build();
    }

    @DELETE
    @Path(("/{id}"))
    public Response delete(@PathParam("id") long id) {
        if(employeeService.delete(id)){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
