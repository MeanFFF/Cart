<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/12
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LastViewProduct</title>
</head>
<body>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>Product</td>
        <td>Price</td>
    </tr>
    <c:forEach items="${lastViewProducts}" var="lastViewProduct" varStatus="st">
        <tr>
            <td><a href="detailProduct?pid=${lastViewProduct.id}"/> ${lastViewProduct.name}</td>
            <td>${lastViewProduct.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
