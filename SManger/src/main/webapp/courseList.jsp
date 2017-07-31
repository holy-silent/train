<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>4.0.0</version>
</dependency>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/info-mgt.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/WdatePicker.css" />
    <title>学生信息管理系统</title>
</head>

<body>
<div class="title"><h2>课程管理</h2></div>
<div class="query">
    <div class="query-conditions ue-clear">

        <div class="conditions staff ue-clear">
            <label>课&nbsp;&nbsp;&nbsp;程&nbsp;&nbsp;&nbsp;号：</label>
            <input type="text" placeholder="可以直接输入或选择" />

        </div>
    </div>
    <div class="query-btn ue-clear">
        <a href="javascript:;" class="confirm">查123434询</a>
        <a href="javascript:;" class="clear">清空条件</a>
    </div>
</div>
<div class="table-operate ue-clear">
    <a href="javascript:;" class="add">添加</a>
</div>
<div class="table-box">
    <table>
        <thead>
        <tr>
            <th class="process">课程号</th>
            <th class="name">课程名</th>
            <th class="operate">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="course" varStatus="vars">
            <tr>
                <td class="process">${course.id}</td>
                <td class="name">${course.name}</td>
                <td class="table-operate " style="background:white;">
                    <a href="javascript:;" class="del" onClick="deleteUser('${user.user_id}')">删除</a>
                    <a href="/SwitchPlatform/role/updateUserSel?userId=${user.user_id}" class="edit">编辑</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">
    $(".select-title").on("click",function(){
        $(".select-list").hide();
        $(this).siblings($(".select-list")).show();
        return false;
    })
    $(".select-list").on("click","li",function(){
        var txt = $(this).text();
        $(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
    })

    $('.pagination').pagination(100,{
        callback: function(page){
            alert(page);
        },
        display_msg: true,
        setPageNo: true
    });

    $("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

</script>
</html>































