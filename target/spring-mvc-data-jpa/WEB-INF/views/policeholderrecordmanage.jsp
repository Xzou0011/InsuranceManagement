<%--
  Created by IntelliJ IDEA.
  User: sunil
  Date: 2020-04-05
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: sunil
  Date: 2020-04-01
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Policy Holder Record Manager</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/policymanage">Show Policy</a>
<a href="${pageContext.request.contextPath}/pokemanage">Show Customer</a>
<a href="${pageContext.request.contextPath}/policeholderrecordmanage">Show Policy Holder Record</a>

<div align="center">
    <h2>Policy Holder Record Manager</h2>





    <form method="get" action="searchPolicyHolderRecord">
        <%--@declare id="policyid"--%>
        <%--@declare id="customerid"--%>
        <%--@declare id="applieddate"--%>
        <label for="policyId">Policy ID:</label>
        <input type="text" name="policyId" /> &nbsp;
        <label for="customerId">Customer ID:</label>
        <input type="text" name="name" /> &nbsp;
        <label for="appliedDate">Applied Date:</label>
        <input type="text" name="appliedDate" /> &nbsp;
        <input type="submit" value="Search NOW" />
    </form>





    <h3><a href="${pageContext.request.contextPath}/newPolicyHolderRecord">New Policy Holder Record</a></h3>
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
            <th>Police Type</th>
            <th>Customer Name</th>
        </tr>
        <c:forEach items="${listPolicyHolderRecord}" var="policyholderrecord">
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
                <td>${policyholderrecord.policy.policeType}</td>
                <td>${policyholderrecord.customer.name}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/editPolicyHolderRecord?id=${policyholderrecord.phrId}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/deletePolicyHolderRecord?id=${policyholderrecord.phrId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>