<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.menu.manage.updpwd" /></title>
		<link rel="styleSheet" type="text/css" href="./css/manage.css" />
        <script language="javaScript" src="./js/jquery.js"></script>
        <script language="javaScript" src="./js/user.js"></script>
	</head>
	
	<body>
  		<@s.form action="user">
			<div id="form">
				<div id="form_title">
					<@s.text name="system.menu.manage.updpwd" />
				</div>
				
				<div class="form_item">
					<@s.label value="%{getText('system.username')}" />
					<@s.textfield cssClass="input" value="${username!}" cssStyle="width: 300px;" readonly="true" />
				</div>
				
				<div class="form_item">
					<@s.label for="currentPassword" value="%{getText('system.password.current')} %{getText('system.required')}" />
					<@s.password id="currentPassword" cssClass="input" cssStyle="width: 300px;" />
					<img id="ok" src="../images/bg_blank.gif" />
				</div>
				
				<div class="form_item">
					<@s.label for="newPassword" value="%{getText('system.password.new')} %{getText('system.required')}" />
					<@s.password id="newPassword" cssClass="input" name="user.password" cssStyle="width: 300px;" />
				</div>
				
				<div class="form_item">
					<@s.label for="rePassword" value="%{getText('system.repassword')} %{getText('system.required')}" />
					<@s.password id="rePassword" cssClass="input" cssStyle="width: 300px;" />
				</div>
				
				<div id="form_opt">
					<input class="btn" type="submit" id="user_submit" name="submit1" value="<@s.text name="system.button.update" />" />&nbsp;&nbsp;
					<input class="btn" type="button" onClick="javascript:history.back();" value="<@s.text name="system.button.back" />" />
				</div>
			</div>
			<@s.hidden name="cmd" value="update" />
		</@s.form>
	</body>
</html>
