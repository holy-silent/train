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
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/info-reg.css" />
<title>学生信息管理系统</title>
</head>

<body>
<div class="title"><h2>学生信息录入</h2></div>
<div class="main">
    <p class="short-input ue-clear">
    	<label>姓名：</label>
        <input type="text" placeholder="请输入姓名" name="姓名" class="noNull" id="name"/>
    </p>
    <p class="short-input ue-clear">
        <label>学号：</label>
        <input type="text" placeholder="请输入学号"  name="学号" class="noNull num" id="no"/>
    </p>
    <p class="short-input ue-clear">
        <label>年龄：</label>
        <input type="text" placeholder="请输入年龄"  name="年龄" class="noNull num" id="age"/>
    </p>
    <p class="short-input ue-clear">
        <label>年级：</label>
        <input type="text" placeholder="请输入年级"  name="年级" class="noNull num" id="grade"/>
    </p>
    <p class="short-input ue-clear">
        <label>班级：</label>
        <input type="text" placeholder="请输入班级"  name="班级" class="noNull num" id="class"/>
    </p>
</div>
<div class="btn ue-clear">
	<a href="javascript:;" class="confirm" id="btn_add">增加</a>
    <a href="javascript:;" class="clear" id="btn_clear">返回</a>
</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
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
        var name = $("#name").val();
        var no = $("#no").val();
        var age = $("#age").val();
        var grade = $("#grade").val();
        var clazz = $("#class").val();
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/student/studentAdd',      //提交到一般处理程序请求数据
            data: {'name':name,'no':no,'age':age,'grade':grade,'clazz':clazz},         //提交两个参数：pageIndex(页面索引)
            success: function(data) {
                if(data==-1){
                    alert("该学号已存在，请重新输入！");
                    $("#no").focus();
                }else{
                    alert("添加成功！");
                    window.location.href="${pageContext.request.contextPath}/student/getStuList?currPage=1";
                }
            }
        });
    });


    $("#btn_clear").click(function(){
       history.back();
    });

</script>
</html>
