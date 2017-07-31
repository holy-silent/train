<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2017/7/27
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改分数</title>
</head>
<body>
<form action="/score/updateScore" method="post">
<c:if test="${!empty score}">
    <table style="border-radius:20px;padding-left: 20px;padding-top: 20px;padding-bottom: 30px;font-size: 22px;font-weight:bold;font-family:宋体;background-color:#999999;margin-top: 0px;margin-left: 250px;width: 500px;height: 300px">
        <tr>
            <td>ID</td>
            <td><input type="text" value="${score.id}" readonly name="id" /></td>
        </tr>
        <tr>
            <td>学生ID</td>
            <td><input type="text" value="${score.stuId}" name="stuId" /></td>
        </tr><br/>
        <tr>
            <td>课程ID</td>
            <td><input type="text" value="${score.couId}" name="couId" /></td>
        </tr><br/>
        <tr>
            <td>成绩</td>
            <td><input type="text" value="${score.score}" name="score" /></td>
        </tr><br/>

        <tr>
            <td ><input style="width: 100px;height: 40px;margin-left: 120px;margin-top:30px "type="submit"  value="保存"></td>
        </tr>
    </table>
</c:if>
</form>
</body>
</html>
