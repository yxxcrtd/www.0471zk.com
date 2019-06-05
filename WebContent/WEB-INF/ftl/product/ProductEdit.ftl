<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<#assign sd=JspTaglibs["/WEB-INF/struts-dojo-tags.tld"]>
<html>
	<head>
    	<@sd.head parseContent="true" />
		<meta http-equiv="Content-Type" content="text/xml; charset=UTF-8" />
		<title><#if product.productId == 0><@s.text name="system.product.pub" /><#else><@s.text name="system.product.update" /></#if></title>
		<link rel="styleSheet" type="text/css" href="./css/manage.css" />
		<script language="javascript" src="./js/jquery.js"></script>
        <script language="javascript" src="./js/jquery.maxlength.js"></script>
		<script language="javascript" src="./js/manage.js"></script>
	</head>
	
	<body>
		<@s.form action="product" method="post" enctype="multipart/form-data">
			<div id="form">
				<div id="form_title">
					<#if product.productId == 0>
						<@s.text name="system.product.pub" />
					<#else>
						<@s.text name="system.product.update" />
					</#if>
				</div>
				
				<#-- 商品分类 -->
				<div class="form_item">
					<@s.label for="" value="%{getText('system.product.category')}" />
					<select name="product.category" >
						<#if categoryTree??>
							<#list categoryTree.all as c>
								<option value="${c.categoryId}" ${(c.categoryId == (product.category!0))?string("selected", "")}>${c.treeFlag2} ${c.name!?html}</option>
							</#list>
						</#if>
					</select>
				</div>
				
				<#-- 商品状态 -->
				<div id="form_item1">
					商品状态：<@s.radio name="product.status" value="%{product.status}" list=r"#{'0':'普通商品', '1':'推荐', '2':'公告', '3':'团购', '4':'精品滚动', '5':'体验卡'}" required="false" theme="simple" />
				</div>
				
				<#-- 商品图片 -->
				<div class="form_item">
					<@s.label for="file" value="%{getText('system.product.picture')} %{getText('system.required.picture')}" />
					<#if product.productId == 0>
						<@s.file id="picture" name="file" size="60" cssStyle="width: 495px;" onchange="javascript:priview(this, 80, 60, 0);" />
						<img id="img" src="./images/bg_blank.gif" />
					<#else>
						<img src="upload/case_${product.picture!}" />
						<@s.hidden name="product.picture" value="${product.picture!}" />
					</#if>
				</div>
				
				<#-- 商品优惠券 -->
				<div class="form_item">
					<@s.label for="print" value="%{getText('system.product.print')} %{getText('system.required.picture')}" />
					<#if product.productId == 0>
						<@s.file id="print" name="file" size="60" cssStyle="width: 495px;" onchange="javascript:priview(this, 80, 60, 1);" />
						<img id="voucher" src="./images/bg_blank.gif" />
					<#else>
						<img width="140" height="80" src="upload/voucher_${product.voucher!}" />
						<@s.hidden name="product.voucher" value="${product.voucher!}" />
					</#if>
				</div>

				<#-- 商品名称 -->
				<div class="form_item">
					<@s.label for="name" value="%{getText('system.product.name')} %{getText('system.required')}" />
					<@s.textfield id="name" cssClass="input" name="product.name" maxlength="50" cssStyle="width: 490px;" />
					<span class="charsLeft"></span>
					<span id="nameTip"></span>
				</div>

				<#-- 商品原价 -->
				<div class="form_item">
					<@s.label for="price" value="%{getText('system.product.price')} %{getText('system.required')}" />
					<@s.textfield id="price" cssClass="input" name="product.price" maxlength="50" cssStyle="ime-mode: disabled;" />
					<span id="priceTip"></span>
				</div>

				<#-- 商品现价 -->
				<div class="form_item">
					<@s.label for="offPrice" value="%{getText('system.product.offPrice')} %{getText('system.required')}" />
					<@s.textfield id="offPrice" cssClass="input" name="product.offPrice" maxlength="50" cssStyle="ime-mode: disabled;" />
					<span id="offPriceTip"></span>
				</div>
				<#--
				<div class="form_item">
					<@s.label for="discount" value="%{getText('system.product.discount')} %{getText('system.required')}" />
					<@s.textfield id="discount" cssClass="input" name="product.discount" maxlength="50" cssStyle="ime-mode: disabled;" />
					<span id="discountTip"></span>
				</div>
				<div class="form_item">
					<@s.label for="economize" value="%{getText('system.product.economize')} %{getText('system.required')}" />
					<@s.textfield id="economize" cssClass="input" name="product.economize" maxlength="50" cssStyle="ime-mode: disabled;" />
					<span id="economizeTip"></span>
				</div>
				-->

				<#-- 商品会员价 -->
				<div class="form_item">
					<@s.label for="memberPrice" value="%{getText('system.product.memberPrice')}" />
					<@s.textfield id="memberPrice" cssClass="input" name="product.memberPrice" maxlength="50" cssStyle="ime-mode: disabled;" />
					<span id="memberTip"></span>
				</div>

				<#-- 商品有效期限 -->
				<div class="form_item">
					<@s.label for="endTime" value="%{getText('system.product.endTime')}" />
					<@sd.datetimepicker adjustWeeks="false" name="product.endTime" toggleType="explode" toggleDuration="500" weekStartsOn="1" displayFormat="yyyy-MM-dd" />
				</div>
				
				<#-- 商品使用说明 -->
				<div class="form_item">
					<@s.label for="instruction" value="%{getText('system.product.instruction')}" />
					<@s.textarea id="instruction" name="product.instruction" cols="70" rows="7"></@s.textarea>
				</div>
				
				<#-- 商品商家简介-->
				<div class="form_item">
					<@s.label for="introduce" value="%{getText('system.product.introduce')}" />
					<@s.textarea id="introduce" name="product.introduce" cols="70" rows="7"></@s.textarea>
				</div>

				<#-- 商品使用地址 -->
				<div class="form_item">
					<@s.label for="address" value="%{getText('system.product.address')} %{getText('system.required')}" />
					<@s.textfield id="address" cssClass="input" name="product.address" maxlength="50" cssStyle="width: 490px;" />
					<span class="charsLeft"></span>
					<span id="addressTip"></span>
				</div>

				<#-- 商品限购数量 -->
				<div class="form_item">
					<@s.label for="counts" value="%{getText('system.product.limit')}" />
					<@s.textfield id="counts" cssClass="input" name="product.counts" maxlength="5" />
				</div>
				
				<#-- 表单提交 -->
				<div id="form_opt">
					<input class="btn" type="submit" id="product_submit" name="submit1" value="<#if (0 == product.productId)><@s.text name="system.button.add" /><#else><@s.text name="system.button.update" /></#if>" />&nbsp;&nbsp;
					<input class="btn" type="button" onClick="javascript:history.back();" value="<@s.text name="system.button.back" />" />
				</div>
			</div>
			<@s.hidden name="cmd" value="save" />
			<@s.hidden name="product.hit" value="${product.hit!}" />
			<@s.hidden name="product.type" value="${product.type!}" />
			<@s.hidden name="product.productId" value="${product.productId!}" />
			<@s.hidden name="product.discount" value="${product.discount!}" />
			<@s.hidden name="product.economize" value="${product.economize!}" />
		</@s.form>
	</body>
</html>
