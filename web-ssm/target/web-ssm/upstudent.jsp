<%--
  Created by IntelliJ IDEA.
  User: syf
  Date: 2017/7/27
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改学生</title>
</head>
<body>
<form action="/student/updateStudent" method="post">
<c:if test="${!empty student}">
    <table style="border-radius:20px;padding-left: 20px;padding-top: 20px;padding-bottom: 30px;font-size: 22px;font-weight:bold;font-family:宋体;background-color:#999999;margin-top: 0px;margin-left: 250px;width: 500px;height: 300px">
        <tr>
            <td>ID</td>
            <td><input type="text" value="${student.id}" readonly name="id" /></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" value="${student.name}" name="name" /></td>
        </tr><br/>
        <tr>
            <td>学号</td>
            <td><input type="text" value="${student.no}" name="no" /></td>
        </tr><br/>
        <tr>
            <td>年龄</td>
            <td><input type="text" value="${student.age}" name="age" /></td>
        </tr><br/>
        <tr>
            <td>年级</td>
            <td><input type="text" value="${student.grade}" name="grade" /></td>
        </tr>
        <tr>
            <td>班级</td>
            <td><input type="text" value="${student.stuclass}" name="stuclass" /></td>
        </tr>

        <tr>
            <td ><input style="width: 100px;height: 40px;margin-left: 120px;margin-top:30px "type="submit"  value="保存"></td>
        </tr>
    </table>
</c:if>
</form>
</body>
</html>
