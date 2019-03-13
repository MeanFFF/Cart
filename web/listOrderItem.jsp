<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="Head.jsp"/>
<h1 align="center" >购物车</h1>
<c:if test="${empty ois}">
    <div align="center">
        <h2>空</h2>
    </div>
</c:if>
<c:if test="${!empty ois}">
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${ois}" var="oi" varStatus="st">
        <tr>
            <td>${oi.product.name}</td>
            <td>${oi.product.price}</td>
            <td>${oi.num}</td>
            <td>${oi.product.price*oi.num}</td>
            <td>
                <a href="deleteOrderItem?id=${oi.product.id}">删除</a>
            </td>
        </tr>


    </c:forEach>

    <tr>
        <td colspan="4" align="right">
            <a href="createOrder">生成订单</a>
        </td>
    </tr>
</table>
</c:if>