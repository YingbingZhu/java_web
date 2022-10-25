<%@ page import="com.pojo.com.zhu.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yingbingzhu
  Date: 2022/10/5
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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



    <%
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
    %>

    <tr align="center">
        <td><%=brand.getId()%></td>
        <td><%=brand.getBrandName()%></td>
        <td><%=brand.getCompanyName()%></td>
        <td><%=brand.getOrdered()%></td>
        <td><%=brand.getDescription()%></td>

        <%
            if(brand.getStatus() == 1){
        %>
        <td><%="open"%></td>
        <%
        }else {
        %>
        <td><%="close"%></td>

        <%
            }
        %>

        <td><a href="#">modify</a> <a href="#">delete</a></td>
    </tr>

    <%
        }
    %>



</table>

</body>
</html>
