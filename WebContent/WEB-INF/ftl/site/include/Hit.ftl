<div id="hit_top">
	<div id="hit_title">热门排行榜</div>
</div>
<div id="hit_bottom">
	<#if hitProductList?? && 0 < hitProductList?size>
		<#list hitProductList as hit>
			<#if (0 == hit_index % 2)>
				<div class="product_hit_bg">
			<#else>
				<div class="product_hit">
			</#if>
				<div class="product_hit_picture">
					<a href="${hit.productId!}.html" target="_blank">
						<img src="./upload/category_${hit.picture!}" width="92" height="67" title="${hit.name!}" />
					</a>
				</div>
				<div class="product_hit_introduce">
					<div class="product_hit_introduce_item">
						<#if (hit.name!?length > 8)>
							${hit.name[0..7]!}...
						<#else>
							${hit.name!}
						</#if>
					</div>
					<div class="product_hit_introduce_item">
						折扣价：<span class="font_red">${hit.offPrice!?c}&nbsp;元</span>
					</div>
					<div class="product_hit_introduce_item">
						<a href="${hit.productId!}.html" target="_blank">
							<span class="font_red">【查看】</span>
						</a>
					</div>
				</div>
			</div>
		</#list>
	</#if>
</div>