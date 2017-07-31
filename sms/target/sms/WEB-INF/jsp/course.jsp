<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>学生管理系统-课程管理</title>
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
                        <li><a href="/student/1">学生管理</span></a></li>
                        <li class="active"><a href="/course/1">课程管理 <span class="sr-only">(current)</a></li>
                        <li><a href="/score/1">成绩管理</a></li>
                    </ul>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">课程管理</h1>

                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>课程</th>
                                <th>
                                    <button type="button" class="btn btn-success" style="float: right;" data-toggle="modal" data-target="#addModal" >新增课程信息</button>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${courses}">
                                    <tr>
                                        <td>${item.name}</td>
                                        <td>
                                            <div class="btn-group" role="group" style="float: right">
                                                <button type="button" class="btn btn-info" data-toggle="modal"
                                                        data-target="#updateModal" data-id="${item.id}"
                                                        data-name="${item.name}" >修改</button>
                                                <button type="button" class="btn btn-danger" data-toggle="modal"
                                                        data-target="#deleteModal" data-id="${item.id}">删除</button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <!-- 页码开始 -->
                        <nav aria-label="Page navigation" style="float: right">
                            <ul class="pagination">
                                <c:if test="${page.hasPreviousPage}">
                                    <li>
                                        <a href="/course/${page.pageNumber-1}" aria-label="Previous">
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
                                            <li class="active"><a href="/scourse/${item}">${item}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="/course/${item}">${item}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <c:if test="${page.hasAfterPage}">
                                    <li>
                                        <a href="/course/${page.pageNumber+1}" aria-label="Next">
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

        <!-- 新增模态框 -->
        <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">新增课程信息</h4>
                    </div>
                    <div class="modal-body">
                        <form action="/course/insert">
                            <div class="form-group">
                                <label for="name" class="control-label">课程名称</label>
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="submit" class="btn btn-primary">提交课程信息</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- 新增模态框结束 -->

        <!-- 修改模态框 -->
        <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">修改课程信息</h4>
                    </div>
                    <div class="modal-body">
                        <form action="/course/update">
                            <div class="form-group">
                                <label for="name" class="control-label">课程名称</label>
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                            <input type="hidden" name="id" id="id">
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="submit" class="btn btn-primary">更新课程信息</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- 修改模态框结束 -->

        <!-- 删除模态框 -->
        <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">删除</h4>
                    </div>
                    <div class="modal-body">
                        确认要删除吗？
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <a href="" id="deleteButton" type="button" class="btn btn-primary">确认删除</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- 删除模态框结束 -->

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="/static/dist/js/jquery-3.2.1.min.js"></script>
        <script src="/static/dist/js/bootstrap.min.js"></script>

        <script type="text/javascript">
            $('#updateModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget)
                var name = button.data('name')
                var id = button.data('id')
                var modal = $(this)
                modal.find('.modal-body input#name').val(name)
                modal.find('.modal-body input#id').val(id)
            })

            $('#deleteModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget)
                var id = button.data('id')
                var modal = $(this)
                $("#deleteButton").attr("href", "/course/delete/" + id)
            })
        </script>

    </body>
</html>