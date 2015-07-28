<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>顾客管理</title>

    <link rel="stylesheet" href="css/customerStyle.css"/>
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
    <h2>顾客管理页面</h2>
</ul>

<div class="container">
    <table class="table table-bordered">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>删除</td>
            <td>更新</td>
        </tr>

        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.customerName}</td>
                <td><a href="./customer/delete/${customer.id}">删除信息</a></td>
                <td><a href="./customer/modify/${customer.id}">修改信息</a></td>
            </tr>
        </c:forEach>
    </table>

    <h3>
        <ul>
            <li>添加顾客</li>
        </ul>
    </h3>

    <form action="/web/customer/insert" method="post">
        <table class="table table-bordered">
            <tr>
                <td>姓名</td>
            </tr>

            <tr>
                <td><input type="text" name="customerName" value=""></td>
            </tr>
        </table>

        <input type="submit" value="提交"/>
        <input type="reset" value="清空">
    </form>


</div>
</body>
</html>
