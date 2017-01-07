<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<title>厦门赫本公馆婚纱摄影-厦门婚纱摄影 官方网站</title>
<meta name="keywords" content="厦门赫本公馆婚纱摄影-厦门婚纱摄影 官方网站">
<meta name="description" content="厦门赫本公馆婚纱摄影-厦门婚纱摄影 官方网站">
<meta name="mobile-agent" content="format=xhtml;">
<meta name="applicable-devive" content="mobile">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="telephone=no" name="format-detection">
<%@include file="inc.jsp" %>
<script type="text/javascript">
	mobile_device_detect(hostRoot);
</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/res/common/css/swiper-3.3.1.min.css" />
</head>
<body>
<%@include file="index_header.jsp" %>

	<!--推荐套餐-->
	<section class="taocan items">
		<h1 class="tit">推荐-热门套餐<a href="<%=request.getContextPath()%>/product_packages">查看所有 </a></h1>
		<ul class="clearfix">
			<c:forEach items="${taocanCombos}" var="taocanCombo" varStatus="status">
				<li>
					<a href="<%=request.getContextPath()%>/product_info?comboId=${taocanCombo.comboId}">
						<div class="img">
							<img src="<%=request.getContextPath()%>${taocanCombo.imgPath}taocan_show.jpg" style="display: block;">
						</div>
						<div class="infos">
							<span>${taocanCombo.comboName}</span>
							<span>¥${taocanCombo.price}</span>
						</div>
					</a>
				</li>
			</c:forEach>
		</ul>
	</section>
	<!-- 客照欣赏 -->
	<section class="kezhao items">
		<h1 class="tit">风格展示</h1>
		<ul class="clearfix">
			<c:forEach items="${kezhaoCombos}" var="kezhaoCombo" varStatus="status">
				<li>
					<a href="<%=request.getContextPath()%>/customer_pic_list?comboId=${kezhaoCombo.comboId}">
						<img src="<%=request.getContextPath()%>${kezhaoCombo.imgPath}kezhao_show.jpg">
						<figcaption>${kezhaoCombo.userNames}</figcaption>
					</a>
				</li>
			</c:forEach>
		</ul>
		<div class="more">
			<a href="<%=request.getContextPath()%>/enjoy_customer_pic">查看更多</a>
		</div>
	</section>
		
	<!-- 客照欣赏 -->
	<section class="dujia items" show="true">
		<h1 class="tit">每日客片更新</h1>
		<ul class="clearfix">
			<c:forEach items="${dujiaCombos}" var="dujiaCombo" varStatus="status">
				<li>
					<a href="<%=request.getContextPath()%>/exclusive_scene_list?comboId=${dujiaCombo.comboId}">
						<img src="<%=request.getContextPath()%>${dujiaCombo.imgPath}dujia_show.jpg">
						<figcaption>${dujiaCombo.comboName}</figcaption>
					</a>
				</li>
			</c:forEach>
		</ul>
		<div class="more">
			<a href="<%=request.getContextPath()%>/exclusive_scene">查看更多</a>
		</div>
	</section>
</section>
<!--app下载 底部飘浮 -->
<div id="backTop"></div>
<%@include file="index_footer.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/common/js/swiper-3.3.1.jquery.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/index/js/index.js"></script>
</body>
</html>