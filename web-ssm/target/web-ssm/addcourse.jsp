<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2017/7/26
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
</head>
<body>
<table style="font-family: 宋体;font-size: 25px;margin-left: 100px;margin-top: 100px">

    <form action="/course/addCourse" method="post" style="margin-left: 100px;margin-top: 70px">

        <tr><td>课程名：<input type="text" name="name" /></td></tr>

        <tr>
            <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="保存" />
            </td>
        </tr>
    </form>
</table>
</body>
</html>
