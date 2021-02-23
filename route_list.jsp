<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>旅游-搜索</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<div id="header"></div>
    <div class="page_one">
        <div class="contant">
            <div class="crumbs">
                <img src="images/search.png" alt="">
                <p>旅行><span>${cname}</span></p>
            </div>
            <div class="xinxi clearfix">
                <div class="left">
                    <div class="header">
                        <span>商品信息</span>
                        <span class="jg">价格</span>
                    </div>
                    <ul>
                        <c:forEach items="${vo.list}" var="commodity">
                            <li>
                                <div class="img"><img src="${path}/${commodity.rimage}" alt=""></div>
                                <div class="text1">
                                    <p>${path}/${commodity.rname}</p>
                                    <br/>
                                    <p>${path}/${commodity.routeIntroduce}</p>
                                </div>
                                <div class="price">
                                    <p class="price_num">
                                        <span>&yen;</span>
                                        <span>${path}/${commodity.price}</span>
                                        <span>起</span>
                                    </p>
                                    <p><a href="${path}/commodity?method=viewCommodityByrid&rid=${commodity.rid}">查看详情</a></p>
                                </div>
                            </li>
                        </c:forEach>


                    </ul>
                    <c:if test="${vo.list.size()==0}">

                    </c:if>
                    <c:if test="${vo.list.size()!=0}">
                        <div class="page_num_inf">
                            <i></i> 共
                            <span>${vo.myPages}</span>页<span>${vo.list.size()}</span>条
                        </div>
                        <div class="pageNum">
                            <ul>
                                <li><a href="${path}/commodity?method=viewCommodityListByCidPname&cid=${vo.query1}&pname=${vo.query2}&pageNow=1">首页</a></li>
                                <c:if test="${vo.pageNow == 1}">
                                    <li class="threeword">
                                        <a href="JavaScript:void(0)" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
                                    </li>
                                </c:if>

                                <c:if test="${vo.pageNow != 1}">
                                    <li class="threeword"><a href="${path}/commodity?method=viewCommodityListByCidPname&cid=${vo.query1}&pname=${vo.query2}&pageNow=${vo.pageNow-1}" aria-hidden="true">上一页</a></li>
                                </c:if>
                                <c:forEach begin="1" end="${vo.myPages}" var="page">

                                    <%--  若当前页码pageNow正好是page，则显示被点击的状态 --%>
                                    <c:if test="${vo.pageNow == page}">
                                        <li class="active">
                                            <a href="JavaScript:void(0)">${page}</a>
                                        </li>
                                    </c:if>

                                    <%--  若当前页码pageNow不是page，则显示可以点击的状态 --%>
                                    <c:if test="${vo.pageNow != page}">
                                        <li>
                                            <a href="${path}/commodity?method=viewCommodityListByCidPname&cid=${vo.query1}&pname=${vo.query2}&pageNow=${page}">${page}</a>
                                        </li>
                                    </c:if>

                                </c:forEach>
                                <c:if test="${vo.pageNow == vo.myPages}">
                                    <li class="disabled">
                                        <a href="JavaScript:void(0)" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
                                    </li>
                                </c:if>
                                <c:if test="${vo.pageNow != vo.myPages}">
                                    <li class="threeword">
                                        <a href="${path}/commodity?method=viewCommodityListByCidPname&cid=${vo.query1}&pname=${vo.query2}&pageNow=${vo.pageNow+1}" aria-label="Next"> <span aria-hidden="true">下一页</span></a>
                                    </li>
                                </c:if>
                                <li class="threeword"><a href="${path}/commodity?method=viewCommodityListByCidPname&cid=${vo.query1}&pname=${vo.query2}&pageNow=${vo.myPages}">末页</a></li>
                            </ul>
                        </div>
                    </c:if>
                </div>
                <div class="right">
                    <div class="top">
                        <div class="hot">HOT</div>
                        <span>热门推荐</span>
                    </div>
                    <ul>
                        <c:forEach items="${requestScope.hot}" var="commodity">
                            <li>
                                <div class="left"><img src="${path}/${commodity.rimage}" alt=""></div>
                                <div class="right">
                                    <p>${commodity.rname}</p>
                                    <p>网付价<span>&yen;<span>${commodity.price}</span>起</span>
                                    </p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!--引入头部-->
    <div id="footer"></div>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
</body>

</html>