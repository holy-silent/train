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
<c:if test="${!empty scoresList}">
    <c:forEach var="score" items="${scoresList}">
        学生ID：${score.stuId} &nbsp;&nbsp;课程ID：${score.stuId} &nbsp;&nbsp;分数：${score.score} &nbsp;&nbsp;<br>
    </c:forEach>
</c:if>
</body>
</html>
