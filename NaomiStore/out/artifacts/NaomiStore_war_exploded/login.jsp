<%--
  Created by IntelliJ IDEA.
  User: nguyenvt181
  Date: 8/31/17
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1 style="color: red">Login</h1>
<form action="MainController" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td><input name="txtUsername"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="txtPassword"></td>
        </tr>
    </table>
    <button name="btnControl" value="Login">Login</button><br/>
    <a href="register.jsp">Click here to register account</a>
</form>
</body>
</html>
