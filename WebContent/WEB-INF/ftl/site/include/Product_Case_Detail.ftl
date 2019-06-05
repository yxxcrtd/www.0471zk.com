<#assign i = 0>
<#if productList?? && 0 lt productList?size>
	<#list productList as product>
		<div class="block_case">
			<div class="block_case_picture">
				<a href="${product.productId!}.html" target="_blank">
					<img src="./upload/case_${product.picture!}" width="152" height="110" title="${product.name!}" />
				</a>
			</div>
			<div class="block_case_name">
				<a href="${product.productId!}.html" title="${product.name!}" target="_blank">
					<#if (product.name!?length > 12)>
						${product.name[0..11]!}...
					<#else>
						${product.name!}
					</#if>
				</a>
			</div>
			<div class="block_case_name1">
				市场价：${product.price!?c}&nbsp;元
			</div>
			<div class="block_case_name">
				折扣价：<span class="font_red">${product.offPrice!?c}&nbsp;元</span>
			</div>
		</div>
		<#if (7 == product_index)>
			<#break>
		</#if>
		<#if product_has_next>
			<#assign i = i + 1>
			<#if i % 4 == 0>
				<div class="gap_row"></div>
			<#else>
				<div class="gap_column">&nbsp;</div>
			</#if>
		</#if>
	</#list>
</#if>