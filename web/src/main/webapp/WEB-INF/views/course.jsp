<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程管理</title>
    <link rel="stylesheet" href="./lib/css/customerStyle.css"/>
</head>
<body>

<ul>
    <li>
        <td><a href="/web/">&nbsp;&nbsp;首页&nbsp;&nbsp;</a></td>
        <td><a href="/web/users">&nbsp;&nbsp;用户管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/employee">&nbsp;&nbsp;员工管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/course">&nbsp;&nbsp;课程管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/customer">&nbsp;&nbsp;顾客管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/schedule">&nbsp;&nbsp;课表管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/login/logout">&nbsp;&nbsp;logout&nbsp;&nbsp;</a></td>
    </li>
</ul>

<ul>
    <h2>课程管理页面</h2>
</ul>

<div class="container">
    <table class="table table-bordered">
        <tr>
            <td>编号</td>
            <td>课程</td>
            <td>描述</td>
            <td>删除</td>
            <td>更新</td>
        </tr>

        <c:forEach items="${courseList}" var="course">
            <tr>
                <td>${course.id}</td>
                <td>${course.courseName}</td>
                <td>${course.description}</td>
                <td><a href="./course/delete/${course.id}">删除信息</a></td>
                <td><a href="./course/modify/${course.id}">修改信息</a></td>
            </tr>
        </c:forEach>
    </table>

    <h3>
        <ul>
            <li>添加课程</li>
        </ul>
    </h3>

    <form action="/web/course/insert" method="post">
        <table class="table table-bordered">
            <tr>
                <td>课程</td>
                <td>描述</td>
            </tr>

            <tr>
                <td><input type="text" name="courseName" value=""></td>
                <td><input type="text" name="description" value=""></td>
            </tr>
        </table>

        <input type="submit" value="提交"/>
        <input type="reset" value="清空">
    </form>
</div>

</body>
</html>
