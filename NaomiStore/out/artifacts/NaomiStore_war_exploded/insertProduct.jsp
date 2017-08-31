<%--
  Created by IntelliJ IDEA.
  User: nguyenvt181
  Date: 8/31/17
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insert New Product</title>
</head>
<body>
<form action="MainController" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="txtName" required></td>
        </tr>
        <tr>
            <td>Quantity:</td>
            <td><input type="number" name="txtQuantity" required min="1" max="999"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="txtPrice" required min="1" max="99999"></td>
        </tr>
    </table>
    <button type="submit" name="btnControl" value="Insert Product">Insert</button>
</form>
<nguyenvt:if test="${not empty requestScope.ERROR}">
    <h3 style="color: red">${requestScope.ERROR}</h3>
</nguyenvt:if>
</body>
</html>
