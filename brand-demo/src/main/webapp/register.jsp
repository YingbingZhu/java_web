<%--
  Created by IntelliJ IDEA.
  User: yingbingzhu
  Date: 2022/10/12
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>welcome to register</title>
  <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
  <div class="reg-content">
    <h1>welcome to register</h1>
    <span>have account？</span> <a href="login.html">login</a>
  </div>
  <form id="reg-form" action="/brand-demo/registerServlet" method="post">

    <table>

      <tr>
        <td>username</td>
        <td class="inputs">
          <input name="username" type="text" id="username">
          <br>
          <span id="username_err" class="err_msg">${register_msg}</span>
        </td>

      </tr>

      <tr>
        <td>password</td>
        <td class="inputs">
          <input name="password" type="password" id="password">
          <br>
          <span id="password_err" class="err_msg" style="display: none">wrong format</span>
        </td>
      </tr>


      <tr>
        <td>verification code</td>
        <td class="inputs">
          <input name="checkCode" type="text" id="checkCode">
          <img id="checkCodeImage" src="/brand-demo/checkCodeServlet">
          <a href="#" id="changeImg">unclear？</a>
        </td>
      </tr>

    </table>

    <div class="buttons">
      <input value="Sign Up" type="submit" id="reg_btn">
    </div>
    <br class="clear">
  </form>

</div>
<script>
  document.getElementById("changeImg").onclick = function () {
    document.getElementById("checkCodeImage").src = "/brand-demo/checkCodeServlet?"+new Date().getMilliseconds();
  }
</script>
</body>
</html>