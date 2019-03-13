<%@ page import="bean.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/11
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>ListProduct</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
<c:if test="${!empty user}">
    <div align="center">
        当前用户: ${user.name}
    </div>
</c:if>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>价格</td>
        <%--<td>购买</td>--%>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td><a href="detailProduct?pid=${product.id}"/> ${product.name}</td>
            <td>${product.price}</td>
            <%--<td>--%>
                <%--<form action="addOrderItem" method="post">--%>
                    <%--<input type="text" value="1" name="num">--%>
                    <%--<input type="hidden" value="${product.id}" name="pid">--%>
                    <%--<input type="submit" value="submit">--%>
                <%--</form>--%>
            <%--</td>--%>
        </tr>
    </c:forEach>


</table>

</body>
</html>
