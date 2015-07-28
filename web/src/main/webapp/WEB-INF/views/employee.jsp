<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>

    <link rel="stylesheet" href="css/employeeStyle.css"/>
</head>
<body>

<ul>
    <td><a href="/web/">&nbsp;&nbsp;首页&nbsp;&nbsp;</a></td>
    <td><a href="/web/users">&nbsp;&nbsp;用户管理&nbsp;&nbsp;</a></td>
    <td><a href="/web/employee">&nbsp;&nbsp;员工管理&nbsp;&nbsp;</a></td>
    <td><a href="/web/course">&nbsp;&nbsp;课程管理&nbsp;&nbsp;</a></td>
    <td><a href="/web/customer">&nbsp;&nbsp;顾客管理&nbsp;&nbsp;</a></td>
    <td><a href="/web/schedule">&nbsp;&nbsp;课表管理&nbsp;&nbsp;</a></td>
    <td><a href="/web/login/logout">&nbsp;&nbsp;logout&nbsp;&nbsp;</a></td>
</ul>

<ul>
    <h2>员工管理页面</h2>
</ul>

<div class="container">
    <table class="table table-bordered">
        <tr>
            <td>工号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>邮箱</td>
            <td>岗位</td>
            <td>是否在职</td>
            <td>修改信息</td>
        </tr>
        <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.sex}</td>
            <td>${employee.age}</td>
            <td>${employee.email}</td>
            <td>${employee.role}</td>
            <td>${employee.state}</td>
            <td><a href="./employee/modify/${employee.id}">修改信息</a></td>
            </c:forEach>
        </tr>
    </table>


    <h3>
        <ul>
            <li>添加员工</li>
        </ul>
    </h3>

    <form action="/web/employee/insert" method="post">
        <table class="table table-bordered">
            <tr>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>邮箱</td>
                <td>岗位</td>
                <td>在职</td>
            </tr>
            <tr>
                <td><input type="text" name="name" value=""></td>
                <td>
                    <select name="sex">
                        <option value="male">male</option>
                        <option value="female">female</option>
                    </select>
                </td>
                <td><input type="text" name="age" value=""></td>
                <td><input type="text" name="email" value=""></td>
                <td>
                    <select name="role">
                        <option value="OPs">OPs</option>
                        <option value="HR">HR</option>
                        <option value="COACH">COACH</option>
                    </select>
                </td>
                <td><input type="text" name="state" value="YES"></td>
            </tr>
        </table>
        <input type="submit" value="添加"/>
        <input type="reset" value="清空">
    </form>
</div>

</body>
</html>
