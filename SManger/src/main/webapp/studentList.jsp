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
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info-mgt.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/WdatePicker.css" />
<title>学生信息管理系统</title>
</head>

<body>
<div class="title"><h2>学生管理</h2></div>
<div class="query">
	<div class="query-conditions ue-clear">

        <div class="conditions staff ue-clear">
            <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
            <input type="text" placeholder="可以直接输入或选择" />

        </div>
    </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:;" class="confirm">查询</a>
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
            	<th class="num">序号</th>
                <th class="name">姓名</th>
                <th class="process">学号</th>
                <th class="node">年龄</th>
                <th class="time">年级</th>
                <th class="time">班级</th>
                <th class="operate">操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="stu" varStatus="vars">
                <tr>
                    <td class="num">${vars.count}</td>
                    <td class="name">${stu.name}</td>
                    <td class="process">${stu.no}</td>
                    <td class="node">${stu.age}岁</td>
                    <td class="time">${stu.grade}届</td>
                    <td class="time">${stu.stuClass}班</td>
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






























