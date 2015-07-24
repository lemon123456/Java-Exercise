<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>健身房管理系统</title>

    <style type="text/css">
        ul {
            display: inline-block;
            float: left;
            width: 100%;
            padding: 0;
            margin: auto 200px;
            list-style-type: none;
            text-align: center;
        }

        a {
            float: left;
            position: relative;
            width: 7em;
            text-decoration: none;
            color: white;
            background-color: purple;
            padding: 0.2em 0.6em;
            border-right: 1px solid white;
        }

        a:hover {
            background-color: #ff3300
        }

        li {
            display: inline
        }
    </style>


</head>

<body>
<div>
    <ul>
        <a href="/web/">首页</a>
        <a href="/web/users">用户管理</a>
        <a href="/web/employee">员工管理</a>
        <a href="/web/course">课程管理</a>
        <a href="/web/customer">顾客管理</a>
        <a href="/web/schedule">课表管理</a>
        <li><a href="/web/login">登陆</a><a href="./users/insert">注册</a></li>
    </ul>
</div>
</body>
</html>
