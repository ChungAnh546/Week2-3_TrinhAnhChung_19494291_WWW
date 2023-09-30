package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Product;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.services.ProductService;

import java.util.List;
import java.util.Optional;

@Path("/product")
public class ProductResource {

    private ProductService productService;


    public ProductResource() {
        productService = new ProductService();
    }
    @GET
    @Path(("/{id}"))
    @Produces("application/json")
    public Response GetProduct(@PathParam("id") long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return Response.ok(product).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Product> products = productService.getAll();
        return Response.ok(products).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product product) {
        productService.insertProduct(product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path(("/{id}"))
    public Response delete(@PathParam("id") long id) {
        if(productService.delete(id)){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
