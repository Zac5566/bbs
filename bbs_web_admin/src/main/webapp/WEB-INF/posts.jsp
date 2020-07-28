<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>

<!-- Start: Content-Wrapper -->
<section id="content_wrapper">

    <!-- Begin: Content -->
    <section id="content" class="table-layout animated fadeIn">

        <!-- begin: .tray-center -->
        <div class="tray tray-center">

            <!-- Begin: Content Header -->
            <div class="content-header">
                <h2>帖子管理</h2>
                <p class="lead"></p>
            </div>
            <!-- message listing panel -->
            <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">

                <div class="panel  heading-border">
                    <!-- message listings table -->
                    <div class="panel-body pn">
                        <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                            <thead>
                            <tr class="">
                                <th class="hidden-xs">ID</th>
                                <th class="hidden-xs">标题</th>
                                <th class="hidden-xs">作者</th>
                                <th class="hidden-xs">内容</th>
                                <th class="text-center">发帖时间</th>
                                <th>删除</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${postList}" var="post">
                            <tr class="message-unread">
                                <td class="">${post.id}</td>
                                <td class="">${post.title}</td>
                                <td class="">${post.username}</td>
                                <td class="">${post.content}</td>
                                <td class="text-center fw600"><spring:eval expression="post.createTime"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/post/remove?id=${post.id}">删除</a>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
                <!-- end: .admin-form -->

            </div>
            <!-- end: .tray-center -->
    </section>
    <!-- End: Content -->

</section>
<!-- End: Content-Wrapper -->

<jsp:include page="bottom.jsp"/>
