<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<title>婚纱摄影风格展示-厦门赫本公馆婚纱摄影 厦门婚纱摄影</title>
<meta name="keywords" content="婚纱摄影风格展示-厦门赫本公馆婚纱摄影 厦门婚纱摄影">
<meta name="description" content="婚纱摄影风格展示-厦门赫本公馆婚纱摄影 厦门婚纱摄影">
<meta name="mobile-agent" content="format=xhtml;">
<meta name="applicable-devive" content="mobile">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="telephone=no" name="format-detection">
<%@include file="inc.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/res/common/css/swiper-3.3.1.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/exc_scene/css/exc_scene.css"/>
</style>
</head>
<body>
<%@include file="index_header.jsp" %>
	<!-- 独家场景-->
    <section class="exc_scene items">
    <c:forEach items="${combos}" var="combo" varStatus="status">
        <div class="exc_scene_div ">
            <div class="exc_scene_header">
                <span>${combo.comboName}</span>
            </div>
            <a class="exc_scene_img" href="<%=request.getContextPath()%>/exclusive_scene_list?comboId=${combo.comboId}">
                <img class="corner" src="<%=request.getContextPath()%>${combo.imgPath}dujia_show.jpg" />
            </a>
            <a class="exc_scene_point">

            </a>
        </div>
    </c:forEach>
    </section>
</section>
<!--app下载 底部飘浮 -->
<div id="backTop"></div>
<%@include file="index_footer.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/common/js/swiper-3.3.1.jquery.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/index/js/index.js"></script>
</body>
</html>