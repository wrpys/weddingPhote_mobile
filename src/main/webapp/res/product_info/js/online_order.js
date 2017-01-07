$(function () {
	var currYear = (new Date()).getFullYear();	
	var opt={};
	opt.date = {preset : 'date'};
	opt.default = {
		theme: 'android-ics light', //皮肤样式
        display: 'modal', //显示方式 
        mode: 'scroller', //日期选择模式
		dateFormat: 'yyyy-mm-dd',
		lang: 'zh',
		showNow: true,
		nowText: "今天",
        startYear: currYear, //开始年份
        endYear: currYear + 5 //结束年份
	};
  	$("#reservationsTime").mobiscroll($.extend(opt['date'], opt['default']));
});

function validateFun(){
	var userName = $("#form input[name='userName']").val();
	var mobile = $("#form input[name='mobile']").val();
	var reservationsTime = $("#form input[name='reservationsTime']").val();
	if(userName == null || userName == '') {
		alert("请输入姓名！");
		return false;
	}
	if(mobile == null || mobile == '') {
		alert("请输入手机号码！");
		return false;
	} else {
		if(!/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/i.test(mobile)) {
			alert('手机号码格式不正确！');
			return false;
		}
	}
	if(reservationsTime == null || reservationsTime == '') {
		alert("请选择日期！");
		return false;
	}
}