<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2017/7/26
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>添加学生</title>
</head>
<body>
<table style="font-family: 宋体;font-size: 25px;margin-left: 100px;margin-top: 100px">

    <form action="/student/addStudent" method="post" style="margin-left: 100px;margin-top: 70px">

        <tr><td>姓名：<input type="text" name="name" /></td></tr>
        <tr><td>学号：<input type="text" name="no" /></td></tr>
        <tr><td>年龄：<input type="text" name="age" /></td></tr>

        <tr><td>年级：<select name="grade">
            <option value="初一">初一</option>
            <option value="初二">初二</option>
            <option value="初三">初三</option>
        </select>
        </td></tr>
        <tr><td>班级：<select name="stuclass">
            <option value="一班">一班</option>
            <option value="二班">二班</option>
            <option value="三班">三班</option>
            </select>
        </td></tr>
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
