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
			<a href="/" id="price_sort">
			价格<i class="sort_icon sort_icon_bottom"></i></a>
		</div>
	</div>
	<!--点赞次数-->
    <div class="allSeller sortNav">
		<div class="select_show">
			<a href="/" id="like_sort">
			热门<i class="sort_icon sort_icon_bottom"></i></a>
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
<script type="text/javascript">
	$(function(){
		// 点击价格的升降排序
		$("#price_sort").touchClick(function(event) {
			event.stopPropagation();
			event.preventDefault();
			var me = $(this);
			var params = {
				orderBy : "price"
			}
			var iconObj = me.find(".sort_icon");
			if(iconObj.hasClass("sort_icon_bottom")) {
				params.orderByType = "asc";
				iconObj.removeClass("sort_icon_bottom");
				iconObj.addClass("sort_icon_top");
			} else if(iconObj.hasClass("sort_icon_top")) {
				params.orderByType = "desc";
				iconObj.removeClass("sort_icon_top");
				iconObj.addClass("sort_icon_bottom");
			}
			console.log(params);
			console.log(iconObj.hasClass("sort_icon_bottom"));
			findComboData(params);
		});
		
		$("#like_sort").touchClick(function(event) {
			event.stopPropagation();
			event.preventDefault();
			var me = $(this);
			var params = {
				orderBy : "click_like_num"
			}
			var iconObj = me.find(".sort_icon");
			if(iconObj.hasClass("sort_icon_bottom")) {
				params.orderByType = "asc";
				iconObj.removeClass("sort_icon_bottom");
				iconObj.addClass("sort_icon_top");
			} else if(iconObj.hasClass("sort_icon_top")) {
				params.orderByType = "desc";
				iconObj.removeClass("sort_icon_top");
				iconObj.addClass("sort_icon_bottom");
			}
			findComboData(params);
		});
		
	});
	
	// 获取数据
	function findComboData(params) {
		$.ajax({
			type: "post",
			url: contextPath + "/product_packages2",
			data: params,
			success : function(data){
				if(data.success){
					buildPackageList(data.resultObj);
				} else {
					alert("数据异常,请重试！");
				}
			},
			error : function() {
				alert("数据异常,请重试！");
			}
		});
	}
	
	// 构建套餐列表
	function buildPackageList(combos) {
		var packageList = $("#packageList");
		if(combos && combos.length > 0) {
			var html = [];
			html.push("<ul>");
			for(var i=0; i<combos.length; i++) {
				var combo = combos[i];
				html.push("<li>");
					html.push('<a href="'+ contextPath +'/product_info?comboId='+ combo.comboId +'" class="packageListItem">');
						html.push('<dl class="clearfix">');
							html.push('<dt>');
								html.push('<img src="' + contextPath + combo.imgPath + 'taocan_show.jpg">');
							html.push('</dt>');
							html.push('<dd>');
									html.push('<div class="package_name">');
										html.push('<h3><i>' + combo.comboName + '</i></h3>');
									html.push('</div>');
									html.push('<div class="package_info">');
										html.push('<p class="row1"><span class="big">￥<i>' + combo.price + '</i></span></p>');
										html.push('<p class="row2">' + combo.comboDesc + '</p>');
									html.push('</div>');
							html.push('</dd>');
						html.push('</dl>');
					html.push('</a>');
				html.push("</li>");
			}
			html.push("</ul>");
			packageList.html(html.join(""));
		} else {
			packageList.html('<p class="no_data">暂无数据</p>');
		}
	}
	
</script>
</body>
</html>