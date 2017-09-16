<%--
  Created by IntelliJ IDEA.
  User: NGUYENVT
  Date: 9/14/17
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insert New Post</title>
</head>
<body>
<form action="MainController" method="post">
    <h1 style="color: green">Welcome, ${sessionScope.ACCOUNT.name}</h1>
    <button type="submit" name="btnControl" value="Logout">Log Uut</button>
</form>

<form action="MainController" method="post">
    <table border="1">
        <tr>
            <td>Title</td>
            <td><textarea name="txtTitle" cols="30" rows="10" required></textarea></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><textarea name="txtContent" cols="100" rows="30" required></textarea></td>
        </tr>
        <tr>
            <td>Group</td>
            <td>
                <select name="txtGroup">
                    <nguyenvt:forEach items="${sessionScope.GROUP}" var="g">
                        <option value="${g.groupId}">${g.groupName}</option>
                    </nguyenvt:forEach>
                </select>
            </td>
        </tr>
    </table>
    <input type="hidden" name="txtAccountId" value="${sessionScope.ACCOUNT.accountId}">
    <button type="submit" name="btnControl" value="Insert Post">Upload Post</button>
</form>
</body>
</html>
