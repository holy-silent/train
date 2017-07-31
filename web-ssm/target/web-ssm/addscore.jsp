<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2017/7/26
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>添加学生成绩</title>
</head>
<body>
<table style="font-family: 宋体;font-size: 25px;margin-left: 100px;margin-top: 100px">

    <form action="/score/addScore" method="post" style="margin-left: 100px;margin-top: 70px">

        <tr><td>学生ID：<input type="text" name="stuId" /></td></tr>
        <tr><td>课程ID：<input type="text" name="couId" /></td></tr>
        <tr><td>成绩：<input type="text" name="score" /></td></tr>

        <tr></tr>
        <tr>
            <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="保存" />
            </td>
        </tr>
    </form>
</table>
</body>
</html>
