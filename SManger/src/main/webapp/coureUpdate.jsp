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
<div class="title"><h2>课程信息修改</h2></div>
<div class="main">
    <input type="hidden" placeholder="请输入姓名" name="姓名" class="noNull" id="id" value="${cou.id}"/>
    <p class="short-input ue-clear">
    	<label>课程名称：</label>
        <input type="text" placeholder="请输入课程名称" name="课程名称" class="noNull" id="name" value="${cou.name}"/>
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

        var id = $("#id").val();
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/coure/studentUpdate',      //提交到一般处理程序请求数据
            data: {'id':id,'name':name},         //提交两个参数：pageIndex(页面索引)
            success: function(data) {
                alert("修改成功！");
                window.location.href="${pageContext.request.contextPath}/coure/getCoureList?currPage=1";
            }
        });
    });

    $("#btn_clear").click(function(){
       history.back();
    });
</script>
</html>
