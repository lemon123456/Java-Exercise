<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>用户管理</title>

    <link href="./lib/css/bootstrap.css" rel="stylesheet" type="text/css"/>



</head>
<body>

      <ul><li>
        <td><a href="/web/">&nbsp;&nbsp;首页&nbsp;&nbsp;</a></td>
        <td><a href="/web/users">&nbsp;&nbsp;用户管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/employee">&nbsp;&nbsp;员工管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/course">&nbsp;&nbsp;课程管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/customer">&nbsp;&nbsp;顾客管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/schedule">&nbsp;&nbsp;课表管理&nbsp;&nbsp;</a></td>
        <td> <a href="/web/login/logout">&nbsp;&nbsp;logout&nbsp;&nbsp;</a> </td>
       </li></ul>


      <ul>
          <h2>用户管理页面</h2>
      </ul>

  <div class="container">
    <table class="table table-bordered">
        <thead>
          <tr>
            <td>编号</td>
            <td>用户名</td>
            <td>工号</td>
            <td>删除用户</td>
            <td>修改信息</td>
          </tr>
        </thead>


    <c:forEach items="${userList}" var="user">
      <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.employee.id}</td>
        <td><a href="./users/delete?id=${user.id}">删除用户</a></td>
        <td><a href="./users/modify?id=${user.id}">修改信息</a></td>
      </tr>
    </c:forEach>


      <ul>
        <li><a href="./users/insert">注册用户</a></li>
      </ul>
    </table>
  </div>
</body>
</html>


