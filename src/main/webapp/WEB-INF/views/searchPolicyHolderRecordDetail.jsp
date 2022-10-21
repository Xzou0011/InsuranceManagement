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
<div align="center">
    <h2>Search Result</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Policy Holder Record ID</th>
            <th>Applied Date</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Status</th>
            <th>Premium</th>
            <th>Other Details</th>
            <th>Customer ID</th>
            <th>Policy ID</th>
        </tr>
        <c:forEach items="${result}" var="policyholderrecord">
            <tr>
                <td>${policyholderrecord.phrId}</td>
                <td>${policyholderrecord.appliedDate}</td>
                <td>${policyholderrecord.startDate}</td>
                <td>${policyholderrecord.endDate}</td>
                <td>${policyholderrecord.status}</td>
                <td>${policyholderrecord.premium}</td>
                <td>${policyholderrecord.otherDetails}</td>
                <td>${policyholderrecord.customerId}</td>
                <td>${policyholderrecord.policyId}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
