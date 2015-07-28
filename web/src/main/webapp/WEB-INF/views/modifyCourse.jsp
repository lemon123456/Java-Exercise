<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/web/course/modify" method="post">
    <tr>
        编号 :<input type="text" name="id" value="${course.id}" readonly="readonly"/>
        课程 :<input type="text" name="courseName" value="${course.courseName}"/>
        描述 :<input type="text" name="description" value="${course.description}"/>
    </tr>
    </br>
    <input type="submit" value="更新"/>
</form>
</body>
</html>
