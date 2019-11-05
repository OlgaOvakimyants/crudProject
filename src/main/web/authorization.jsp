<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.10.2019
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form method="POST">

    <label>Login:
        <input type="text" name="login"><br />
    </label>

    <label>Password:
        <input type="text" name="password"><br />
    </label>

    <button type="submit">Submit</button>
</form>
<% session.setAttribute("role", null);
session.setAttribute("user", null);%>
</body>
</html>

