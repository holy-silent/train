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
<div class="title"><h2>课程管理</h2></div>
<%--<div class="query">
    <div class="query-conditions ue-clear">

        <div class="conditions staff ue-clear">
            <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
            <input type="text" placeholder="请输入姓名" value="${stuName}" id="stuName"/>

        </div>
    </div>
    <div class="query-btn ue-clear">
        <a href="javascript:;" class="confirm" id="btn_search">查询</a>
        <a href="javascript:;" class="clear" id="btn_clear">清空条件</a>
    </div>
</div>--%>
<div class="table-operate ue-clear">
    <a href="${pageContext.request.contextPath}/coureAdd.jsp" class="add">添加</a>
</div>
<div class="table-box">
    <table>
        <thead>
        <tr>
            <th class="num">课程编号</th>
            <th class="name">课程名称</th>
            <th class="operate">操作</th>
        </tr>
        </thead>
        <tbody id="stuList">
        <c:forEach items="${coures}" var="cou" varStatus="vars">
            <tr>
                <td class="num">${vars.count}</td>
                <td class="name">${cou.name}</td>
                <td class="table-operate " style="background:white;">
                    <a href="javascript:;" class="del" onClick="deleteStu('${cou.id}')">删除</a>
                    <a href="${pageContext.request.contextPath}/coure/getStuById?id=${cou.id}" class="edit">编辑</a>
                    <a href="${pageContext.request.contextPath}/score/getStuList?currPage=1&couId=${cou.id}" class="check">成绩</a>
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
            var stuName = "";
            InitTable(c,stuName);
        },
        display_msg: true,
        setPageNo: true
    });

    //请求数据
    function InitTable(pageIndex,stuName) {
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/coure/getStuListPaging',      //提交到一般处理程序请求数据
            data: {'currPage':pageIndex,'stuName':stuName},         //提交两个参数：pageIndex(页面索引)
            success: function(data) {
                var json = eval(data);
                var html="";
                $.each(json,function(index,item){
                    html = html+'<tr>'
                        +'  <td class="num">'+item.id+'</td>'
                        +'  <td class="name">'+item.name+'</td>'
                        +'  <td class="table-operate " style="background:white;">'
                        +'	    <a  class="del" onClick="deleteStu('+item.id+')">删除</a>'
                        +'	    <a  class="edit" href="${pageContext.request.contextPath}/coure/getStuById?id='+item.id+'" >编辑</a>'
                        +'      <a  class="check" href="${pageContext.request.contextPath}/score/getStuList?currPage=1&couId='+item.id+'">成绩</a>'
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
        window.location.href="${pageContext.request.contextPath}/student/getStuList?currPage=1&stuName="+stuName;

    });


    $("#btn_clear").click(function(){
        $("#stuName").attr("value","");
    });


    function deleteStu(id){
        if(window.confirm('你确定要删除该课程信息吗？')){
            $.ajax({
                type: "POST",
                url: '${pageContext.request.contextPath}/coure/delStuList',      //提交到一般处理程序请求数据
                data: {'id':id},         //提交两个参数：pageIndex(页面索引)
                success: function(data) {
                    alert("删除成功！");
                    window.location.href="${pageContext.request.contextPath}/coure/getCoureList?currPage=1";
                }
            });
            return true;
        }else{
            return false;
        }
    }
</script>
</html>






























