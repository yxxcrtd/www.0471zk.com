// Copyright 2012
// Author: Yang XinXin


// 页面加载时的显示
$(function() {
	// 当前密码
	var currentPasswordNode = $("#currentPassword");
	// 当前密码的提示信息
	var currentTipNode = $("#currentTip");
	// 新密码
	var newPasswordNode = $("#newPassword");
	// 重复密码
	var rePasswordNode = $("#rePassword");
	// 重复密码的提示信息
	var reTipNode = $("#reTip");
	
	// 当表单加载的时候让当前密码输入框获得焦点
	currentPasswordNode.focus();
	
	currentPasswordNode.bind("blur", function() {
		var currentPasswordValue = currentPasswordNode.val();
		if (0 == currentPasswordValue.length) {
			currentPasswordNode.focus();
			return;
		} else {
			$.ajax({
				type : "GET",
				url : "user.action",
				cache : false,
				data : {
					'cmd' : 'valid',
					'user.password' : currentPasswordValue
				},
				// 必须指定返回的数据类型，否则默认返回的是： [object XMLDocument]
				dataType : "text",
				success : function(response) {
					// alert("服务器返回：" + response);
					if ("success" == response) {
						$("#ok").css({"background-image" : "url('../images/ok.gif')", "width" : "17px", "height" : "13px"});
					} else {
						// alert("当前密码不正确！");
						$("#ok").css({"background-image" : "url('../images/del.gif')", "width" : "9px", "height" : "9px"});
						currentPasswordNode.val("");
						currentPasswordNode.focus();
						return;
					}
				}
			});
		}
	});
	
	// 表单提交
	$("form").submit(function(e) {
		var currentPasswordValue = currentPasswordNode.val();
		var newPasswordValue = newPasswordNode.val();
		var rePasswordValue = rePasswordNode.val();
		
		// 当前密码不能为空
		if ("" == currentPasswordValue) {
			alert("当前密码不能为空！");
			currentPasswordNode.focus();
			return false;
		}
		
		// 新密码不能为空
		if ("" == newPasswordValue) {
			alert("新密码不能为空！");
			newPasswordNode.focus();
			return false;
		}
		
		// 新密码的长度不能小于5
		if (newPasswordValue.length < 5) {
			alert("为了安全起见，新密码的长度不能小于5位数！");
			newPasswordNode.focus();
			return false;
		}
		
		// 重复密码不能为空
		if ("" == rePasswordValue) {
			alert("重复密码不能为空！");
			rePasswordNode.focus();
			return false;
		}
		
		// 新密码和重复密码必须相同
		if (newPasswordValue != rePasswordValue) {
			alert("两次输入的密码不匹配！");
			newPasswordNode.focus();
			return false;
		}
		
	    $("#user_submit").attr({disabled : "disabled", cursor : "progress"});
		$("#user_submit").val("数据提交中...").show();
	});
});

