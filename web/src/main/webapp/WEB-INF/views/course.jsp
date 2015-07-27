<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="./lib/css/customerStyle.css"/>

<html>
<head>
    <title>课程管理</title>
    <script src="lib/js/jquery-1.11.1.min.js"></script>
    <%--<spring:url value="./js/course.js" var="courseJs"/>--%>
    <script src="./js/course.js"></script>
</head>
<body>

<ul>
    <li>
        <td><a href="/web/">&nbsp;&nbsp;首页&nbsp;&nbsp;</a></td>
        <td><a href="/web/users">&nbsp;&nbsp;用户管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/employee">&nbsp;&nbsp;员工管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/course">&nbsp;&nbsp;课程管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/customer">&nbsp;&nbsp;顾客管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/schedule">&nbsp;&nbsp;课表管理&nbsp;&nbsp;</a></td>
        <td><a href="/web/login/logout">&nbsp;&nbsp;logout&nbsp;&nbsp;</a></td>
    </li>
</ul>

<ul>
    <h2>课程管理页面</h2>
</ul>

<div class="updateCourseForm">
    <form id="updateCourseForm" hidden>
        编号 :<input type="text" id="idInput" name="id"  readonly="readonly"/>
        课程 :<input type="text" id="nameInput" name="courseName" />
        描述 :<input type="text" id="descriptionInput" name="description"/>
        <input class="submitInput" id="submitInput" type="submit"
               onclick="updateCourse();" value="更新"/>
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
                <td>${course.id}</td>
                <td>${course.courseName}</td>
                <td>${course.description}</td>
                <td id="${course.id}">
                    <button class="button deleteButton" type="button">删除</button>
                </td>
                <td>
                    <button class="button updateButton" type="button"
                            data-course-id="<c:out value="${course.id}"/>"
                            data-course-name="<c:out value="${course.courseName}"/>"
                            data-course-description="<c:out value="${course.description}"/>">更新
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>


    <li id="insertButton">添加课程</li>
    <form id="insertCourseForm" hidden>
        <table class="table table-bordered">
            <tr>
                <td>课程</td>
                <td>描述</td>
            </tr>

            <tr>
                <td><input type="text" name="courseName" id="nameInsert" value=""></td>
                <td><input type="text" name="description" value=""></td>
            </tr>
        </table>
        <button class="button insertButton" type="button"
                onclick="insertCourse();">提交
        </button>
        <button class="button resetButton" type="reset">清空</button>
    </form>
</div>


</body>
</html>
