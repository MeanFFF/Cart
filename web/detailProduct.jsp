<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/12
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DetailProduct</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>Product</td>
        <td>Price</td>
        <td>Control</td>
    </tr>
    <tr>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>
            <form action="addOrderItem" method="post">
                <input type="text" value="1" name="num">
                <input type="hidden" value="${product.id}" name="pid">
                <input type="submit" value="add to cart">
            </form>
        </td>
    </tr>
</table>
<jsp:include page="LastViewProduct.jsp"/>
</body>
</html>
