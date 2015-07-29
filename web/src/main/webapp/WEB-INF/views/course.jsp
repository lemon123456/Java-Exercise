<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>课程管理</title>
    <link rel="stylesheet" href="css/customerStyle.css"/>

</head>
<body>

<ul class="navigation">
    <li class="nav-item"><a href="/web/">首页</a></li>
    <li class="nav-item"><a href="/web/users">用户管理</a></li>
    <li class="nav-item"><a href="/web/employee">员工管理</a></li>
    <li class="nav-item"><a href="/web/course">课程管理</a></li>
    <li class="nav-item"><a href="/web/customer">顾客管理</a></li>
    <li class="nav-item"><a href="/web/schedule">课表管理</a></li>
    <li class="nav-item"><a href="/web/login/logout">logout</a></li>
</ul>

<h2>课程管理页面</h2>

<div class="container updateCourseForm">
    <form id="updateCourseForm" hidden>
        编号 :<input type="text" id="idInput" name="id" readonly="readonly"/>
        课程 :<input type="text" id="nameInput" name="courseName" />
        描述 :<input type="text" id="descriptionInput" name="description"/>
        <input class="submitInput" id="submitInput" type="submit"/>
    </form>
</div>

<div class="container">
    <table id="courseTable" class="table table-bordered">
        <tr id="navigatorOfCourseTable">
            <td>编号</td>
            <td>课程</td>
            <td>描述</td>
            <td>删除</td>
            <td>更新</td>
        </tr>
        <c:forEach items="${courseList}" var="course">
            <tr>
                <td class="course-id">${course.id}</td>
                <td class="course-name">${course.courseName}</td>
                <td class="course-description">${course.description}</td>
                <td id="${course.id}">
                    <button class="button deleteButton">删除</button>
                </td>
                <td>
                    <button class="button updateButton">更新</button>
                </td>
            </tr>
        </c:forEach>
    </table>

    <li id="insertButton">添加课程</li>
    <form id="insertCourseForm" hidden>
        <table class="table table-bordered" id="insertTable">
            <tr>
                <td>课程</td>
                <td>描述</td>
            </tr>
            <tr>
                <td><input type="text" name="courseName" id="nameInsert" value=""></td>
                <td><input type="text" name="description" value=""></td>
            </tr>
        </table>
        <button class="button insertButton" type="button">提交
        </button>
        <button class="button resetButton" type="reset">清空</button>
    </form>

</div>

<script src="lib/js/jquery-1.11.1.min.js"></script>
<script src="./js/course.js"></script>

</body>
</html>
