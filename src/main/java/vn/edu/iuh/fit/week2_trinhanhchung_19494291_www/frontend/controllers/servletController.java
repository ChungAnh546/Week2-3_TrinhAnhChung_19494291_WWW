package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.models.Employee;

import java.io.IOException;

@WebServlet("/controls")
public class servletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        try {
            Object actionObject = req.getParameter("action");
            if(actionObject !=null){
                String action = actionObject.toString();
                if(action.equals("insertEmployee")){

                    EmployeeModel
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}