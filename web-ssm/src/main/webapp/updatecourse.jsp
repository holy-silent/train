<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2017/7/27
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改课程</title>
</head>
<body>
<form action="" method="post">
    <table style="border-radius:20px;padding-left: 20px;padding-top: 20px;padding-bottom: 30px;font-size: 22px;font-weight:bold;font-family:宋体;background-color:#999999;margin-top: 0px;margin-left: 250px;width: 500px;height: 300px">
        <tr>
            <td>课程名</td>
            <td><input type="text" value="<%=rs.getString(5)%>" name="phone" /></td>
        </tr><br/>

        <tr>
            <td ><input style="width: 100px;height: 40px;margin-left: 120px;margin-top:30px "type="submit"  value="保存"></td>
        </tr>
    </table>
</form>
</body>
</html>
