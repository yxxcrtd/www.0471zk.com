<div id="itemContainer${id!}">
	<#if productList?? && 0 lt productList?size>
		<#list productList as product>
			<li>
				<div class="product_block_small_1">
					<div class="product_block_small_picture_1">
						<a href="${product.productId!}.html" target="_blank">
							<img src="./upload/category_${product.picture!}" width="116" height="82" title="${product.name!}" />
						</a>
					</div>
					<div class="product_block_small_name">
						<a href="${product.productId!}.html" title="${product.name!}" target="_blank">
							<#if (product.name!?length > 9)>
								${product.name[0..8]!}...
							<#else>
								${product.name!}
							</#if>
						</a>
					</div>
				</div>
			</li>
		</#list>
	</#if>
</div>
<div class="holder${id!}"></div>
<script type="text/javascript" language="javascript">
	// 在分页之前将content1设为可见，否则无法生成分页。因为分页插件不支持在不可见的区域生成分页
	$("div.content1").css("display", "block");
	
	$("div.holder${id!}").jPages({
		containerID : "itemContainer${id!}",
		perPage		: 10
	});

	// 在分页之后将content1设为隐藏，否则在第一个区域将显示所有的分页
	$("div.content1").css("display", "none");
</script>