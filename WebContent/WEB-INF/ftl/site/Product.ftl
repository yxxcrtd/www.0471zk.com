<#if ("house" == type)>
	<#assign object = "家居建材">
<#elseif ("food" == type)>
	<#assign object = "餐饮美食">
<#elseif ("fun" == type)>
	<#assign object = "休闲娱乐">
<#elseif ("travel" == type)>
	<#assign object = "出行旅游">
<#elseif ("celebration" == type)>
	<#assign object = "庆典礼仪">
<#elseif ("education" == type)>
	<#assign object = "教育培训">
<#elseif ("medical" == type)>
	<#assign object = "寻医问诊">
<#elseif ("gift" == type)>
	<#assign object = "烟酒礼品">
</#if>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>${object!} - 青城折扣网</title>
		<meta name="keywords" content="0471, 折扣" />
		<meta name="description" content="青城折扣网，打造全蒙最大折扣平台！" />
		<link rel="icon" href="./images/home.ico" />
		<link type="text/css" rel="styleSheet" href="./css/style.css" />
		<script type="text/javascript" src="./js/jquery.js"></script>
		<script type="text/javascript" src="./js/jquery.cookie.js"></script>
		<script type="text/javascript" src="./js/jquery.ui.js"></script>
		<script type="text/javascript" src="./js/jquery.jPages.js"></script>
		<script type="text/javascript" src="./js/public.js"></script>
		<script type="text/javascript" src="./js/product.js"></script>
	</head>
	
	<body>
		<#include "include/Top.ftl">
		<div id="container">
			<div class="gap_row"></div>
			<div id="product_top">
				<#include "include/Product_Scroll.ftl">
				<div class="gap_column">&nbsp;</div>
				<div id="${type!}_placard"></div>
			</div>
			<div class="gap_row"></div>
			<div id="productId_left">
				<div id="category_title">
					<div id="category_title_inner"></div>
				</div>
				<div id="tree_${type!}">
					<script language="javascript">
						$("#tree_${type!}").load("tree_${type!}.html");
					</script>
				</div>
				<div class="gap_row"></div>
				<div id="hit"></div>
			</div>
			<div class="gap_column"></div>
			<div id="product_right">
				<#include "include/Product_Case.ftl">
				<div class="gap_row"></div>
				<#include "include/Product_List.ftl">
			</div>
			<div class="gap_row"></div>
			<div id="${type!}_bottom"></div>
			<div class="gap_row"></div>
			<div id="link"></div>
			<div class="gap_row"></div>
		</div>
		<#include "include/Footer.ftl">
	</body>
</html>