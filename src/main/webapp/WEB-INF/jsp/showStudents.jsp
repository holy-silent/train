<%--
  Created by IntelliJ IDEA.
  User: Zhangxq
  Date: 2016/7/16
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>学生信息列表</title>
</head>
<body>
    <c:if test="${!empty studentList}">
        <c:forEach var="student" items="${studentList}">
            姓名：${student.name} &nbsp;&nbsp;序号：${user.no} &nbsp;&nbsp;年龄：${student.age} &nbsp;&nbsp;年级：${student.grade} &nbsp;&nbsp;班级：${student.stuclass} &nbsp;&nbsp;<br>
        </c:forEach>
    </c:if>
</body>
</html>
