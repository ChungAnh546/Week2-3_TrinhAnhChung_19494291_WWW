
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.services.ProductService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/23/2023
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products Listing</title>
</head>
<body>
<%
    ProductService productServices =new ProductService();
    List<Product> lst = productServices.getAll();
%>
<table width="70%" align="center" border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Unit</th>
        <th>Manufacturer:</th>
        <th>Status</th>
        <th colspan="2"><a href="insertProduct.jsp">Insert</a> </th>
    </tr>
    <%for(Product product: lst){
        long id =product.getProduct_id();
        String delete_string = "controls?action=delete_product&id="+id;
        String edit_string = "controls?action=edit_product&id="+id;
    %>
    <tr>
        <td><%=id%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getDescription()%></td>
        <td><%=product.getUnit()%></td>
        <td><%=product.getManufacturer_name()%></td>
        <td><%=product.getStatus()%></td>
        <td><a href=<%=edit_string%>>Update</a> </td>
        <td><a href=<%=delete_string%>>Delete</a> </td>
    </tr>

    <%}%>
</table>
</body>
</html>