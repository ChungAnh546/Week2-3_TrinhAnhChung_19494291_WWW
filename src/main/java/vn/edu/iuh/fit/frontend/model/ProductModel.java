package vn.edu.iuh.fit.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.enums.ProductStatus;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.services.ProductService;


public class ProductModel {
    private final ProductService services =new ProductService();
    public void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        String unit = req.getParameter("unit");
        String manu = req.getParameter("manu");
        String status = req.getParameter("status");

        Product product =new Product(name,desc,unit,manu, ProductStatus.valueOf(status));
        services.insertProduct(product);
        resp.sendRedirect("products.jsp");
    }

    public void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        long id =Long.parseLong(req.getParameter("id"));
        services.updateStatus(id, ProductStatus.IN_ACTION);
        resp.sendRedirect("products.jsp");
    }
}