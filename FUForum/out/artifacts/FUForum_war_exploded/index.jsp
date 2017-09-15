<%--
  Created by IntelliJ IDEA.
  User: NGUYENVT
  Date: 9/14/17
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
Welcome, ${sessionScope.ACCOUNT.name}
<a href="insertPost.jsp">Click here to write new post</a>
<nguyenvt:if test="${not empty sessionScope.POST}">
    <table>
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
        <td>
            <nguyenvt:forEach items="${sessionScope.POST}" var="p" varStatus="counter">
                <tr>${counter.count}</tr>
                <tr>${p.postTitle}</tr>
                <tr>${p.postContent}</tr>
                <tr>${p.postDate}</tr>
                <tr>${sessionScope.POSTER[index].name}</tr>
                <tr>${sessionScope.POST_GROUP[index].postName}</tr>
            </nguyenvt:forEach>
        </td>
        </tbody>
    </table>
</nguyenvt:if>
</body>
</html>
