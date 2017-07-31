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
    <link href="css/bootstrap-combined.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <link href="css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" property="" />
    <link href="//fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</head>
<body>
<table style="font-family: 宋体;font-size: 25px;margin-left: 100px;margin-top: 100px">

    <form action="/student/addStudent" method="post" style="margin-left: 100px;margin-top: 70px">

        <tr><td>姓名：<input type="text" name="name" /></td></tr>
        <tr><td>学号：<input type="text" name="no" /></td></tr>
        <tr><td>年龄：<input type="text" name="age" /></td></tr>

        <tr><td>年级：<select name="grade" style="font-size:15px; ">
            <option value="初一">初一</option>
            <option value="初二">初二</option>
            <option value="初三">初三</option>
        </select>
        </td></tr>
        <tr><td>班级：<select name="stuclass" style="font-size:15px; ">
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
