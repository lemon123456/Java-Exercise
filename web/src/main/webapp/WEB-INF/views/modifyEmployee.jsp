<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/20/15
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/web/employee/modify/${employee.id}" method="post">
  <tr>
    工号 :<input type="text" name="id" value="${employee.id}" readonly="readonly"/>
    姓名 :<input type="text" name="name" value="${employee.name}"/>
    岗位 :<input type="text" name="role" value="${employee.role}"/>
  </tr>
  </br>
  <input type="submit" value="更新"/>
</form>


</body>
</html>
