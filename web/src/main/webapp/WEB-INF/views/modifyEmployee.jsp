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
    性别 :<input type="text" name="sex" value="${employee.sex}"/>
    年龄 :<input type="text" name="age" value="${employee.age}"/>
    邮箱 :<input type="text" name="email" value="${employee.email}"/>
    岗位 :<input type="text" name="role" value="${employee.role}"/>
    是否在职 :<input type="text" name="state" value="${employee.state}"/>
  </tr>
  </br>
  <input type="submit" value="更新"/>
</form>


</body>
</html>
