<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunil
  Date: 2020-04-05
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<h1 align="center"> Insurance Management System</h1>
<div align="center">
    <a href="${pageContext.request.contextPath}/policymanage">Show Policy</a>
    <br>
    <a href="${pageContext.request.contextPath}/pokemanage">Show Customer</a>
    <br>
    <a href="${pageContext.request.contextPath}/policeholderrecordmanage">Show Policy Holder Record</a>
    <a href="<c:url value="/logout" />">Logout</a>
</div>
</body>
</html>
