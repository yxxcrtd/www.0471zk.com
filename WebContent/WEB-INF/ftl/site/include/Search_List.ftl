<div id="list">
	<#-- 搜索顶部的总数 -->
	<div id="list_top">
		<div id="list_top_picture">
			<img src="./images/bg_product_case_front.jpg" />
		</div>
		<div id="search_top_left">搜索结果：（共搜索到&nbsp;<font class="font_red">${productList?size!}</font>&nbsp;条结果）</div>
	</div>
	
	<#-- 搜索底部结果 -->
	<div id="search_bottom">
		<div class="gap_row"></div>
		<div id="itemContainer">
			<#assign i = 0>
			<#if productList?? && 0 lt productList?size>
				<#list productList as product>
					<li>
						<div class="search_block">
							<div class="search_block_picture">
								<a href="${product.productId!}.html" target="_blank">
									<img src="./upload/case_${product.picture!}" width="146" height="110" title="${product.name!}" />
								</a>
							</div>
							<div class="search_block_name">
								<a href="${product.productId!}.html" title="${product.name!}" target="_blank">
									<#if (product.name!?length > 11)>
										${product.name[0..10]!}...
									<#else>
										${product.name!}
									</#if>
								</a>
							</div>
							<div class="search_block_name1">
								市场价：${product.price!?c}&nbsp;元
							</div>
							<div class="search_block_name">
								折扣价：<span class="font_red">${product.offPrice!?c}&nbsp;元</span>
							</div>
						</div>
					</li>
				</#list>
			<#else>
				<div class="tip">对不起，没有搜索结果！</div>
			</#if>
		</div>
		<div class="holder"></div>
	</div>
</div>

<script type="text/javascript" language="javascript">
<!--
	$("div.holder").jPages({
		containerID : "itemContainer",
        perPage		: 8
	});
//-->
</script>
