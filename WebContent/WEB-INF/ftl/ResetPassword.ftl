<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.password.reset" /></title>
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
			<div id="register_top2_left">重置密码</div>
			<div id="register_top2_right">已经是青城折扣网的用户？请直接<a href="login.action">登录</a></div>
		</div>
		
		<div id="container">
			<@s.form action="reset">
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
							<@s.textfield cssClass="register_input" id="username" name="user.username" readonly="true" />
						</div>
						<div class="register_item_right">&nbsp;</div>
					</div>
				
					<div class="gap_row"></div>
					
					<#-- 新密码 -->
					<div class="register_item">
						<div class="register_item_left">
							&nbsp;&nbsp;&nbsp;&nbsp;<@s.label for="password" value="%{getText('system.password.new')}" />
						</div>
						<div class="register_item_middle">
							<@s.password cssClass="register_input" id="password" name="user.password" />
						</div>
						<div class="register_item_right">
							<@s.if test="'' == user.password">
								<@s.fielderror>
									<@s.param>user.password</@s.param>
								</@s.fielderror>
							</@s.if>
							<@s.elseif test="'' != user.password">
								<@s.fielderror>
									<@s.param>user.password</@s.param>
								</@s.fielderror>
							</@s.elseif>
						</div>
					</div>

					<div class="gap_row"></div>
					
					<#-- 确认密码 -->
					<div class="register_item">
						<div class="register_item_left">
							<@s.label for="repassword" value="%{getText('system.repassword')}" />
						</div>
						<div class="register_item_middle">
							<@s.password cssClass="register_input" id="repassword" name="user.repassword" />
						</div>
						<div class="register_item_right">
							<@s.if test="'' == user.repassword">
								<@s.fielderror>
									<@s.param>user.repassword</@s.param>
								</@s.fielderror>
							</@s.if>
							<@s.elseif test="'' != user.repassword">
								<@s.fielderror>
									<@s.param>user.repassword</@s.param>
								</@s.fielderror>
							</@s.elseif>
						</div>
					</div>
				
					<div class="gap_row"></div>
					
					<#-- 提交 -->
					<div class="register_item">
						<div class="register_item_left"></div>
						<div class="register_item_right1">
							<@s.submit id="reset_submit" cssClass="find_submit" value="" />
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
				<@s.hidden name="user.email" />
			</@s.form>
		</div>
		
		<#include "./site/include/Footer.ftl">
	</body>
</html>
