<%--
  Created by IntelliJ IDEA.
  User: yingbingzhu
  Date: 2022/10/5
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>id</th>
        <th>brand_name</th>
        <th>company_name</th>
        <th>order</th>
        <th>desc</th>
        <th>status</th>
        <th>action</th>

    </tr>

    <c:forEach items="${brands}" var="brand">
        <tr align="center">
            <td>${brand.id}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status}==1">
                <td>open</td>
            </c:if>
            <c:if test="${brand.status}!=1">
                <td>close</td>
            </c:if>
            <td><a href="#">modify</a> <a href="#">delete</a></td>
        </tr>

    </c:forEach>





</table>


</body>
</html>
