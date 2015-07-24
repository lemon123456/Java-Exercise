<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/web/schedule/modify/${schedule.id}" method="post">
    <table class="table table-bordered">

        <tr>
            编号 :<input type="text" name="id" value="${schedule.id}" readonly="readonly"/>


            课程 :<select name="courseId">
            <c:forEach items="${courseList}" var="course">
                <option value="${course.id}">${course.courseName}</option>
            </c:forEach>
        </select>

            教练 :<select name="coachId">
            <c:forEach items="${coachList}" var="coach">
                <option value="${coach.id}">${coach.name}</option>
            </c:forEach>
        </select>

            时间 :<input type="date" name="time" value="${schedule.time}"/>

            顾客 :<select name="customer">
            <c:forEach items="${customerList}" var="customer">
                <option value="${customer.customerName}">${customer.customerName}</option>
            </c:forEach>
        </select>

        </tr>

    </table>

    <input type="submit" value="提交"/>
    <input type="reset" value="清空">
</form>
</body>
</html>
