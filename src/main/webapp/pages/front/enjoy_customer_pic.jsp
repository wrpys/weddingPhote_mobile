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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/enjoy_pic/css/enjoy_pic.css"/>
<style type="text/css">
	.kezhao_img a{
		display: block;
    	height: 215px;
	}
	.kezhao_img a img{
		width:100%;
    	height: 215px;
	}
</style>
</style>
</head>
<body>
<%@include file="index_header.jsp" %>
    <section class="kezhao items">
        <h1 class="tit" style="height: 20px;"> </h1>
        <ul class="clearfix">
            <c:forEach items="${combos}" var="combo" varStatus="status">
	            <c:if test="${status.index%2 ==0}">
	            <li class="kezhao_img">
	                <a href="<%=request.getContextPath()%>/customer_pic_list?comboId=${combo.comboId}">
	                    <img src="<%=request.getContextPath()%>${combo.imgPath}kezhao_show.jpg">
	                </a>
	            </li>
	            <li class="kezhao_info">
                    <div class="kezhao_info_div">
                        <div class="kezhao_pro_div">
                            <figcaption class="left_figcaption">${combo.userNames}</figcaption>
                            <blockquote>${combo.comboDesc}</blockquote>
                            <div class="dianzan_div" comboId="${combo.comboId}">
                                <span>${combo.clickLikeNum}</span>
                                <i class="">赞</i>
                            </div>
                        </div>
                    </div>
	            </li>
	            </c:if>
	            <c:if test="${status.index%2 ==1}">
	            <li>
                    <div class="kezhao_info_div">
                        <div class="kezhao_pro_div">
                            <figcaption class="right_figcaption">${combo.userNames}</figcaption>
                            <blockquote>${combo.comboDesc}</blockquote>
                            <div class="dianzan_div" comboId="${combo.comboId}">
                                <span>${combo.clickLikeNum}</span>
                                <i class="">赞</i>
                            </div>
                        </div>
                    </div>
	            </li>
	            <li>
	                <a href="<%=request.getContextPath()%>/customer_pic_list?comboId=${combo.comboId}">
	                    <img src="<%=request.getContextPath()%>${combo.imgPath}kezhao_show.jpg">
	                </a>
	            </li>
	            </c:if>
            </c:forEach>
        </ul>
    </section>
</section>
<!--app下载 底部飘浮 -->
<div id="backTop"></div>
<%@include file="index_footer.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/common/js/swiper-3.3.1.jquery.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/index/js/index.js"></script>
<script type="text/javascript">
//点赞
$(".dianzan_div").touchClick(function(event) {
	event.stopPropagation();
	event.preventDefault();
	var me = $(this);
	var comboId = me.attr("comboId");
	$.ajax({
		url : contextPath + "/comboCtr/clickLike",
		async : false,
		type : 'POST',
		dataType : "json",
		data : {
			comboId : comboId
		},
		success : function(data) {
			if (data){
				var spanObj = me.find("span");
				var num = parseInt(spanObj.html());
				spanObj.html(++num);
			}
		}
	});
	return false;
});
</script>
</body>
</html>