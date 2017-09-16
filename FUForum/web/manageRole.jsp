<%--
  Created by IntelliJ IDEA.
  User: NGUYENVT
  Date: 9/16/17
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manage Role</title>
</head>
<body>
<form action="MainController" method="post">
    <h1 style="color: green">Welcome, ${sessionScope.ACCOUNT.name}</h1>
    <button type="submit" name="btnControl" value="Logout">Log Uut</button>
</form>
<nguyenvt:url var="manageRole" value="GetListRoleController"/>
<nguyenvt:url var="manageGroup" value="GetListGroupController"/>
<a href="${manageRole}">Click here to manage role</a><br/>
<a href="${manageGroup}">Click here to manage group</a><br/>
<h1 style="color: blue">Manage Role</h1>
<nguyenvt:if test="${not empty requestScope.ROLE_LIST}">
    <table border="1">
        <thead>
        <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <nguyenvt:forEach items="${requestScope.ROLE_LIST}" var="role" varStatus="counter">
            <form action="MainController" method="post">
                <tr>
                    <td>${counter.count}</td>
                    <td><input type="text" name="txtName" value="${role.roleName}" required/></td>
                    <td>
                        <input type="hidden" name="txtRoleId" value="${role.roleId}"/>
                        <button type="submit" name="btnControl" value="Update Role">Update Role</button>
                    </td>
                </tr>
            </form>
        </nguyenvt:forEach>
        </tbody>
    </table>
</nguyenvt:if>
</body>
</html>
