<div id="limit">
	<div id="limit_top"></div>
	<#if productLimitList?? && 0 < productLimitList?size>
		<#list productLimitList as product>
			<div id="limit_middle">
				<a href="${product.productId!}.html" title="${product.name!}" target="_blank">
					<#if (15 < product.name!?length)>${product.name[0..14]!}...<#else>${product.name!}</#if>
				</a>
			</div>
			<div id="limit_bottom">
				<div id="limit_bottom_left">
					<a href="${product.productId!}.html" title="${product.name!}" target="_blank">
						<img src="./upload/category_${product.picture!}" width="96" height="69" />
					</a>
				</div>
				<div id="limit_bottom_right">
					价格：${product.offPrice?string.currency}
					<br />
					原价：${product.price?string.currency}
					<br />
					折扣：${product.discount!} 折
					<br />
					还有：${product.counts!} 件
				</div>
			</div>
			<#if (0 == product_index)>
				<#break>
			</#if>
		</#list>
	</#if>
</div>