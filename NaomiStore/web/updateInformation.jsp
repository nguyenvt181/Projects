<%--
  Created by IntelliJ IDEA.
  User: nguyenvt181
  Date: 8/31/17
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Information</title>
</head>
<body>
<h1>Update Information</h1>
<form action="MainController" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="txtUsername" value="${sessionScope.ACCOUNT.username}" readonly></td>
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
            <td>Name:</td>
            <td><input type="text" name="txtName" value="${sessionScope.ACCOUNT.name}" required></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="txtEmail" value="${sessionScope.ACCOUNT.email}" required></td>
        </tr>
    </table>
    <input type="hidden" name="txtId" value="${sessionScope.ACCOUNT.accountId}"><br>
    <input type="hidden" name="txtRole" value="${sessionScope.ACCOUNT.role}"><br>
    <button type="submit" name="btnControl" value="Update Account">Update Information</button>
</form>
<nguyenvt:if test="${not empty requestScope.RESULT}">
    <h2 style="color: red">${requestScope.RESULT}</h2>
</nguyenvt:if>
</body>
</html>
