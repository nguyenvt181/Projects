<%--
  Created by IntelliJ IDEA.
  User: NGUYENVT
  Date: 9/16/17
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<form action="MainController" method="post">
    <h1 style="color: green">Welcome, ${sessionScope.ACCOUNT.name}</h1>
    <button type="submit" name="btnControl" value="Logout">Log Uut</button>
</form>
<form action="MainController" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="txtUsername" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="txtPassword" required></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="txtConfirm" required></td>
        </tr>
        <tr>
            <td>Full name:</td>
            <td><input type="text" name="txtName" required></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="txtMail" required></td>
        </tr>
    </table>
    <button type="submit" name="btnControl" value="Insert Account">Register</button>
</form>
<nguyenvt:if test="${not empty requestScope.ERROR}">
    <h1 style="color: red">${requestScope.ERROR}</h1>
</nguyenvt:if>
</body>
</html>
