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
<form action="MainController" method="post">
    <h1 style="color: green">Welcome, ${sessionScope.ACCOUNT.name}</h1>
    <button type="submit" name="btnControl" value="Logout">Log Uut</button>
</form>
<a href="insertPost.jsp">Click here to write new post</a><br/>
<a href="updateAccount.jsp">Click here to update account's information</a><br/>
<nguyenvt:if test="${not empty sessionScope.POST}">
    <nguyenvt:if test="${sessionScope.ACCOUNT.roleId == 1}">
        <nguyenvt:url var="manageRole" value="GetListRoleController"/>
        <nguyenvt:url var="manageGroup" value="GetListGroupController"/>
        <a href="${manageRole}">Click here to manage role</a><br/>
        <a href="${manageGroup}">Click here to manage group</a><br/>
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
                                <input type="hidden" name="txtPostId" value="${p.postId}"/>
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
        <nguyenvt:url var="viewOwnPost" value="MainController">
            <nguyenvt:param name="btnControl" value="View Own Post"/>
            <nguyenvt:param name="txtAccountId" value="${sessionScope.ACCOUNT.accountId}"/>
        </nguyenvt:url>
        <a href="${viewOwnPost}">Click here to view all your post</a><br/>
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
