<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<header>
	<a href="#" class="logo">
		<img src="<%=request.getContextPath()%>/res/index/images/logo.png" />
	</a>
 	厦门赫本公馆婚纱摄影  
	<!--<div class="yuding">
		<a href="#">预定</a>
	</div>-->
</header>
<section>
	<!--导航栏-->
	<ul class="allNav clearfix">
        <li class="${index}">
        	<a href="<%=request.getContextPath()%>/index">首页</a>
        </li>
        <li class="${product_packages}">
        	<a href="<%=request.getContextPath()%>/product_packages">推荐套餐</a>
        </li>
        <li class="${enjoy_customer_pic}">
        	<a href="<%=request.getContextPath()%>/enjoy_customer_pic">客照欣赏</a>
        </li>
        <li class="${exclusive_scene}">
        	<a href="<%=request.getContextPath()%>/exclusive_scene">风格展示</a>
        </li>
    </ul>
	<!--图片轮播-->
	<div class="swiper-container">
	    <div class="swiper-wrapper">
	        <div class="swiper-slide">
	        	<img src="<%=request.getContextPath()%>/res/images/index/bg1.jpg" />
	        </div>
	        <div class="swiper-slide">
	        	<img src="<%=request.getContextPath()%>/res/images/index/bg2.jpg" />
	        </div>
	        <div class="swiper-slide">
	        	<img src="<%=request.getContextPath()%>/res/images/index/bg3.jpg" />
	        </div>
	    </div>
	    <!-- 如果需要分页器 -->
	    <div class="swiper-pagination"></div>
	</div>