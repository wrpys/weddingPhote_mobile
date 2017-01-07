<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<title>婚纱摄影推荐套餐-厦门赫本公馆婚纱摄影 厦门婚纱摄影</title>
<meta name="keywords" content="厦门赫本公馆婚纱摄影-厦门婚纱摄影 官方网站">
<meta name="description" content="厦门赫本公馆婚纱摄影-厦门婚纱摄影 官方网站">
<meta name="mobile-agent" content="format=xhtml;">
<meta name="applicable-devive" content="mobile">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="telephone=no" name="format-detection">
<%@include file="inc.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/product_packages/css/product_packages.css"/>
</head>
<body>
<header>
	<div class="top_title">
        <a href="/" class="back"></a>
        <div class="title">
        	推荐套餐
        </div>
    </div>
</header>
<section class="sort">
	<!--价格-->
    <div class="allSeller sortNav">
		<div class="select_show">
			<a href="<%=request.getContextPath()%>/product_packages?orderBy=price&orderByType=${priceOrdeBy}">
			价格<i class="sort_icon <c:if test="${priceOrdeBy == 'asc'}">sort_icon_bottom</c:if><c:if test="${priceOrdeBy == 'desc'}">sort_icon_top</c:if>"></i></a>
		</div>
	</div>
	<!--点赞次数-->
    <div class="allSeller sortNav">
		<div class="select_show">
			<a href="<%=request.getContextPath()%>/product_packages?orderBy=click_like_num&orderByType=${clickLikeNumOrdeBy}">
			热门<i class="sort_icon <c:if test="${clickLikeNumOrdeBy == 'asc'}">sort_icon_bottom</c:if><c:if test="${clickLikeNumOrdeBy == 'desc'}">sort_icon_top</c:if>"></i></a>
		</div>
	</div>
</section>
<section id="packageList">
	<ul>
		<c:forEach items="${combos}" var="combo" varStatus="status">
			<li>
				<a href="<%=request.getContextPath()%>/product_info?comboId=${combo.comboId}" class="packageListItem">
					<dl class="clearfix">
						<dt>
							<img src="<%=request.getContextPath()%>${combo.imgPath}taocan_show.jpg">
						</dt>
						<dd>
							<div class="package_name">
								<h3><i>${combo.comboName}</i></h3>
							</div>
							<div class="package_info">
								<p class="row1"><span class="big">￥<i>${combo.price}</i></span></p>
								<p class="row2">${combo.comboDesc}</p>
							</div>
						</dd>
					</dl>
				</a>
			</li>
		</c:forEach>
	</ul>
</section>
<!--app下载 底部飘浮 -->
<div id="backTop"></div>
<%@include file="footer.jsp" %>
</body>
</html>