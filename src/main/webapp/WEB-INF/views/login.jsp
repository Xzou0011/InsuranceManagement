<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>

<h1 align = "center"> Welcome to Insurance Management </h1>
<h2 align = "center"> Log In </h2>

<br/>

<div align = "center">

    <a href="${pageContext.request.contextPath}/index">
        <input type="button" value="Admin" />
    </a>

    <br/>

    <a href="${pageContext.request.contextPath}/index">
        <input type="button" value="Agent" />
    </a>

</div>

</body>
</html>