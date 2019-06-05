<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>${category.name!} - 青城折扣网</title>
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
		<#include "Top.ftl">
		<div id="container">
			<div id="ad"></div>
			<div class="gap_row"></div>
			<div id="productId_left">
				<#include "Index_Category.ftl">
			</div>
			<div class="gap_column"></div>
			<div id="search_right">
				<#include "Product_Category_List.ftl">
			</div>
			<div class="gap_row"></div>
			<div id="index_bottom"></div>
			<div class="gap_row"></div>
			<div id="link"></div>
			<div class="gap_row"></div>
		</div>
		<#include "Footer.ftl">
	</body>
</html>