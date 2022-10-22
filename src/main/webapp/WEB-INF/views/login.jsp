<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1> Test login page</h1>
<form:form>
    Username : <input type="text" name="username">
    <br/>
    Password : <input type="text" name="password">
    <input type="submit" value="Login">
</form:form>
</body>
</html>
