<div id="top">
	<#-- 页面顶部的左边 -->
	<div id="top_left"></div>
	
	<#-- 页面顶部的中间 -->
	<div id="top_middle">
		<div id="top_middel_hot_search"></div>
		<div id="top_middel_search">
			<strong>商家搜索：</strong><input id="input1" value="${k!}" onmouseover="this.select();" maxlength="10" /><select id="search_select">
				<option value="" ${("" == obj!)?string("selected", "")}>商品分类</option>
				<option value="house" ${("house" == obj!)?string("selected", "")}>家居建材</option>
				<option value="food" ${("food" == obj!)?string("selected", "")}>餐饮美食</option>
				<option value="fun" ${("fun" == obj!)?string("selected", "")}>休闲娱乐</option>
				<option value="travel" ${("travel" == obj!)?string("selected", "")}>出行旅游</option>
				<option value="celebration" ${("celebration" == obj!)?string("selected", "")}>庆典礼仪</option>
				<option value="education" ${("education" == obj!)?string("selected", "")}>教育培训</option>
				<option value="medical" ${("medical" == obj!)?string("selected", "")}>寻医问诊</option>
				<option value="gift" ${("gift" == obj!)?string("selected", "")}>烟酒礼品</option>
			</select>
			<input id="search" type="button" value="" />
		</div>
		<div id="login_success"></div>
		<div id="top_middel_login">
			<form action="login.action">
				<strong>会员登录：</strong>用户名&nbsp;<input class="input" id="username" name="user.username" maxlength="20" />&nbsp;
				密码&nbsp;<input type="password" class="input" id="password" name="user.password" />&nbsp;<input id="login" type="submit" value="" />&nbsp;
				[<a href="register.action"><strong>会员注册</strong></a>]
				[<a href="find.action">忘记密码</a>]
				<#-- 如果两个都存在，则是三级页面；如果id不存在，则是二级页面 -->
				<input type="hidden" name="returnUrl" value="<#if (productId??) && (0 < productId?length)>${productId!}.html<#elseif ("" != type)>${type!}.html</#if>" />
			</form>
		</div>
	</div>
	
	<#-- 页面顶部的右边 -->
	<div id="top_right"></div>
</div>

<script type="text/javascript">
$(function() {
	var kNode = $("#input1");
	$("#search").bind("click", function(e) {
		var kNodeValue = $.trim(kNode.val());
		if ("" == kNodeValue) {
			alert("请输入检索关键字！");
			kNode.focus();
			return false;
		}
		var queryObj = $("#search_select option:selected").val();
		window.location.href="/product.action?cmd=search&obj=" + queryObj + "&k=" + kNodeValue;
	});
});
</script>

<#-- 菜单 -->
<div id="menu">
	<div id="menu_main">
		<a class="a<#if ("" == type)> current</#if>" href="/">
			<span class="menu_a">首&nbsp;&nbsp;页</span>
		</a>
		<span class="menu_separator"></span>
		<a class="a<#if ("house" == type)> current</#if>" href="house.html">
			<span class="menu_a">家居建材</span>
		</a>
		<span class="menu_separator"></span>
		<a class="a<#if ("food" == type)> current</#if>" href="food.html">
			<span class="menu_a">餐饮美食</span>
		</a>
		<span class="menu_separator"></span>
		<a class="a<#if ("fun" == type)> current</#if>" href="fun.html">
			<span class="menu_a">休闲娱乐</span>
		</a>
		<span class="menu_separator"></span>
		<a class="a<#if ("travel" == type)> current</#if>" href="travel.html">
			<span class="menu_a">出行旅游</span>
		</a>
		<span class="menu_separator"></span>
		<a class="a<#if ("celebration" == type)> current</#if>" href="celebration.html">
			<span class="menu_a">庆典礼仪</span>
		</a>
		<span class="menu_separator"></span>
		<a class="a<#if ("education" == type)> current</#if>" href="education.html">
			<span class="menu_a">教育培训</span>
		</a>
		<span class="menu_separator"></span>
		<a class="a<#if ("medical" == type)> current</#if>" href="medical.html">
			<span class="menu_a">寻医问诊</span>
		</a>
		<span class="menu_separator"></span>
		<a class="a<#if ("gift" == type)> current</#if>" href="gift.html">
			<span class="menu_a">烟酒礼品</span>
		</a>
	</div>
</div>

<#-- 热门专题推荐 -->
<div id="recommend"></div>