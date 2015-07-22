<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/19/15
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
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
    <li>员工管理页面</li>
  </ul>

  <table border="1">
    <tr>
      <td>工号</td>
      <td>姓名</td>
      <td>岗位</td>
      <td>修改信息</td>
    </tr>


      <c:forEach items="${employeeList}" var="employee">
        <tr>
          <td>${employee.id}</td>
          <td>${employee.name}</td>
          <td>${employee.role}</td>
          <td><a href="./employee/modify/${employee.id}">修改信息</a></td>
        </tr>
      </c:forEach>

  </table>

<ul><ul></ul></ul>

  <form action="/web/employee/insert" method="post">
    <table border="1">
      <tr>
        <td>姓名</td>
        <td>岗位</td>
      </tr>

      <tr>
        <td><input type="text" name="name" value=""></td>
        <%--<td><input type="text" name="role" value=""></td>--%>
        <td>
          <select name="role">
            <option value="OPs">OPs</option>
            <option value="HR">HR</option>
            <option value="COACH">COACH</option>
          </select>
        </td>
      </tr>
    </table>

    <input type="submit" value="提交"/>
    <input type="reset" value="清空">
  </form>
</body>
</html>
