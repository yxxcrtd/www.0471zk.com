// Copyright 2012
// Author: Yang XinXin


// 收起/展开 之间的切换
$(function() {
	var parentFrame = parent.document.getElementById("framesetId");
	$("#tdBar").click(function() {
		if (parentFrame.cols == "150, 8, *") {
			parentFrame.cols = "0, 8, *";
			$("#switchBar").html("<img src='/images/switch_right.gif'/>");
		} else {
			parentFrame.cols = "150, 8, *";
			$("#switchBar").html("<img src='/images/switch_left.gif'/>");
		}
	});
});

