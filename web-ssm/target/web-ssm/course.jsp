<%--
  Created by IntelliJ IDEA.
  User: guoyue
  Date: 2017/7/26
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>">
<html>
<head>
    <title>學生管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

    <link href="css/bootstrap-combined.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <link href="css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" property="" />
    <link href="//fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
            });
        });
    </script>
</head>
<body>
<center>
    <div style="margin-top: 20px">
        <form class="form-search" action="/course/searchOne">
            <input name="oneCourseId" class="input-medium search-query" type="number" placeholder="输入课程ID" maxlength="8"/> <button class="btn" type="submit">查找</button>
            <a href="addcourse.jsp"><button class="btn" type="button" >添加</button></a>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th>序号</th>
                <th>课程名</th>
                <th>操作</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${!empty courseList}">
                <c:forEach var="course" items="${courseList}">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.name}</td>
                        <td><a href="/course/updateShow?id=${course.id}">修改</a></td>
                        <td><a href="/course/delCourse?id=${course.id}">删除</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
       <div class="pagination pagination-centered">
           <ul>
               <c:if test="${currentPage!=1}">
                   <li><a href="/course/showCoursesPages?currentPage=${currentPage-1}">上一页</a></li>
               </c:if>

               <c:if test="${currentPage!=totalPages}">
                   <li><a href="/course/showCoursesPages?currentPage=${currentPage+1}">下一页</a></li>
               </c:if>
           </ul>
       </div>
    </div>
</center>
</body>
</html>
