<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/13/15
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户登陆页面</title>
</head>

<body>
<h3>请先登陆</h3>

<form action="/web/login" method="post">
  用户名:<input type="text" name="name" value=""/>
  密&nbsp;&nbsp;码:<input type="password" name="password" value=""/>
  <input type="submit" value=" 登 录 "  />
  <input type="reset" value=" 重 置 " />
</form>


</body>
</html>
