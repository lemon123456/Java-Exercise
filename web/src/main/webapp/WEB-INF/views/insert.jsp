<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<h3>新用户注册</h3>

  <form action="/web/users/insert" method="post">
    用户名 :<input type = "text" name="name" value=""/>
    <ul></ul>
    密&nbsp;&nbsp;&nbsp;&nbsp;码 :<input type = "text" name="password" value=""/>
    <ul></ul>
    工&nbsp;&nbsp;&nbsp;&nbsp;号 :<input type = "text" name="employeeId" value="">
    </br>
    <ul></ul>
    <input type = "submit" value="提交"/>
    <input type = "reset" value="清空"/>
  </form>
</body>
</html>
