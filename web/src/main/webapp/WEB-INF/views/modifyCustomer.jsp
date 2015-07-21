<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/21/15
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


  <form action="/web/customer/modify/${customer.id}" method="post">
    <tr>
      编号 :<input type="text" name="id" value="${customer.id}" readonly="readonly"/>
      姓名 :<input type="text" name="customerName" value="${customer.customerName}"/>
      教练ID :<input type="text" name="coachId" value="${customer.employee.id}"/>
    </tr>
    </br>
    <input type="submit" value="更新"/>
  </form>


</body>
</html>
