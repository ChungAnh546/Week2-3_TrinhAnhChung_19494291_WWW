package vn.edu.iuh.fit.backend;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newPage = "/helloCC.jsp"; // Địa chỉ trang muốn chuyển đến
        response.sendRedirect(request.getContextPath() + newPage);
    }


}