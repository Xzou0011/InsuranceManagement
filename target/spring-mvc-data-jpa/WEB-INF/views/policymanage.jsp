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
    <title>Policy Manager</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/policymanage">Show Policy</a>
<a href="${pageContext.request.contextPath}/pokemanage">Show Customer</a>
<a href="${pageContext.request.contextPath}/policeholderrecordmanage">Show Policy Holder Record</a>

<div align="center">
    <h2>Policy Manager</h2>
    <form method="get" action="searchPolicy">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="${pageContext.request.contextPath}/newPolicy">New Policy</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>Policy ID</th>
            <th>Policy Type</th>
            <th>Policy Description</th>
        </tr>
        <c:forEach items="${listPolicy}" var="policy">
            <tr>
                <td>${policy.policyId}</td>
                <td>${policy.policeType}</td>
                <td>${policy.policyDesr}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/editPolicy?id=${policy.policyId}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/deletePolicy?id=${policy.policyId}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>