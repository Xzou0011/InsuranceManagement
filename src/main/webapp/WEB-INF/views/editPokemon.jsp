<%--
  Created by IntelliJ IDEA.
  User: sunil
  Date: 2020-04-05
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Pokemon</title>
</head>
<body>
<div align="center">
    <h2>Edit Pokemon</h2>
    <form:form action="save" method="post" modelAttribute="customer">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${customer.customerId}
                    <form:hidden path="customerId"/>
                </td>
            </tr>
            <tr>
                <td>Customer Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td>Contact Number: </td>
                <td><form:input path="contactNumber" /></td>
            </tr>
            <tr>
                <td>Email Address: </td>
                <td><form:input path="emailAddress" /></td>
            </tr>
            <tr>
                <td>Sex: </td>
                <td><form:input path="sex" /></td>
            </tr>
            <tr>
                <td>Date of Birth: </td>
                <td><form:input path="dateOfBirth" /></td>
            </tr>
            <tr>
                <td>Employment Status: </td>
                <td><form:input path="employmentStatus" /></td>
            </tr>
            <tr>
                <td>Risk Rate: </td>
                <td><form:input path="riskRate" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>