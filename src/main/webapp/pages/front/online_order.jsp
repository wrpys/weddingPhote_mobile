<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<title>婚纱摄影 在线预约-${combo.comboName} 厦门赫本公馆婚纱摄影</title>
<meta name="keywords" content="婚纱摄影 在线预约-${combo.comboName} 厦门赫本公馆婚纱摄影">
<meta name="description" content="婚纱摄影 在线预约-${combo.comboName} 厦门赫本公馆婚纱摄影">
<meta name="mobile-agent" content="format=xhtml;">
<meta name="applicable-devive" content="mobile">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="telephone=no" name="format-detection">
<%@include file="inc.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/product_info/css/product_info.css"/>
<body>
<header>
	<div class="top_title">
        <a href="/" class="back"></a>
        <div class="title">
        	在线预定
        </div>
    </div>
</header>

<section>
	<div class="product_info">
		<div class="infos">
			<c:if test="${type == 1}">
				<div class="price">
					<dfn>¥</dfn><strong>${combo.price}</strong>/<span>¥${combo.originalPrice}</span>
				</div>
			</c:if>
			<span class="name">${combo.comboName}</span>
		</div>
	</div>
	<div class="order_from">
        <div class="tips">欢迎您的预约,我们会为您做最好准备</div>
        <form id="form" method="post" action="<%=request.getContextPath()%>/reservationsInfoCtr/reservationsInfo" onsubmit="return validateFun();">
        	<input type="hidden" name="type" id="comboId" value="${type}">
        	<input type="hidden" name="comboId" id="comboId" value="${combo.comboId}">
            <table>
                <tbody>
                    <tr>
                        <td class="td_name">您的称呼:</td>
                        <td class="td_value">
                            <input type="text" class="" name="userName" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input id="woman" type="radio" value="1" name="sex" checked="">
                            <label for="woman">女士</label>
                            <input id="man" type="radio" value="0" name="sex">
                            <label for="man">先生</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_name">联系手机:</td>
                        <td class="td_value">
                            <input type="text" class="" value="" name="mobile"> 
                        </td>
                    </tr>
                    <tr>
                        <td class="td_name">预约日期:</td>
                        <td class="td_value">
                            <input type="text" name="reservationsTime" id="reservationsTime" readonly />
                        </td>
                    </tr>
                    <input type="hidden" class="form-control" value="872" name="goods_id">
                    <tr>
                        <td colspan="2" class="td_sub">
                            <button class="btn_subimt" type="submit" onclick="">立即预约</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</section>
<!--app下载 底部飘浮 end -->
<div id="backTop"></div>
<%@include file="footer.jsp" %>
<!-- 时间控件 -->
<script src="<%=request.getContextPath()%>/res/common/date_plugins/js/mobiscroll_002.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/common/date_plugins/js/mobiscroll_004.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/res/common/date_plugins/css/mobiscroll_002.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/res/common/date_plugins/css/mobiscroll.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/res/common/date_plugins/js/mobiscroll.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/common/date_plugins/js/mobiscroll_003.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/common/date_plugins/js/mobiscroll_005.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/res/common/date_plugins/css/mobiscroll_003.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/res/product_info/js/online_order.js" ></script>
</body>
</html>