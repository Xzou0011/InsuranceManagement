<%--
  Created by IntelliJ IDEA.
  User: sunil
  Date: 2020-04-05
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search Result</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/policymanage">Show Policy</a>
<a href="${pageContext.request.contextPath}/pokemanage">Show Customer</a>
<a href="${pageContext.request.contextPath}/policeholderrecordmanage">Show Policy Holder Record</a>


<h3><a href="${pageContext.request.contextPath}/new">New Pokemon</a></h3>


<div align="center">
    <h2>Search Result</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Customer ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Contact Number</th>
            <th>Email Address</th>
            <th>Sex</th>
            <th>Date Of Birth</th>
            <th>Employment Status</th>
            <th>Risk Rate</th>
        </tr>
        <c:forEach items="${resultByIdAndNameDetail}" var="customer">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.contactNumber}</td>
                <td>${customer.emailAddress}</td>
                <td>${customer.sex}</td>
                <td>${customer.dateOfBirth}</td>
                <td>${customer.employmentStatus}</td>
                <td>${customer.riskRate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
