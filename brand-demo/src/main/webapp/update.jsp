<%--
  Created by IntelliJ IDEA.
  User: yingbingzhu
  Date: 2022/10/8
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>update_brand</title>
</head>
<body>
<h3>update_brand</h3>
<form action="/brand-demo/updateServlet" method="post">
  <input type="hidden" name="id" value="${brand.id}">

  brand name：<input name="brandName" value="${brand.brandName}"><br>
  company name：<input name="companyName" value="${brand.companyName}"><br>
  order：<input name="ordered" value="${brand.ordered}"><br>
  description：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
  status：
  <c:if test="${brand.status == 0}">
    <input type="radio" name="status" value="0" checked="checked">close
    <input type="radio" name="status" value="1">open<br>
  </c:if>
  <c:if test="${brand.status == 1}">
    <input type="radio" name="status" value="0">close
    <input type="radio" name="status" value="1" checked="checked">open<br>
  </c:if>

  <input type="submit" value="submit">
</form>
</body>
</html>

