<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/xml; charset=UTF-8" />
		<title><#if tuan.tuanId == 0><@s.text name="system.tuan.pub" /><#else><@s.text name="system.tuan.update" /></#if></title>
		<link rel="styleSheet" type="text/css" href="./css/manage.css" />
		<script language="javascript" src="./js/jquery.js"></script>
        <script language="javascript" src="./js/jquery.maxlength.js"></script>
		<script language="javascript" src="./js/tuan.js"></script>
	</head>
	
	<body>
		<@s.form action="tuan" method="post" enctype="multipart/form-data">
			<div id="form">
				<div id="form_title">
					<#if tuan.tuanId == 0>
						<@s.text name="system.tuan.pub" />
					<#else>
						<@s.text name="system.tuan.update" />
					</#if>
				</div>
				
				<#-- 团购图片 -->
				<div class="form_item">
					<@s.label for="file" value="%{getText('system.tuan.picture')} %{getText('system.required.picture')}" />
					<#if tuan.tuanId == 0>
						<@s.file id="picture" name="file" size="60" cssStyle="width: 495px;" onchange="javascript:priview(this, 80, 60, 0);" />
						<img id="img" src="./images/bg_blank.gif" />
					<#else>
						<img src="./upload/${tuan.picture!}" width="100" height="75" />
						<@s.hidden name="tuan.picture" value="${tuan.picture!}" />
					</#if>
				</div>

				<#-- 团购名称 -->
				<div class="form_item">
					<@s.label for="name" value="%{getText('system.tuan.name')} %{getText('system.required')}" />
					<@s.textfield id="name" cssClass="input" name="tuan.name" maxlength="50" cssStyle="width: 490px;" />
					<span class="charsLeft"></span>
					<span id="nameTip"></span>
				</div>

				<#-- 团购原价 -->
				<div class="form_item">
					<@s.label for="price" value="%{getText('system.tuan.price')} %{getText('system.required')}" />
					<@s.textfield id="price" cssClass="input" name="tuan.price" maxlength="50" cssStyle="ime-mode: disabled;" />
					<span id="priceTip"></span>
				</div>

				<#-- 团购现价 -->
				<div class="form_item">
					<@s.label for="offPrice" value="%{getText('system.tuan.offPrice')} %{getText('system.required')}" />
					<@s.textfield id="offPrice" cssClass="input" name="tuan.offPrice" maxlength="50" cssStyle="ime-mode: disabled;" />
					<span id="offPriceTip"></span>
				</div>

				<#-- 团购连接 -->
				<div class="form_item">
					<@s.label for="url" value="%{getText('system.tuan.url')} %{getText('system.required')}" />
					<@s.textfield id="url" cssClass="input" name="tuan.url" maxlength="50" cssStyle="width: 490px;" />
					<span class="charsLeft"></span>
					<span id="urlTip"></span>
				</div>
				
				<#-- 表单提交 -->
				<div id="form_opt">
					<input class="btn" type="submit" id="tuan_submit" name="submit1" value="<#if (0 == tuan.tuanId)><@s.text name="system.button.add" /><#else><@s.text name="system.button.update" /></#if>" />&nbsp;&nbsp;
					<input class="btn" type="button" onClick="javascript:history.back();" value="<@s.text name="system.button.back" />" />
				</div>
			</div>
			<@s.hidden name="cmd" value="save" />
			<@s.hidden name="tuan.tuanId" value="${tuan.tuanId!}" />
			<@s.hidden name="tuan.discount" value="${tuan.discount!}" />
		</@s.form>
	</body>
</html>
