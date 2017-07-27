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
<div class="title"><h2>成绩录入</h2></div>
<input type="hidden" value="${couId}" id="couId"/>
<div class="main">
    <p class="short-input ue-clear">
        <label>学号：</label>
        <select style="height:28px;width:240px;" id="stuId">
            <c:forEach items="${list}" var="stu" varStatus="vars">
                <option value="${stu.stuId}">${stu.stuName}</option>
            </c:forEach>
        </select>
    </p>
    <p class="short-input ue-clear">
        <label>成绩：</label>
        <input type="text" placeholder="请输入成绩"  name="成绩" class="noNull num" id="score"/>
    </p>

</div>
<div class="btn ue-clear">
	<a href="javascript:;" class="confirm" id="btn_add">增加</a>
    <a href="javascript:;" class="clear" id="btn_clear">返回</a>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<script type="text/javascript">
    $("#btn_add").click(function(){
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
        var couId = $("#couId").val();
        var stuId = $("#stuId").val();
        var score = $("#score").val();
        //alert(couId+"--"+stuId+"--"+score);
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/score/studentAdd',      //提交到一般处理程序请求数据
            data: {'couId':couId,'stuId':stuId,'score':score},         //提交两个参数：pageIndex(页面索引)
            success: function(data) {
                alert("录入成功！");
                 window.location.href="${pageContext.request.contextPath}/score/getStuList?currPage=1&couId="+couId;
            }
        });
    });


    $("#btn_clear").click(function(){
       history.back();
    });

</script>
</html>
