<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/7/15
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.text.*,java.util.*"%>
<%@ page import="com.tw.core.Dao.UserDao" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.tw.core.entity.User" %>

<html>
<head>
    <title>第一个JSP程序</title>
</head>
<body>
    <%--<table border="1">--%>
      <%--<tr>--%>
        <%--<td>姓名</td>--%>
        <%--<td>性别</td>--%>
        <%--<td>邮箱</td>--%>
        <%--<td>年龄</td>--%>
      <%--</tr>--%>
      <%--<tr>--%>
        <%--<td>韩玲</td>--%>
        <%--<td>女</td>--%>
        <%--<td>163@163.com</td>--%>
        <%--<td>12</td>--%>
      <%--</tr>--%>
      <%--<tr>--%>
        <%--<td>吴天</td>--%>
        <%--<td>男</td>--%>
        <%--<td>163@163.com</td>--%>
        <%--<td>12</td>--%>
      <%--</tr>--%>
      <%--<tr>--%>
        <%--<td>张贵</td>--%>
        <%--<td>男</td>--%>
        <%--<td>163@163.com</td>--%>
        <%--<td>77</td>--%>
      <%--</tr>--%>
    <%--</table>--%>


     <% UserDao userDao = new UserDao();
        List<User> userList = userDao.getUsers();
    %>
    <table border="1">
      <tr>
        <td>姓名</td>
        <td>性别</td>
        <td>邮箱</td>
        <td>年龄</td>
      </tr>

      <%if(userList.size()!=0){
      for(int i=0;i<userList.size();i++){
      %>
      <tr>
        <%--<td name="id"><%=userList.get(i).getId()%></td>--%>
        <td name="name"><%=userList.get(i).getName()%></td>
        <td name="sex"><%=userList.get(i).getSex()%></td>
        <td name="email"><%=userList.get(i).getEmail()%></td>
        <td name="age"><%=userList.get(i).getAge()%></td>
        <td><a href="/web/delete?id=<%=userList.get(i).getId()%>">删除</a></td>
        <td><a href="/web/modify?id=<%=userList.get(i).getId()%>">修改</a></td>
      </tr>
      <%}}%>
      <ul>
        <li><a href="insert.jsp">增加用户</a></li>
      </ul>
    </table>
</body>
</html>


