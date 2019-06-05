// Copyright 2012
// Author: Yang XinXin

$(function() {
	$("div.holder").jPages({
		containerID : "itemContainer",
		first : "首页",
		last : "尾页",
		pause : 10000
	});
	
	// 打印
	$("#print").printPage();
});