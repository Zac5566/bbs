<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>

<div id="main" class="main-container container">
    <!-- 首页通栏(4个推荐位) -->
    <div class="col-md-9 threads-index main-col">
        <div class="panel panel-default">

            <div class="panel-heading">
                <div class="pull-left hidden-sm hidden-xs">
                    <i class="fa fa-list"></i> 首页
                </div>
                <ul class="pull-right list-inline remove-margin-bottom thread-filter">
                    <li>
                        <a href="thread.html">
                            <i class="fa fa-history"></i> 最新话题
                        </a>
                    </li>
                    <li>
                        <a href="thread.html">
                            <i class="fa fa-diamond"> </i> 优质帖子
                        </a>
                    </li>
                    <li>
                        <a href="thread.html">
                            <i class="fa fa-thumbs-o-up"> </i> 最多按赞
                        </a>
                    </li>
                    <li>
                        <a href="thread.html">
                            <i class="fa fa-eye"></i> 等待回复
                        </a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>


            <div class="panel-body remove-padding-horizontal">
                <ul class="list-group row thread-list">
                    <!-- 显示帖子，每个li显示一个帖子的内容 -->
                    <c:forEach items="${postList.list}" var="post">
                    <li class="list-group-item media " style="margin-top: 0px;">
                        <a class="pull-right" href="post.html"><span class="badge badge-reply-count"> 25 </span>
                        </a>
                        <div class="avatar pull-left">
                            <a href="post.html">
                                <img class="media-object img-thumbnail avatar-48" alt="imooc" src="${pageContext.request.contextPath}/images/avatar.jpg"/>
                            </a>
                        </div>
                        <div class="infos">
                            <div class="media-heading">
                                <i class="fa fa-thumb-tack text-danger"></i>
                                <a href="/bbs/getPost?id=${post.id}" title="<!-- 此处存放帖子标题的内容 -->">
                                    ${post.title}   <!-- 此处显示帖子标题 -->
                                </a>
                            </div>
                            <div class="media-body meta">
                                <a href="post.html">
                                    <span class="fa fa-thumbs-o-up"> 10 </span>
                                </a>
                                <span> • </span>
                                <span>回复</span>
                                用户名
                                <a href="post.html">
                                    ${post.username}
                                </a>
                                <span> • </span>
                                <span class="timeago " data-toggle="tooltip" data-placement="top"
                                      title="2017-02-08 21:47:25"><spring:eval expression="post.createTime"/></span>
                            </div>
                        </div>
                    </li>
                    </c:forEach>

                </ul>
            </div>

            <div class="panel-footer text-right remove-padding-horizontal pager-footer">
                <!-- Pager -->
                <!-- 如有需要可以在此处添加分页，本次作业不要求完成 -->
                    <div class="pull-right" style="padding-right:20px">
                        <ul class="pagination">
                            <li> <a href="${pageContext.request.contextPath}/list?page=1"><span>第一頁</span></a></li>
                            <li> <a href="${pageContext.request.contextPath}/list?page=${postList.pageNum-1}"><span>上一頁</span></a></li>
                            <li> <span>當前第${postList.pageNum}頁</span></li>
                            <li> <a href="${pageContext.request.contextPath}/list?page=${postList.pageNum+1}"><span>下一頁</span></a></li>
                            <li> <a href="${pageContext.request.contextPath}/list?page=${postList.pages}"><span>最後一頁</span></a></li>
                        </ul>
                    </div>
            </div>


        </div>
    </div>

    <div class="col-md-3 side-bar">
        <div class="panel panel-default corner-radius">
            <div class="panel-heading">
                <h3 class="panel-title">BBS</h3>
            </div>
            <c:if test="${sessionScope.user!=null}">
            <!-- 登录后显示的内容 -->
            <div class="panel-body text-center">
                <c:choose>
                    <c:when test="${sessionScope.user.userStatus==0}">
                        <a href="${pageContext.request.contextPath}/prePost" class="btn btn-primary">
                            <i class="fa fa-user"> </i> 发帖
                        </a>
                    </c:when>
                    <c:when test="${sessionScope.user.userStatus==1}">
                        <span style="color:red">該用戶已被鎖定，請聯絡管理員</span>
                    </c:when>
                </c:choose>

            </div>
            </c:if>
            <!-- 未登录显示的内容 -->
            <c:if test="${sessionScope.user==null}">
            <div class="panel-body text-center">
                <a href="${pageContext.request.contextPath}/preReg" class="btn btn-primary">
                    <i class="fa fa-user"> </i> 注册
                </a>
            </div>
            <div class="panel-footer text-center">
                已注册用户请 <a href="${pageContext.request.contextPath}/preLogin">登录</a>
            </div>
            </c:if>

        </div>

        <div class="panel panel-default corner-radius">
            <div class="panel-heading">
                <h3 class="panel-title">热门标签</h3>
            </div>
            <div class="panel-body">
                <div class="badge badge-tag-cloud">
                    <a href="">Java</a> &nbsp;&nbsp; <a href="">Python</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default corner-radius">
            <div class="panel-heading">
                <h3 class="panel-title">小贴士</h3>
            </div>
            <div class="panel-body">
                猪有猪的思想，人有人的思想。如果猪有人的思想，那它就不是猪了——是八戒!
            </div>
        </div>

        <div class="panel panel-default corner-radius">
            <div class="panel-heading">
                <h3 class="panel-title">统计信息</h3>
            </div>
            <ul class="list-group">
                <li class="list-group-item">社区会员: 747</li>
                <li class="list-group-item">主题数: 95</li>
                <li class="list-group-item">回帖数: 218</li>
            </ul>
        </div>


    </div>
    <div class="clearfix"></div>

</div>

<jsp:include page="bottom.jsp"/>
