// Copyright 2012
// Author: Yang XinXin

$(function() {
	// 使用户名的输入框 获得焦点
	$("#username").focus();
	
	// 刷新验证码
	$("#verifyCodeNew, #verifyImage").click(function() {
		// TODO	为什么用jQuery的方式获取不到值？
		// $("#verifyImage").src = "verifyCode?" + new Date();
		document.getElementById("verifyImage").src = "verifyCode?" + new Date();
	});
	
	// 表单提交
	$("form").submit(function(e) {
		// 
	});
	
});