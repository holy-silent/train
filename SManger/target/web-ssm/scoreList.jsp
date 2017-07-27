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
<div class="title"><h2>成绩管理</h2></div>
<div class="query">
    <div class="query-conditions ue-clear">

        <div class="conditions staff ue-clear">
            <label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;明：</label>
            <input type="hidden" placeholder="请输入姓名" value="${couId}" id="couId"/>
            <input type="text" placeholder="请输入姓名" value="${stuName}" id="stuName"/>
        </div>
    </div>
    <div class="query-btn ue-clear">
        <a href="javascript:;" class="confirm" id="btn_search">查询</a>
        <a href="javascript:;" class="clear" id="btn_clear">返回</a>
    </div>
</div>
<div class="table-operate ue-clear">
    <a onclick="add()" class="add">录入</a>
</div>
<div class="table-box">
    <table>
        <thead>
        <tr>
            <th class="num">学号</th>
            <th class="name">姓名</th>
            <th class="process">成绩</th>
            <th class="operate">操作</th>
        </tr>
        </thead>
        <tbody id="stuList">
        <c:forEach items="${students}" var="stu" varStatus="vars">
            <tr>
                <td class="num">${stu.stuId}</td>
                <td class="name">${stu.stuName}</td>
                <td class="node">${stu.score}分</td>
                <td class="table-operate " style="background:white;">
                    <a href="javascript:;" class="del" onClick="deleteStu('${stu.stuId}','${stu.couId}')">删除</a>
                    <a href="${pageContext.request.contextPath}/score/getStuById?stuId=${stu.stuId}&couId=${stu.couId}" class="edit">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
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

    /**
     * 分页
     */
    var count = "<%=request.getAttribute("countN")%>";


    $('.pagination').pagination(count,{
        callback: function(page){
            var c = page+1;
            var stuName = $("#stuName").val();
            var couId = $("#couId").val();
            InitTable(c,stuName,couId);
        },
        display_msg: true,
        setPageNo: true
    });

    //请求数据
    function InitTable(pageIndex,stuName,couId) {
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/score/getStuListPaging',      //提交到一般处理程序请求数据
            data: {'currPage':pageIndex,'stuName':stuName,'couId':couId},         //提交两个参数：pageIndex(页面索引)
            success: function(data) {
                var json = eval(data);
                var html="";
                $.each(json,function(index,item){
                    html = html+'<tr>'
                        +'  <td class="num">'+item.stuId+'</td>'
                        +'  <td class="name">'+item.stuName+'</td>'
                        +'  <td class="node">'+item.score+'分</td>'
                        +'  <td class="table-operate " style="background:white;">'
                        +'	    <a  class="del" onClick="deleteStu('+item.stuId+','+item.couId+')">删除</a>'
                        +'	    <a  class="edit" href="${pageContext.request.contextPath}/score/getStuById?stuId='+item.stuId+'&couId='+item.couId+'" >修改</a>'
                        +'  </td>'
                        +'</tr>';
                });
                $("#stuList").html("");
                $("#stuList").append(html);
                $("tbody").find("tr:odd").css("backgroundColor","#eff6fa");
            },
            contentType:'application/x-www-form-urlencoded; charset=UTF-8'
        });
    }


    $("tbody").find("tr:odd").css("backgroundColor","#eff6fa");



    $("#btn_search").click(function(){
        var stuName = $("#stuName").val();
        var couId = $("#couId").val();
        window.location.href="${pageContext.request.contextPath}/score/getStuList?currPage=1&stuName="+stuName+"&couId="+couId;

    });


    $("#btn_clear").click(function(){
        history.back();
    });


    function deleteStu(stuId,couId){
        if(window.confirm('你确定要删除该学生的成绩？')){
            $.ajax({
                type: "POST",
                url: '${pageContext.request.contextPath}/score/delStuList',      //提交到一般处理程序请求数据
                data: {'stuId':stuId,'couId':couId},         //提交两个参数：pageIndex(页面索引)
                success: function(data) {
                    alert("删除成功！");
                    window.location.href="${pageContext.request.contextPath}/score/getStuList?currPage=1&couId="+couId;
                }
            });
            return true;
        }else{
            return false;
        }
    }


    function add(){
        var couId = $("#couId").val();
        window.location.href="${pageContext.request.contextPath}/score/getGzq?couId="+couId;
    }
</script>
</html>






























