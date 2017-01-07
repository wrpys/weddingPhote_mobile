<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<title>婚纱摄影 在线预约 厦门赫本公馆婚纱摄影</title>
<meta name="keywords" content="婚纱摄影 在线预约 厦门赫本公馆婚纱摄影">
<meta name="description" content="婚纱摄影 在线预约 厦门赫本公馆婚纱摄影">
<meta name="mobile-agent" content="format=xhtml;">
<meta name="applicable-devive" content="mobile">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="telephone=no" name="format-detection">
<%@include file="inc.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/product_info/css/product_info.css"/>
</head>
<body>
<header>
	<div class="top_title">
        <a href="/" class="back"></a>
        <div class="title">
        	预定咨询
        </div>
    </div>
</header>

<section>
	<div class="order_from">
        <div class="tips">欢迎您的预约,我们会为您做最好准备</div>
        <form id="form" method="post" action="<%=request.getContextPath()%>/reservationsInfoCtr/reservationsInfo" onsubmit="return validateFun();">
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
                    <tr>
	                    <td class="td_name"><i class="icon-r-4"></i> 要求描述:</td>
	                    <td class="td_value">
	                        <input type="text" class="datepicker" name="desc" />
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