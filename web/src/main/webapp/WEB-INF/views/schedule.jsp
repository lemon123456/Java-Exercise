<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./lib/css/customerStyle.css" rel="stylesheet" type="text/css"/>

<html>
<head>
    <title>课程表管理</title>
    <title></title>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
    <script src="${jquery}"></script>
    <spring:url value="./js/scedule.js" var="scheduleJs"/>
    <script src="${scheduleJs}"></script>

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
    <h2>课程表管理页面</h2>
</ul>


<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <td>编号</td>
            <td>课程</td>
            <td>教练</td>
            <td>时间</td>
            <td>顾客</td>
            <td>删除用户</td>
            <td>修改信息</td>
        </tr>
        </thead>

        <c:forEach items="${scheduleList}" var="schedule">
            <tr>
                <td>${schedule.id}</td>
                <td>${schedule.course.courseName}</td>
                <td>${schedule.employee.name}</td>
                <td>${schedule.time}</td>
                <td>${schedule.customer}</td>
                <td><a href="./schedule/delete/${schedule.id}">删除用户</a></td>
                <td><a href="./schedule/modify/${schedule.id}">修改信息</a></td>
            </tr>
        </c:forEach>
    </table>


    <ul>
        <li>添加公共课</li>
    </ul>

    <form action="/web/schedule/insert" method="post">
        <table class="table table-bordered">
            <tr>
                <td>课程</td>
                <td>教练</td>
                <td>时间</td>
                <td>顾客</td>
            </tr>

            <tr>
                <td>
                    <select name="courseId">
                        <c:forEach items="${courseList}" var="course">
                            <c:if  test="${course.courseName != 'private'}">
                              <option value="${course.id}">${course.courseName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="coachId">
                        <c:forEach items="${coachList}" var="coach">
                            <option value="${coach.id}">${coach.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="date" name="time" value=""></td>
                <td><input type="text" name="customer" value="ALL"></td>
            </tr>
        </table>

        <input type="submit" value="提交"/>
        <input type="reset" value="清空">
    </form>



    <ul>
        <li>预约私教课</li>
    </ul>

    <form action="/web/schedule/insert" method="post">
        <table class="table table-bordered">
            <tr>
                <td>课程</td>
                <td>教练</td>
                <td>时间</td>
                <td>顾客</td>
            </tr>

            <tr>
                <td>
                    <select name="courseId">
                        <c:forEach items="${courseList}" var="course">
                            <c:if test="${course.courseName == 'private'}">
                               <option value="${course.id}">${course.courseName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="coachId">
                        <c:forEach items="${coachList}" var="coach">
                            <option value="${coach.id}">${coach.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="date" name="time" value=""></td>
                <td>
                    <select name="customer">
                        <c:forEach items="${customerList}" var="customer">
                            <option value="${customer.customerName}">${customer.customerName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>

        <input type="submit" value="提交"/>
        <input type="reset" value="清空">
    </form>


</div>
</body>
</html>
