<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>任务</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echars/echarts.common.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echars/task_chart.js"></script>

<body style="height: 100%; margin: 0">
<center><h2>各科成绩统计</h2></center>
	<div style="height: 75%; margin-top: 20px; border-bottom: 1px solid #E5E5E5; padding-bottom:12px;">
		<div id="distrib_container" style="width: 100%; height: 100%; display:inline-block;"></div>
		<input type="hidden" value="${jsonStr}" id="jsonStr"/>
		<input type="hidden" value="${stuNameStr}" id="stuName"/>
		<input type="hidden" value="${coureNameStr}" id="couName"/>
		<span id="jsonStr2" style="display: none;">${jsonStr}</span>
		<script>
          var jsonStr = eval("(" + $("#jsonStr2").html()+ ")");;//[{"rowname":"数学","小强":"86","小明":"89","张明":"90","李四":"55","赵五":"94"},{"rowname":"英语","小强":"95","小明":"56","张明":"91","李四":"78","赵五":"89"},{"rowname":"语文","小强":"80","小明":"77","张明":"96","李四":"89","赵五":"91"}];
          var stuName = $("#stuName").val();//'小强,小明,张明,李四,赵五';
          var couName =$("#couName").val();//
          (function() {
                createHistogram(
                    "distrib_container",
                    jsonStr,
                    couName,
					stuName
                );
            })();
		</script>
	</div>
</body>
</html>
