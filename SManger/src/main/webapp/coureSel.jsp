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
<div class="title"><h2>【${stu.name}】选课情况</h2></div>

<div class="table-box">
    <table>
        <thead>
        <tr>
            <th class="num">序号</th>
            <th class="name">课程名</th>
            <th class="process">学科状态</th>
        </tr>
        </thead>
        <tbody id="stuList">
        <c:forEach items="${list}" var="cou" varStatus="vars">
            <tr>
                <td class="num">${vars.count}</td>
                <td class="name">${cou.name}</td>
                <td class="process">
                <c:if test="${cou.status == 1}">
                    <a onclick="updateTX('${stu.id}','${cou.id}')">点击退选</a><span style="color:red;">【已选课】</span>
                </c:if>
                <c:if test="${cou.status == 0}">
                    <a onclick="updateXK('${stu.id}','${cou.id}')">点击选课</a><span style="color:blue;">【未选课】</span>
                </c:if>
                </td>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--<div class="pagination ue-clear"></div>--%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
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



    $("tbody").find("tr:odd").css("backgroundColor","#eff6fa");



    $("#btn_search").click(function(){
        var stuName = $("#stuName").val();
        window.location.href="${pageContext.request.contextPath}/student/getStuList?currPage=1&stuName="+stuName;

    });


    $("#btn_clear").click(function(){
        $("#stuName").attr("value","");
    });




    function updateTX(stuId,couId){
        if(window.confirm('你确定要退选该课程？')){
            $.ajax({
                type: "POST",
                url: '${pageContext.request.contextPath}/student/delCoureSel',      //提交到一般处理程序请求数据
                data: {'stuId':stuId,'couId':couId},         //提交两个参数：pageIndex(页面索引)
                success: function(data) {
                    alert("退选成功！");
                    window.location.href="${pageContext.request.contextPath}/student/getCoureSelList?id="+stuId;
                }
            });
            return true;
        }else{
            return false;
        }
    }


    function updateXK(stuId,couId){
        if(window.confirm('你确定要选该课程？')){
            $.ajax({
                type: "POST",
                url: '${pageContext.request.contextPath}/student/addCoureSel',      //提交到一般处理程序请求数据
                data: {'stuId':stuId,'couId':couId},         //提交两个参数：pageIndex(页面索引)
                success: function(data) {
                    alert("选课成功！");
                    window.location.href="${pageContext.request.contextPath}/student/getCoureSelList?id="+stuId;
                }
            });
            return true;
        }else{
            return false;
        }
    }
</script>
</html>






























