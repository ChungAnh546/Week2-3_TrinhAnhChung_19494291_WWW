<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/23/2023
  Time: 7:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Employee</title>
</head>
<body>
<h1 align="center">INSERT NEW EMPLOYEE</h1>
<div align="center" width="80%" >
<form action="controls?action=insertEmp" method="post" >
    <table width="20%" align="center">
        <tr>
            <td> <%--@declare id="name"--%><label for="name" width = "30%">Full Name:</label> </td>
            <td>  <input name="name"/><br/></td>
        </tr>
        <tr>
            <td> <%--@declare id="dob"--%><label for="dob" width = "30%">Date of birth:</label></td>
            <td>  <input name="dob"/><br/></td>
        </tr>
        <tr>
            <td><%--@declare id="email"--%><label for="email" width = "30%">Email:</label> </td>
            <td> <input name="email"/><br/></td>
        </tr>
        <tr>
            <td>  <%--@declare id="phone"--%><label for="phone" width = "30%"> Phone:</label> </td>
            <td><input name="phone"/><br/></td>
        </tr>
        <tr>
            <td>  <%--@declare id="address"--%><label for="address" width = "30%">Address:</label>  </td>
            <td> <textarea name="address" cols="30" rows="3"></textarea><br/></td>
        </tr>
        <tr>
            <td>   <input type="submit" value="Insert new Employee"/></td>

           <td> <input type="reset" value="Clear"/></td>

        </tr>




    </table>
</form></div>
</body>
</html>