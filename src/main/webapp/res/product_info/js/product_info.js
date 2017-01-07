$(function(){
	
	//图片轮播
	var mySwiper = new Swiper('.swiper-container', {
		loop: true,
		// 如果需要分页器
		pagination: '.swiper-pagination'
	});
	//点赞
	$("#dianzan").touchClick(function(event) {
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
	
});
