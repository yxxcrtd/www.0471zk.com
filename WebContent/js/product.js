// Copyright 2012
// Author: Yang XinXin

$(function() {
	// 顶部5个上下滚动
	$("#featured > ul").tabs({
		fx : {
			opacity : "toggle"
		}
	}).tabs("rotate", 5000, true);
});