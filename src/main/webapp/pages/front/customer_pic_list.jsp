<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<title>婚纱摄影客照详情-${combo.comboName} 厦门赫本公馆婚纱摄影</title>
<meta name="keywords" content="婚纱摄影客照详情-${combo.comboName} 厦门赫本公馆婚纱摄影">
<meta name="description" content="婚纱摄影客照详情-${combo.comboName} 厦门赫本公馆婚纱摄影">
<meta name="mobile-agent" content="format=xhtml;">
<meta name="applicable-devive" content="mobile">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="telephone=no" name="format-detection">
<%@include file="inc.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/res/common/css/swiper-3.3.1.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/product_info/css/product_info.css"/>
</head>
<body>
<header>
	<div class="top_title">
        <a class="back"></a>
        <div class="title">
        	客照详情
        </div>
    </div>
</header>

<section>
	<!--图片轮播-->
	<div class="swiper-container">
	    <div class="swiper-wrapper">
	        <div class="swiper-slide">
	        	<img src="<%=request.getContextPath()%>${combo.imgPath}bg1.jpg" />
	        </div>
	        <div class="swiper-slide">
	        	<img src="<%=request.getContextPath()%>${combo.imgPath}bg2.jpg" />
	        </div>
	        <div class="swiper-slide">
	        	<img src="<%=request.getContextPath()%>${combo.imgPath}bg3.jpg" />
	        </div>
	    </div>
	    <!-- 如果需要分页器 -->
	    <div class="swiper-pagination"></div>
	</div>
	<div class="product_info">
		<div class="infos">
			<span class="name">${combo.comboName}</span>
		</div>
	</div>
	<div class="oper">
		<div id="dianzan" class="dianzan_div" comboId="${combo.comboId}">
            <span>${combo.clickLikeNum}</span>
            <i class="">赞</i>
        </div>
		<a class="btn" href="<%=request.getContextPath()%>/online_order?comboId=${combo.comboId}&type=2">在线预订</a>
	</div>
	<div class="mome">
		<h2>客照描述</h2>
		<p>
			${combo.comboDesc}
		</p>
	</div>
	<div class="mome">
		<h2>图文详情</h2>
		<div>
			<c:forEach begin="1" end="${combo.mobileImgCount}" step="1" varStatus="status">
				<figure>
					<p>
		                <img src="<%=request.getContextPath()%>${combo.imgPath}detail${status.index}.jpg" />
		            </p>
				</figure>
			</c:forEach>
		</div>
	</div>
</section>
<!--app下载 底部飘浮 -->
<div id="backTop"></div>
<%@include file="footer.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/common/js/swiper-3.3.1.jquery.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/product_info/js/product_info.js" ></script>
<script type="text/javascript">
	var result = "${result}";
	if(result == 1){
		alert("预约成功！");
	} else if(result == -1){
		alert("预约失败,请重试！");
	}
</script>
</body>
</html>