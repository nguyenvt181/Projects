<%--
  Created by IntelliJ IDEA.
  User: NGUYENVT
  Date: 9/14/17
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
Welcome, ${sessionScope.ACCOUNT.name}
<a href="insertPost.jsp">Click here to write new post</a>
<nguyenvt:if test="${not empty sessionScope.POST}">
    <nguyenvt:if test="${sessionScope.ACCOUNT.roleId == 1}">
        <table border="1">
            <thead>
            <tr>
                <th>No.</th>
                <th>Title</th>
                <th>Content</th>
                <th>Date</th>
                <th>Poster</th>
                <th>Group</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <nguyenvt:forEach items="${sessionScope.POST}" var="p" varStatus="counter">
                <nguyenvt:if test="${p.statusId == 1}">
                    <form action="MainController" method="post">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${p.postTitle}</td>
                            <td>${p.postContent}</td>
                            <td>${p.postDate}</td>
                            <td>${sessionScope.POSTER[counter.index].name}</td>
                            <td>${sessionScope.POST_GROUP[counter.index].groupName}</td>
                            <td>
                                <input type="hidden" name="txtPostId" value="${p.postId}">
                                <button type="submit" name="btnControl" value="Accept Post">Accept</button>
                                <button type="submit" name="btnControl" value="Decline Post">Decline</button>
                            </td>
                        </tr>
                    </form>
                </nguyenvt:if>
            </nguyenvt:forEach>
            </tbody>
        </table>
    </nguyenvt:if>
    <nguyenvt:if test="${sessionScope.ACCOUNT.roleId == 2}">
        <table border="1">
            <thead>
            <tr>
                <th>No.</th>
                <th>Title</th>
                <th>Content</th>
                <th>Date</th>
                <th>Poster</th>
                <th>Group</th>
            </tr>
            </thead>
            <tbody>
            <nguyenvt:forEach items="${sessionScope.POST}" var="p" varStatus="counter">
                <nguyenvt:if test="${p.statusId == 2}">
                    <form action="MainController" method="post">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${p.postTitle}</td>
                            <td>${p.postContent}</td>
                            <td>${p.postDate}</td>
                            <td>${sessionScope.POSTER[counter.index].name}</td>
                            <td>${sessionScope.POST_GROUP[counter.index].groupName}</td>
                        </tr>
                    </form>
                </nguyenvt:if>
            </nguyenvt:forEach>
            </tbody>
        </table>
    </nguyenvt:if>
</nguyenvt:if>
</body>
</html>
