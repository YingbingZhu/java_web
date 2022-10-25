<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pojo.com.zhu.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yingbingzhu
  Date: 2022/10/5
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%
    // database
    List<Brand> brands = new ArrayList<Brand>();
    brands.add(new Brand(1,"squirrels","squirrels",100,"good",1));
    brands.add(new Brand(2,"uniqlp","uniqlp",200,"uniqlp",0));
    brands.add(new Brand(3,"mi","mi",1000,"mi",1));

%>


<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>${user.username},welcome!</h1>

<input type="button" value="add" id="add"><br>
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


    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status != 1}">
                <td>close</td>
            </c:if>
            <c:if test="${brand.status == 1}">
            <td>open</td>
            </c:if>

            <td><a href="/brand-demo/selectByIdServlet?id=${brand.id}">modify</a> <a href="/brand-demo/deleteByIdServlet?id=${brand.id}">delete</a></td>
        </tr>


    </c:forEach>



</table>

<script>
    document.getElementById("add").onclick = function () {
        window.location.href="/brand-demo/addBrand.jsp";
    }


</script>

</body>
</html>
