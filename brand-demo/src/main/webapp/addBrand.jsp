<%--
  Created by IntelliJ IDEA.
  User: yingbingzhu
  Date: 2022/10/8
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>add_brand</title>
</head>
<body>
<h3>add_brand</h3>
<form action="/brand-demo/addServlet" method="post">
  brand name：<input name="brandName"><br>
  company name：<input name="companyName"><br>
  order：<input name="ordered"><br>
  description：<textarea rows="5" cols="20" name="description"></textarea><br>
  status：
  <input type="radio" name="status" value="0">close
  <input type="radio" name="status" value="1">open<br>

  <input type="submit" value="submit">
</form>
</body>
</html>

