<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.update" /><@s.text name="system.user" /></title>
		<link rel="styleSheet" type="text/css" href="./css/public.css" />
        <link rel="styleSheet" type="text/css" href="./css/style.css" />
	</head>
	
	<body>
		<@s.form action="user">
			<table class="table" cellSpacing="1">
				<thead>
					<tr>
						<td colspan="2">
							<div id="theader">
								<@s.text name="system.menu.manage.update.profile" />
							</div>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr height="35">
						<td class="right" width="35%">
							<strong>
								<@s.label value="%{getText('system.userId')}" />
							</strong>
						</td>
						<td class="left">
							<strong>
								${user.userId}
							</strong>
						</td>
					</tr>
					<tr height="35">
						<td class="right">
							<strong>
								<@s.label value="%{getText('system.username')}" />
							</strong>
						</td>
						<td class="left">
							<strong>
								${user.username}
							</strong>
						</td>
					</tr>
					<tr height="35">
						<td class="right">
							<strong>
								<@s.label value="%{getText('system.user.status')}" />
							</strong>
						</td>
						<td class="left">
							<#if ("admin" == user.username) || (username == user.username)>
								<strong>
									<#if (1 == user.role)>系统管理员
										<#elseif (0 == user.role)><font color="#0000FF">会员</font>
										<#elseif (2 == user.role)><font color="#00FF00">商户</font>
										<#elseif (9 == user.role)><font color="#FF00FF">已删除</font>
										<#else><font color="#FF0000">有异常</font>
									</#if>
								</strong>
							<#else>
								<@s.radio name="user.role" list=r"#{'0':'会员', '1':'系统管理员', '2':'商户', '9':'已删除'}" />
							</#if>
						</td>
					</tr>
					<tr height="35">
						<td class="right">
							<strong>
								<@s.label for="email" value="%{getText('system.email')}" />
							</strong>
						</td>
						<td class="left">
							<#if ("admin" == user.username)>
								<strong>
									${user.email}
								</strong>
							<#else>
								<@s.textfield id="email" name="user.email" />
							</#if>
						</td>
					</tr>
					<#if ("admin" != user.username)>
						<tr height="50">
							<td class="center" colspan="2">
								<input class="btn" type="submit" id="user_submit" name="submit1" value="<@s.text name="system.button.update" />" />
								<input class="btn" type="button" onClick="javascript:history.back();" value="<@s.text name="system.button.back" />" />
							</td>
						</tr>
					</#if>
				</tbody>
			</table>
			<@s.hidden name="cmd" value="save" />
			<@s.hidden name="user.userId" />
		</@s.form>
		<script language="javascript" src="./js/My97DatePicker/WdatePicker.js"></script>
        <script language="javaScript" src="./js/jquery.js"></script>
        <script language="javaScript" src="./js/public.js"></script>
	</body>
</html>
