package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Customer;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.services.CustomerService;

import java.util.List;
import java.util.Optional;

@Path("/customer")
public class CustomerResource {
    private CustomerService customerService;

    public CustomerResource() {
        customerService = new CustomerService();
    }

    @GET
    @Path(("/{id}"))
    @Produces("application/json")
    public Response GetCustomer(@PathParam("id") long id) {
        Optional<Customer> Customer = customerService.findById(id);
        if (Customer.isPresent()) {
            return Response.ok(Customer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Customer> customers = customerService.getAll();
        return Response.ok(customers).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Customer customer) {
        customerService.insertCustomer(customer);
        return Response.ok(customer).build();
    }
}
