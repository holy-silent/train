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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info-reg.css" />
<title>学生信息管理系统</title>
</head>

<body>
<div class="title"><h2>成绩信息修改</h2></div>
<div class="main">
    <input type="hidden" placeholder="请输入姓名" name="姓名" class="noNull" id="stuId" value="${stu.stuId}"/>
    <input type="hidden" placeholder="请输入姓名" name="姓名" class="noNull" id="couId" value="${stu.couId}"/>

    <p class="short-input ue-clear">
    	<label>姓名：</label>
        <input type="text" placeholder="请输入姓名" readonly name="姓名" class="noNull" id="name" value="${stu.stuName}"/>
    </p>
    <p class="short-input ue-clear">
        <label>成绩：</label>
        <input type="text" placeholder="请输入成绩"  name="学号" class="noNull num" id="score" value="${stu.score}" />
    </p>
</div>
<div class="btn ue-clear">
	<a href="javascript:;" class="confirm" id="btn_update">修改</a>
    <a href="javascript:;" class="clear" id="btn_clear">返回</a>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<script type="text/javascript">
    $("#btn_update").click(function(){
        //表单非空校验
        $(".noNull").each(function(){
            var name = $(this).attr("name");
            if($(this).val()==""){
                alert($(this).attr('name')+"不能为空");
                $(this).focus();
                return false;
            }
        });
        $(".num").each(function(){
            var name = $(this).attr("name");
            var num = $(this).val();
            var reg = new RegExp("^[0-9]*$");
            if(!reg.test(num)){
                alert($(this).attr('name')+"只能为数字");
                $(this).focus();
                return false;
            }
        });
        var name = $("#name").val();
        var score = $("#score").val();

        var stuId = $("#stuId").val();
        var couId = $("#couId").val();

        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/score/studentUpdate',      //提交到一般处理程序请求数据
            data: {'stuId':stuId,'couId':couId,'name':name,'score':score},         //提交两个参数：pageIndex(页面索引)
            success: function(data) {
                alert("修改成功！");
                window.location.href="${pageContext.request.contextPath}/score/getStuList?currPage=1&couId="+couId;
            }
        });
    });

    $("#btn_clear").click(function(){
        history.back();
    });
</script>
</html>
