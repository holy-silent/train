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
<link rel="stylesheet" type="text/css" href="css/jquery.dialog.css" />
<link rel="stylesheet" href="css/index.css" />

<title>学生管理系统</title>
</head>

<body>
<div id="container">
	<div id="hd">
    	<div class="hd-wrap ue-clear">
			<div class="title">学生综合管理系统</div>
			
            <div class="toolbar ue-clear">
                <a href="/SManger/index.jsp" class="home-btn">首页</a>
                <a href="javascript:;" class="quit-btn exit"></a>
            </div>
			<div class="login-info ue-clear">
                <div class="welcome ue-clear" style="float:right;margin-right:100px;">
					<span>欢迎您,</span><a href="javascript:;" class="user-name">Admin</a>
				</div>
            </div>
        </div>
    </div>
	
    <div id="bd">
    	<div class="wrap ue-clear">
        	<div class="sidebar">
            	<h2 class="sidebar-header"><p>功能导航</p></h2>
                <ul class="nav">
   
                    <li class="agency">
						<div class="nav-header">
							<a href="javascript:;" date-src="/SManger/student/getStuList?currPage=1" class="ue-clear"><span>学生管理</span><i class="icon"></i></a>
						</div>
					</li>
                    <li class="gongwen"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>课程管理</span><i class="icon"></i></a></div></li>
                    <li class="office"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>成绩管理</span><i class="icon"></i></a></div></li>
                </ul>
            </div>
            <div class="content">
            	<iframe src="home.html" id="iframe" width="100%" height="100%" frameborder="0"></iframe>
            </div>
        </div>
    </div>

    <div id="ft" class="ue-clear">
        <div class="ft-left">
            <span>学生综合管理系统</span>
            <em>ChinaUnicom&nbsp;System</em>
        </div>
        <div class="ft-right">
            <span>入职框架练习</span>
            <em>V1.0&nbsp;2017</em>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.dialog.js"></script>
<script type="text/javascript" src="js/index.js"></script>

</html>
