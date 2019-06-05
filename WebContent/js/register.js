// Copyright 2012
// Author: Yang XinXin

$(function() {
	// 使用户名的输入框 获得焦点
	$("#username").focus();
	
	// 加载的时候打勾
//	$("#checkbox_protocol").attr("checked", true);
	$("input[name='protocol']").attr("checked", true);
	
	// 刷新验证码
	$("#verifyCodeNew, #verifyImage").click(function() {
		// TODO	为什么用jQuery的方式获取不到值？
		// $("#verifyImage").src = "verifyCode?" + new Date();
		document.getElementById("verifyImage").src = "verifyCode?" + new Date();
	});
	
	// 表单提交
	$("form").submit(function(e) {
//		if ($("#checkbox_protocol").attr("checked") == undefined) {
//			alert("没有选择！");
//		} else {
//			alert("选中了！");
//		}
		
		var protocolValue = $("input[name='protocol']:checked").val();
		if ("" == protocolValue || "undefined" == typeof(protocolValue)) {
			alert("必须同意《青城折扣使用协议》的用户才可以注册！");
			return false;
		}
	});
	
});