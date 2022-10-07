<%--
  Created by IntelliJ IDEA.
  User: yingbingzhu
  Date: 2022/10/5
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>


<%--  <c:if test="true">
    <h1>true</h1>
  </c:if>

  <c:if test="false">
    <h1>false</h1>
  </c:if>--%>

<c:if test="${status==1}">
  open
</c:if>

<c:if test="${status==0}">
  close
</c:if>

</body>
</html>
