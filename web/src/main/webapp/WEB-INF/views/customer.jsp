<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/19/15
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>顾客管理</title>
</head>
<body>

    <ul>
      <li>
        <td><a href="/web/">&nbsp;&nbsp;首页&nbsp;&nbsp;</a></td>
        <td><a href="/web/users">&nbsp;&nbsp;用户管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/employee">&nbsp;&nbsp;员工管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/courses">&nbsp;&nbsp;课程管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/customer">&nbsp;&nbsp;顾客管理&nbsp;&nbsp;</a></td>
        <td> <a href="/web/login/logout">&nbsp;&nbsp;logout&nbsp;&nbsp;</a> </td>
      </li>
    </ul>

    <ul>
        <li>顾客管理页面</li>
    </ul>

    <table border="1">
      <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>教练姓名</td>
        <td>教练ID</td>
        <td>删除</td>
        <td>更新</td>
      </tr>

        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.customerName}</td>
                <td>${customer.employee.name}</td>
                <td>${customer.employee.id}</td>
                <td><a href="./customer/delete/${customer.id}">删除信息</a></td>
                <td><a href="./customer/modify/${customer.id}">修改信息</a></td>
            </tr>
        </c:forEach>
    </table>

    <ul><ul></ul></ul>

    <form action="/web/customer/insert" method="post">
        <table border="1">
            <tr>
                <td>姓名</td>
                <td>教练ID</td>
            </tr>

            <tr>
                <td><input type="text" name="customerName" value=""></td>
                <td><input type="text" name="coachId" value=""></td>
            </tr>
        </table>

        <input type="submit" value="提交"/>
        <input type="reset" value="清除">
    </form>


</body>
</html>
