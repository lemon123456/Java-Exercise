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
    </tr>
    </br>
    <input type="submit" value="更新"/>
  </form>


</body>
</html>
