<%--
  Created by IntelliJ IDEA.
  User: nguyenvt181
  Date: 8/31/17
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register Account</title>
</head>
<body>
<form action="MainController" method="post">
    <h1 style="color: red">Register New Account</h1>
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="txtUsername" required minlength="3" maxlength="15"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="txtPassword" required minlength="3" maxlength="15"></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="txtConfirm" required minlength="3" maxlength="15"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="txtName" required minlength="6" maxlength="50"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="txtMail" required min="10" maxlength="50"></td>
        </tr>
    </table>
    <button type="submit" name="btnControl" value="Insert Account">Register</button>
</form>
<nguyenvt:if test="${not empty requestScope.RESULT}">
    <h2 style="color: aqua">${requestScope.RESULT}</h2>
</nguyenvt:if>
</body>
</html>
