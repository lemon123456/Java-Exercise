<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>用户管理</title>
    <link href="./lib/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
<ul class="navigation">
    <li class="nav-item"><a href="/web/">首页</a></li>
    <li class="nav-item"><a href="/web/users">用户管理</a></li>
    <li class="nav-item"><a href="/web/employee">员工管理</a></li>
    <li class="nav-item"><a href="/web/course">课程管理</a></li>
    <li class="nav-item"><a href="/web/customer">顾客管理</a></li>
    <li class="nav-item"><a href="/web/schedule">课表管理</a></li>
    <li class="nav-item"><a href="/web/login/logout">logout</a></li>
</ul>

<h2>用户管理页面</h2>

<div class="container">
    <div class="register">
        <a href="./users/insert">注册用户</a>
    </div>
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
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.employee.id}</td>
                <td><a href="./users/delete?id=${user.id}">删除用户</a></td>
                <td><a href="./users/modify?id=${user.id}">修改信息</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


