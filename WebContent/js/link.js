// Copyright 2010, Yang Xinxin


$(function() {
	$("#name").maxlength({
		maxCharacters: 15
	});
	
	$("#url").maxlength({
		maxCharacters: 50
	});
	
	// 友情连接名称
	var nameNode = $("#name");
	nameNode.bind("blur", function() {
		$(this).val($.trim($(this).val()));
	});

	// 友情连接地址
	var urlNode = $("#url");
	urlNode.bind("blur", function() {
		$(this).val($.trim($(this).val()));
	});
	
	$("form").submit(function(e) {
		var nameNodeValue = $.trim(nameNode.val());
		if ("" == nameNodeValue) {
			alert("友情连接名称不能为空！");
			nameNode.focus();
			return false;
		}
		
		var urlNodeValue = $.trim(urlNode.val());
		if ("" == urlNodeValue) {
			alert("友情连接地址不能为空！");
			urlNode.focus();
			return false;
		}
		
	    $("#link_submit").attr({disabled : "disabled", cursor : "progress"});
		$("#link_submit").val("数据提交中...").show();
	});
});
