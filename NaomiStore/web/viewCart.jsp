<%--
  Created by IntelliJ IDEA.
  User: nguyenvt181
  Date: 9/1/17
  Time: 00:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Cart</title>
</head>
<body>
<nguyenvt:if test="${not empty sessionScope.CART}">
    <table border="1">
        <thead>
        <tr>
            <td>No.</td>
            <td>Name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbody>
        <nguyenvt:set var="totalPrice" value="${0}"/>
        <nguyenvt:forEach items="${sessionScope.CART.hashMap}" var="cart" varStatus="counter">
            <nguyenvt:set var="totalPrice" value="${totalPrice + cart.value.productPrice}"/>
            <form action="MainController" method="post">
                <tr>
                    <td>${counter.count}</td>
                    <td>${cart.value.productName}</td>
                    <td><input type="number" name="txtQuantity" value="${cart.value.productQuantity}" required min="1" max="999"></td>
                    <td>${cart.value.productPrice}</td>
                    <td>
                        <input type="hidden" name="txtId" value="${cart.value.productId}">
                        <button type="submit" name="btnControl" value="Update Cart">Update</button>
                        <button type="submit" name="btnControl" value="Remove Cart">Remove</button>
                    </td>
                </tr>
            </form>
        </nguyenvt:forEach>
        </tbody>
    </table>
    <h1 style="color: chartreuse">Total: ${totalPrice}</h1>
    <form action="MainController" method="post">
        <button type="submit" name="btnControl" value="Insert Order">Check Out</button>
    </form>
</nguyenvt:if>
</body>
</html>
