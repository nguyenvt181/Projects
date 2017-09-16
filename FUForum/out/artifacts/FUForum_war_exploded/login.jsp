<%--
  Created by IntelliJ IDEA.
  User: NGUYENVT
  Date: 9/14/17
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="MainController" method="post">
    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="txtUsername" required></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="txtPassword" required></td>
        </tr>
    </table>
    <button type="submit" name="btnControl" value="Login">Login</button><br/>
    <a href="register.jsp">Click here to register new account</a>
</form>
</body>
</html>
