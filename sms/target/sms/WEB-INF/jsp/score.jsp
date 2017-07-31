<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>学生管理系统-成绩管理</title>
        <!-- Bootstrap core CSS -->
        <link href="/static/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="/static/dist/css/dashboard.css" rel="stylesheet">
    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">学生管理系统</a>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li><a href="/student/1">学生管理</a></li>
                        <li><a href="/course/1">课程管理</a></li>
                        <li class="active"><a href="/score/1">成绩管理 <span class="sr-only">(current)</span></a></li>
                    </ul>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">成绩管理</h1>

                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>姓名</th>
                                <th>科目</th>
                                <th>成绩</th>
                                <%--<th>
                                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addModal">新增成绩信息</button>
                                </th>--%>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${scoreDTOs}">
                                    <tr>
                                        <td>${item.student.name}</td>
                                        <td>${item.course.name}</td>
                                        <td>${item.score}</td>
                                        <%--<td>
                                            <div class="btn-group" role="group" style="float: right;">
                                                <button type="button" class="btn btn-info" data-toggle="modal"
                                                        data-target="#updateModal" data-id="${item.id}"
                                                        data-name="${item.name}">修改</button>
                                                <button type="button" class="btn btn-danger">删除</button>
                                            </div>
                                        </td>--%>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <!-- 页码开始 -->
                        <nav aria-label="Page navigation" style="float: right">
                            <ul class="pagination">
                                <c:if test="${page.hasPreviousPage}">
                                    <li>
                                        <a href="/score/${page.pageNumber-1}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo; 上一页</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${!page.hasPreviousPage}">
                                    <li class="disabled">
                                        <a aria-label="Previous">
                                            <span aria-hidden="true">&laquo; 上一页</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:forEach begin="${page.startPage}" end="${page.endPage}" var="item">
                                    <c:choose>
                                        <c:when test="${page.pageNumber eq item}">
                                            <li class="active"><a href="/score/${item}">${item}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="/score/${item}">${item}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <c:if test="${page.hasAfterPage}">
                                    <li>
                                        <a href="/score/${page.pageNumber+1}" aria-label="Next">
                                            <span aria-hidden="true">下一页 &raquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${!page.hasAfterPage}">
                                    <li class="disabled">
                                        <a href="#" aria-label="Next">
                                            <span aria-hidden="true">下一页 &raquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                        <!-- 页码结束 -->

                    </div>
                </div>
            </div>
        </div>



        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
        <script src="/static/dist/js/jquery-3.2.1.min.js"></script>
        <script src="/static/dist/js/bootstrap.min.js"></script>

    </body>
</html>