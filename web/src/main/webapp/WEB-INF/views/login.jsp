<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/13/15
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户登陆页面</title>
</head>

<body>
<h3>Login with Username and Password (Customer Page)</h3>

<form action="./login" method="post">
  用户名:<input type="text" name="customerName" />
  密&nbsp;&nbsp;码:<input type="password" name="CustomerPassword" />
  <input type="submit" value=" 登 录 "  />
  <input type="reset" value=" 重 置 " />
</form>





<%--<%--%>
  <%--// 用户名：admin 密码:123--%>
  <%--String name = request.getParameter("customerName"); // 取得 name 的信息--%>
  <%--String password = request.getParameter("customerPassword"); // 取得 password 的信息--%>
  <%--if(name=="admin" && password=="123")--%>
  <%--{--%>
<%--//    response.setHeader("refresh", "2; URL = /user");  // 定时跳转--%>
<%--//    session.setAttribute("userid", name);  // 登录成功的用户名保存在 session 中--%>

<%--%>--%>
<%--<h3>用户登陆成功，两秒钟后跳转到用户管理页面！</h3>--%>
<%--&lt;%&ndash;<h3>如果没有自动跳转，请按<a href="/web/user">这里</a></h3>&ndash;%&gt;--%>
<%--<%--%>
  <%--}%>--%>

</body>
</html>
