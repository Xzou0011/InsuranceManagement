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
    <title>Edit Policy</title>
</head>
<body>
<div align="center">
    <h2>Edit Policy</h2>
    <form:form action="savePolicy" method="post" modelAttribute="policy">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${policy.policyId}
                    <form:hidden path="policyId"/>
                </td>
            </tr>
            <tr>
                <td>Policy Type: </td>
                <td><form:input path="policeType"/></td>
            </tr>
            <tr>
                <td>Policy Description: </td>
                <td><form:input path="policyDesr" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>