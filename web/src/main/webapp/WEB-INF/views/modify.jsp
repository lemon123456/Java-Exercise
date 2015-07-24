<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>
<body>

<form action="/web/users/modify" method="post">
    <tr>
        序号 :<input type="text" name="id" value="${user.id}" readonly="readonly"/>
        用户名 :<input type="text" name="name" value="${user.name}"/>
        密码 :<input type="password" name="password" value="user.password">
        工号 :<input type="text" name="employeeId" value="${user.employee.id}" readonly="readonly">
    </tr>
    </br>
    <input type="submit" value="更新"/>
</form>


</body>
</html>
