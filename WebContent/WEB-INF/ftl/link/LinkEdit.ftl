<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.menu.link.list" /></title>
		<link rel="styleSheet" type="text/css" href="./css/manage.css" />
        <script language="javaScript" src="./js/jquery.js"></script>
        <script language="javascript" src="./js/jquery.maxlength.js"></script>
        <script language="javaScript" src="./js/link.js"></script>
	</head>
	
	<body>
  		<@s.form action="link">
			<div id="form">
				<div id="form_title">
					<#if link.linkId == 0>
						<@s.text name="system.menu.link.add" />
					<#else>
						<@s.text name="system.menu.link.update" />
					</#if>
				</div>
									
				<div class="form_item">
					<@s.label for="name" value="%{getText('system.menu.link.name')} %{getText('system.required')}" />
					<@s.textfield id="name" cssClass="input" name="link.name" maxlength="15" cssStyle="width: 300px;" />
					<span class="charsLeft"></span>
					<span id="nameTip"></span>
				</div>
									
				<div class="form_item">
					<@s.label for="url" value="%{getText('system.menu.link.url')} %{getText('system.required')} %{getText('system.menu.link.url.example')}" />
					<@s.textfield id="url" cssClass="input" name="link.url" maxlength="50" cssStyle="width: 500px; ime-mode: disabled;" />
					<span class="charsLeft"></span>
					<span id="urlTip"></span>
				</div>
				
				<div id="form_opt">
					<input class="btn" type="submit" id="link_submit" name="submit1" value="<#if link.linkId == 0><@s.text name="system.button.add" /><#else><@s.text name="system.button.update" /></#if>" />&nbsp;&nbsp;
					<input class="btn" type="button" onClick="javascript:history.back();" value="<@s.text name="system.button.back" />" />
				</div>
			</div>
			<@s.hidden name="cmd" value="save" />
			<@s.hidden name="link.linkId" value="${link.linkId!}" />
		</@s.form>
	</body>
</html>
