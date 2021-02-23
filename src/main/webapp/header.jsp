<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 头部 start -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <header id="header">
        <div class="top_banner">
            <img src="images/top_banner.jpg" alt="">
        </div>
        <div class="shortcut">
            <!-- 未登录状态  -->
            <div class="login_out">
                <c:if test="${sessionScope.user==null}">
                    <a href="login.jsp">登录</a>
                    <a href="register.jsp">注册</a>
                </c:if>

            </div>
            <!-- 登录状态  -->
            <div class="login">
            	<c:if test="${sessionScope.user!=null}">
                    <span>欢迎回来，${sessionScope.user.username}</span>
                    <a href="myfavorite.jsp" class="collection">我的收藏</a>
                    <a href="${path}/user?method=logout">退出</a>
                </c:if>

            </div>
        </div>
        <div class="header_wrap">
            <div class="topbar">
                <div class="logo">
                    <a href="/"><img src="images/logo.jpg" alt=""></a>
                </div>
                <%--<c:if test="${vo!=null}">--%>
                    <div class="search">
                        <input name="" type="text" placeholder="请输入路线名称" class="search_input" autocomplete="off" placeholder="Search" id="searchName" name="pname" value="${vo.query2}">
                        <a href="javascript:;" class="search-button" onclick="query()">搜索</a>
                        <script>
                            function query() {
                                window.location.href="${path}/commodity?method=viewCommodityListByCidPname&cid=${vo.query1}&pname="+$("#searchName").val();
                            }
                        </script>
                    </div>
                <%--</c:if>--%>
h
                <div class="hottel">
                    <div class="hot_pic">
                        <img src="images/hot_tel.jpg" alt="">
                    </div>
                    <div class="hot_tel">
                        <p class="hot_time">客服热线(9:00-6:00)</p>
                        <p class="hot_num">400-618-9090</p>
                    </div>
                </div>
            </div>
        </div>
    </header>
<c:set value="${pageContext.request.contextPath}" scope="application" var="path"></c:set>
    <!-- 头部 end -->
     <!-- 首页导航 -->


    <div class="navitem">
        <ul class="nav" id="categorys">
            <li class="nav-active"><a href="${path}/commodity?method=index">首页</a></li>
        </ul>
    </div>

<script>
    var data = "";
    $.ajax({
        type:"get",
        url:"${path}/category?method=viewAllCategory",
        dataType:"json",
        success:function (categoryList) {
            for (var x in categoryList) {
                data += "<li><a href='${path}/commodity?method=viewCommodityListByCidPname&cid="+categoryList[x].cid+"'>"+categoryList[x].cname+"</a></li>";
            }
            $("#categorys").html(data);
        }
    })
</script>
    