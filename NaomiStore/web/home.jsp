<%--
  Created by IntelliJ IDEA.
  User: nguyenvt181
  Date: 8/31/17
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="nguyenvt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>${sessionScope.ACCOUNT.name}</h1>
<form action="MainController" method="post">
    Search Product: <input type="text" name="txtSearchValue">
    <button type="submit" name="btnControl" value="Search Product">Search</button>
    <br>
    <a href="insertProduct.jsp">Click here to insert new product</a><br>
    <a href="updateInformation.jsp">Click here to update information</a><br>
    <button type="submit" name="btnControl" value="Logout">Logout</button>
</form>
<nguyenvt:if test="${not empty sessionScope.PRODUCT}">
    <nguyenvt:if test="${sessionScope.ACCOUNT.role eq 1}">
        <h2 style="color: aqua">List of products</h2>
        <form action="MainController" method="post">
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
                <nguyenvt:forEach items="${sessionScope.PRODUCT}" var="dto" varStatus="counter">
                    <form action="MainController" method="post">
                        <tr>
                            <td>${counter.count}</td>
                            <td><input type="text" name="txtName" value="${dto.productName}" required></td>
                            <td><input type="number" name="txtQuantity" value="${dto.productQuantity}" min="1" max="999"
                                       required></td>
                            <td><input type="number" name="txtPrice" value="${dto.productPrice}" min="1" max="99999"
                                       required></td>
                            <td>
                                <input type="hidden" name="txtId" value="${dto.productId}">
                                <button type="submit" name="btnControl" value="Update Product">Update</button>
                                <button type="submit" name="btnControl" value="Remove Product">Remove</button>
                            </td>
                        </tr>
                    </form>
                </nguyenvt:forEach>
                </tbody>
            </table>
        </form>
    </nguyenvt:if>
    <nguyenvt:if test="${sessionScope.ACCOUNT.role eq 2}">
        <h2 style="color: aqua">List of products</h2>
        <form action="MainController" method="post">
            <table border="1">
                <thead>
                <tr>
                    <td>No.</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Action</td>
                </tr>
                </thead>
                <tbody>
                <nguyenvt:forEach items="${sessionScope.PRODUCT}" var="dto" varStatus="counter">
                    <form action="MainController" method="post">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.productName}</td>
                            <td>${dto.productPrice}</td>
                            <td>
                                <input type="hidden" name="txtName" value="${dto.productName}">
                                <input type="hidden" name="txtPrice" value="${dto.productPrice}">
                                <input type="hidden" name="txtId" value="${dto.productId}">
                                <button type="submit" name="btnControl" value="Insert Cart">Add To Cart</button>
                            </td>
                        </tr>
                    </form>
                </nguyenvt:forEach>
                </tbody>
            </table>
            <a href="viewCart.jsp">Click here to view cart</a><br>
        </form>
    </nguyenvt:if>
</nguyenvt:if>
<nguyenvt:if test="${empty sessionScope.PRODUCT}">
    <h2 style="color: darkblue">No record found</h2>
</nguyenvt:if>
</body>
</html>
