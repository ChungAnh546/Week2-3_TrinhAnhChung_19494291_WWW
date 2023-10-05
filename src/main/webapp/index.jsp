<%@ page import="vn.edu.iuh.fit.backend.services.ProductService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    ProductService productService = new ProductService();
    List<Product> lst = productService.getAll();

%>
<h1><%= "Hello World dadsa!" %>
</h1>
<br/>
<table width="70%" align="centrel" border="1">
    <tr>
        <th>
            id
        </th>
        <th>
            name
        </th>
        <th>
            description
        </th>
        <th>
            unit
        </th>
        <th>
            manufacture
        </th>
        <th>
            status
        </th>

        <th colspan="2">
            <a href="">insert</a>
        </th>
    </tr>
    <%
        for (Product product : lst) {


    %>
    <tr>
        <td><%=product.getProduct_id() %>
        </td>
        <td><%=product.getName() %>
        </td>
        <td><%=product.getDescription() %>
        </td>
        <td><%=product.getUnit() %>
        </td>
        <td><%=product.getManufacturer_name() %>
        </td>
        <td><%=product.getStatus() %>
        </td>
        <td><a href="">Update</a></td>
        <td><a href="">Delete</a></td>
    </tr>

    <%}%>
</table>
<br/>
<a href="helloCC.jsp">Hello Servlet</a>
</body>
</html>