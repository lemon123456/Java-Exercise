<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/21/15
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="/web/courses/modify/${course.id}" method="post">
      <tr>
        编号 :<input type="text" name="id" value="${course.id}" readonly="readonly"/>
        课程 :<input type="text" name="courseName" value="${course.courseName}"/>
        教练ID :<input type="text" name="coachId" value="${course.employee.id}"/>
        时间 :<input type="text" name="time" value="${course.time}"/>
      </tr>
      </br>
      <input type="submit" value="更新"/>
    </form>
</body>
</html>
