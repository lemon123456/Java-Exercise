<%@ page import="com.tw.core.entity.User" %>
<%@ page import="com.tw.core.Dao.UserDao" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/8/15
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%
        User user = (User) request.getAttribute("userList");
    %>
</head>
<body>

<form action="" method="post">
    序号 :<input type="text" name="userId" value="<%=user.getId()%>" readonly="readonly"/>
    姓名 :<input type="text" name="name" value="<%=user.getName()%>"/>
    性别 :<input type="text" name="sex" value="<%=user.getSex()%>"/>
    邮箱 :<input type="text" name="email" value="<%=user.getEmail()%>"/>
    年龄 :<input type="text" name="age" value="<%=user.getAge()%>"/>
    密码 :<input type="text" name="password" value="<%=user.getPassword()%>">
    </br>
    <input type="submit" value="更新"/>
</form>


</body>
</html>
