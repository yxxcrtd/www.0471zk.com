<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.find" /></title>
		<link rel="styleSheet" type="text/css" href="./css/style.css" />
	</head>

	<body>
		<div id="register_top1">
			<div id="register_top1_left">
				&gt;&gt;&nbsp;会员注册中心
			</div>
			<div id="register_top1_right">
				<a href="/" title="青城折扣网">青城折扣网</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="login.action">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="register.action">注册</a>
			</div>
		</div>
		
		<div id="register_top2">
			<div id="register_top2_left">找回密码</div>
			<div id="register_top2_right">已经是青城折扣网的用户？请直接<a href="login.action">登录</a></div>
		</div>
		
		<div id="container">
			<@s.form action="find">
				<div id="register">
					<div id="register_tip">
						<@s.actionerror />
					</div>
				
					<#-- 用户名称 -->
					<div class="register_item">
						<div class="register_item_left">
							<@s.label for="username" value="%{getText('system.username')}" />
						</div>
						<div class="register_item_middle">
							<@s.textfield cssClass="register_input" id="username" name="user.username" />
						</div>
						<div class="register_item_right">
							<@s.if test="'' == user.username">
								<@s.fielderror>
									<@s.param>user.username</@s.param>
								</@s.fielderror>
							</@s.if>
							<@s.elseif test="'' != user.username">
								<@s.fielderror>
									<@s.param>user.username</@s.param>
								</@s.fielderror>
							</@s.elseif>
						</div>
					</div>
				
					<div class="gap_row"></div>
					
					<#-- 电子邮箱 -->
					<div class="register_item">
						<div class="register_item_left">
							<@s.label for="email" value="%{getText('system.email')}" />
						</div>
						<div class="register_item_middle">
							<@s.textfield cssClass="register_input" id="email" name="user.email" />
						</div>
						<div class="register_item_right">
							<@s.if test="'' == user.email">
								<@s.fielderror>
									<@s.param>user.email</@s.param>
								</@s.fielderror>
							</@s.if>
							<@s.elseif test="'' != user.email">
								<@s.fielderror>
									<@s.param>user.email</@s.param>
								</@s.fielderror>
							</@s.elseif>
						</div>
					</div>

					<div class="gap_row"></div>
					
					<#-- 验证码 -->
					<div class="register_item">
						<div class="register_item_left">
							&nbsp;&nbsp;&nbsp;&nbsp;<@s.label for="verifyCode" value="%{getText('system.verifyCode')}" />
						</div>
						<div class="register_item_middle1">
							<@s.textfield cssClass="register_input1" id="verifyCode" name="user.verifyCode" maxlength="4" />
						</div>
						<div class="register_item_middle2">
							<a href="#">
								<img id="verifyImage" src="verifyCode" title="<@s.text name="system.verifyCode.refresh" />" />
							</a>
						</div>
						<div class="register_item_right">
							<@s.if test="'' == user.verifyCode">
								<@s.fielderror>
									<@s.param>user.verifyCode</@s.param>
								</@s.fielderror>
							</@s.if>
							<@s.else>
								看不清？<a id="verifyCodeNew" href="#">换一个</a>
							</@s.else>
						</div>
					</div>
				
					<div class="gap_row"></div>
					
					<#-- 提交 -->
					<div class="register_item">
						<div class="register_item_left"></div>
						<div class="register_item_right1">
							<@s.submit cssClass="find_submit" value="" />
						</div>
					</div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
					<div class="gap_row"></div>
				</div>
			</@s.form>
		</div>
		
		<#include "./site/include/Footer.ftl">
		
        <script language="javaScript" src="./js/jquery.js"></script>
        <script language="javaScript" src="./js/find.js"></script>
	</body>
</html>
