<%--
  Created by IntelliJ IDEA.
  User: NGUYENVT
  Date: 9/16/17
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Account</title>
</head>
<body>
<h1 style="color: green">Welcome, ${sessionScope.ACCOUNT.name}</h1>
<form action="MainController" method="post">
    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="txtUsername" value="${sessionScope.ACCOUNT.username}" readonly></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="txtPassword" required></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="txtConfirm" required></td>
        </tr>
        <tr>
            <td>Full name:</td>
            <td><input type="text" name="txtName" value="${sessionScope.ACCOUNT.name}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="txtMail" value="${sessionScope.ACCOUNT.email}"></td>
        </tr>
    </table>
    <input type="hidden" name="txtRoleId" value="${sessionScope.ACCOUNT.roleId}">
    <input type="hidden" name="txtAccountId" value="${sessionScope.ACCOUNT.accountId}">
    <button type="submit" name="btnControl" value="Update Account">Update Account</button>
</form>
<nguyenvt:if test="${not empty requestScope.ERROR}">
    <h1 style="color: red">${requestScope.ERROR}</h1>
</nguyenvt:if>
</body>
</html>
