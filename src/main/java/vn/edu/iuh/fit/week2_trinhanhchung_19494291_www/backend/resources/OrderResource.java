package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Order;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.services.OrderService;

import java.util.List;
import java.util.Optional;

@Path("/order")
public class OrderResource {
    private OrderService orderService;

    public OrderResource() {
        orderService = new OrderService();
    }

    @GET
    @Path(("/{id}"))
    @Produces("application/json")
    public Response GetOrder(@PathParam("id") long id) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            return Response.ok(order).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Order> orders = orderService.getAll();
        return Response.ok(orders).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Order order) {
        orderService.insertOrder(order);
        return Response.ok(order).build();
    }

//    @DELETE
//    @Path(("/{id}"))
//    public Response delete(@PathParam("id") long id) {
//        if(OrderService.delete(id)){
//            return Response.ok().build();
//        }
//        return Response.status(Response.Status.NOT_FOUND).build();
//    }
}
