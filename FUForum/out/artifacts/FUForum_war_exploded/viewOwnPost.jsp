<%--
  Created by IntelliJ IDEA.
  User: NGUYENVT
  Date: 9/16/17
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Your Post</title>
</head>
<body>
<form action="MainController" method="post">
    <h1 style="color: green">Welcome, ${sessionScope.ACCOUNT.name}</h1>
    <button type="submit" name="btnControl" value="Logout">Log Uut</button>
</form>
<nguyenvt:if test="${not empty requestScope.POST}">
    <table border="1">
        <thead>
        <tr>
            <th>No.</th>
            <th>Title</th>
            <th>Content</th>
            <th>Status</th>
            <th>Date</th>
            <th>Group</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <nguyenvt:forEach items="${requestScope.POST}" var="post" varStatus="counter">
            <form action="MainController" method="post">
                <tr>
                    <td>${counter.count}</td>
                    <td><input type="text" name="txtTitle" value="${post.postTitle}" required></td>
                    <td><input type="text" name="txtContent" value="${post.postContent}" required></td>
                    <td><input type="text" name="txtStatus" value="${post.statusId}" readonly/></td>
                    <td><input type="text" name="txtDate" value="${post.postDate}" readonly/></td>
                    <td>
                        <select name="txtGroup">
                            <nguyenvt:forEach items="${sessionScope.GROUP}" var="g">
                                <option value="${g.groupId}" ${g.groupName == requestScope.POST_GROUP[counter.index].groupName ? 'selected' : ''}>
                                        ${g.groupName}
                                </option>
                            </nguyenvt:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="hidden" name="txtPostId" value="${post.postId}">
                        <button type="submit" name="btnControl" value="Update Post">Update</button>
                        <button type="submit" name="btnControl" value="Remove Post">Remove</button>
                    </td>
                </tr>
            </form>
        </nguyenvt:forEach>
        </tbody>
    </table>
</nguyenvt:if>
</body>
</html>
