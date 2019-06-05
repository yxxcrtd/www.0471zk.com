<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>${product.name!} - 青城折扣网</title>
		<meta name="keywords" content="0471, 折扣" />
		<meta name="description" content="青城折扣网，打造全蒙最大折扣平台！" />
		<link rel="icon" href="./images/home.ico" />
		<link type="text/css" rel="styleSheet" href="./css/style.css" />
		<script type="text/javascript" src="./js/jquery.js"></script>
		<script type="text/javascript" src="./js/jquery.cookie.js"></script>
		<script type="text/javascript" src="./js/jquery.jPages.js"></script>
		<script type="text/javascript" src="./js/jquery.printPage.js"></script>
		<script type="text/javascript" src="./js/public.js"></script>
		<script type="text/javascript" src="./js/productId.js"></script>
		<script type="text/javascript">
		<!--
		$(function() {
			$.post("product.action", {
				"cmd" : "hit",
				"product.productId" : ${product.productId!}
			});
	
			// 限量抢购
			$("#print").bind("click", function() {
				$.get("product.action", {
					"cmd" : "print",
					"product.productId" : ${product.productId!}
				});
			});
		});
		//-->
		</script>
	</head>
	
	<body>
		<#include "include/Top.ftl">
		<div id="container">
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
			
			<div id="productId_right">
				<div class="gap_row"></div>
				<#-- 商品的主体信息 -->
				<div id="productId_right_picture">
					<div id="productId_right_picture_img">
						<img src="./upload/show_${product.picture!}" width="235" height="180" />
					</div>
					<div id="productId_right_picture_info">
						<div id="productId_right_picture_info_title">${product.name!}</div>
						<div class="productId_right_picture_info_item">市 场 价：${product.price!?string.currency}</div>
						<div class="productId_right_picture_info_item">销 售 价：<span class="font_red">${product.offPrice!?string.currency}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;立省：${product.economize!?string.currency}</div>
						<div class="productId_right_picture_info_item">会 员 价：${product.memberPrice!?string.currency}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（本站会员享受）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="join.html" target="_blank">如何成为本站会员？</a></div>
						<div class="gap_row"></div>
						<div class="productId_right_picture_info_item">有效期限：${product.endTime!?string("yyyy-MM-dd")}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;重大节假日：可以使用</div>
						<div class="productId_right_picture_info_item">消费限制：特价款式除外&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他优惠：不可以同时享受</div>
						<div class="productId_right_picture_info_item">使用地址：${product.address!}</div>
						<div class="gap_row"></div>
						<div id="productId_right_picture_info_item1">温馨提示：本券为实体券，需购买方可去商家消费</div>
					</div>
				</div>
				
				<div class="gap_row"></div>
				
				<#-- 使用说明 -->
				<div id="productId_right_instruction">使用说明</div>
				
				<#-- 商品的主体信息中间的两个小横分隔 -->
				<div class="productId_right_separator">
					<div class="productId_right_separator_left"></div>
					<div class="productId_right_separator_right"></div>
				</div>
				
				<#-- 使用说明的主体（包括优惠券） -->
				<div id="productId_right_instruction_main">
					<div id="productId_right_instruction_main_text">
						<div id="productId_right_instruction_main_text_top">
							<#if (product.instruction?length gt 165)>
								${product.instruction[0..165]!} ...
							<#else>
								${product.instruction!}
							</#if>
						</div>
						<div id="productId_right_instruction_main_text_bottom">商家简介</div>
					</div>
					<div id="productId_right_instruction_main_voucher">
						<img src="./upload/voucher_${product.voucher!}" width="275" height="148" />
					</div>
					<div id="productId_right_instruction_main_print">
						优惠券<br />&nbsp;&nbsp;
						<img src="./images/bg_print.jpg" />
						<a id="print" href="/iframes/iframe${product.productId!}.html">打印</a>
					</div>
					<div id="productId_right_instruction_main_print1"></div>
				</div>
				
				<#-- 商品的主体信息中间的两个小横分隔 -->
				<div class="productId_right_separator">
					<div class="productId_right_separator_left"></div>
					<div class="productId_right_separator_right"></div>
				</div>
				
				<#-- 商家简介的文字部分 -->
				<div id="productId_right_introduce">${product.introduce!}</div>
				
				<div class="gap_row"></div>
				
				<#-- 相关商品 -->
				<div id="productId_right_interrelated">相关商品</div>
				<div class="gap_row"></div>
				<div id="productId_right_interrelated_detail">
					<div id="interrelated" class="clearfix">
						<div id="content" class="defaults">
							<ul id="itemContainer">
								<#if interrelatedList?? && 0 lt interrelatedList?size>
									<#list interrelatedList as interrelated>
										<li>
											<a href="${interrelated.productId!}.html" target="_blank">
												<img src="./upload/case_${interrelated.picture!}" width="151" height="108" title="${interrelated.name!}" alt="${interrelated.name!}">
											</a>
										</li>
									</#list>
								</#if>
							</ul>
							<div class="holder"></div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="gap_row"></div>
			
			<div id="productId_right_service">
				<div id="productId_right_service_left">售后服务</div>
				<div id="productId_right_service_right">
					<div class="placard_bottom_item">
						<img src="./images/point.jpg" />&nbsp;请购买时留意卡券使用有效期，如自行放置导致过期，本站将不予以退换；<br />
						<img src="./images/point.jpg" />&nbsp;自购券之日起一周内，凭购物小票可无条件全额退款；<br />
						<img src="./images/point.jpg" />&nbsp;自购券之日起60天内，如商家倒闭或其他原因无法使用，可凭购物小票全额退款；<br />
						<img src="./images/point.jpg" />&nbsp;电子票及特价类票券一经售出不予退换；<br />
						<img src="./images/point.jpg" />&nbsp;本站在法律范围内保留最终解释权。<br />
					</div>
				</div>
			</div>
			
			<div class="gap_row"></div>
			
			<div id="link"></div>			
			<div class="gap_row"></div>
		</div>
		
		<#include "include/Footer.ftl">
	</body>
</html>
