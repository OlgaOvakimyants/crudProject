<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.10.2019
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Users</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th colspan=2>Action</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.userID}" /></td>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><a href="update=<c:out value="${user.userID}"/>">Update</a></td>
            <td><a href="delete=<c:out value="${user.userID}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="add">Add User</a></p>
</body>
</html>
