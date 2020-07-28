<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="top.jsp"/>

<div id="main" class="main-container container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-default">
                    <div class="panel-heading">注册 <span style="color:red">${msg}</span></div>
                    <div class="panel-body">
                        <form:form role="form" method="POST" action="${pageContext.request.contextPath}/reg" modelAttribute="user">

                            <div class="form-group">
                                <form:input  cssClass="form-control" path="username" required="required" placeholder="用户名"/>
                            </div>
                            <div class="form-group">
                                <form:input  cssClass="form-control" path="email" required="required" placeholder="邮箱地址"/>
                            </div>
                            <div class="form-group">
                                <form:password  cssClass="form-control" path="password" required="required" placeholder="密码"/>
                            </div>
                            <div class="form-group">
                                <input type="password" cssClass="form-control" name="passwordConfirm" required="required" placeholder="确认密码"/>
                            </div>

                            <button type="submit" class="btn btn-primary">
                                注册
                            </button>
                            <a href="${pageContext.request.contextPath}/list" class="btn btn-default">取消</a>
                    </div>
                    </form:form>
                </div>
                <div class="panel-footer">
                    已注册或使用社交账号登录，请点击 <a href="${pageContext.request.contextPath}/preLogin">这里</a> 进行登录。
                </div>
            </div>
        </div>
    </div>
</div>



<jsp:include page="bottom.jsp"/>