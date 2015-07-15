<%@ page import="com.tw.core.Dao.UserDao" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/8/15
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


  <form action="/web/users/insert" method="post">
    姓名 :<input type = "text" name="name" value=""/>
    性别 :<input type = "text" name="sex" value=""/>
    邮箱 :<input type = "text" name="email" value=""/>
    年龄 :<input type = "text" name="age" value=""/>
    密码 :<input type = "text" name="password" value="">
    </br>
    <input type = "submit" value="提交"/>
  </form>
</body>
</html>
