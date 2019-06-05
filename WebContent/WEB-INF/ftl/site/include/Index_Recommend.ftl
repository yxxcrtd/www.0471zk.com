<div>
	<div id="index_${type!}_top">
		<div class="more_case">
			<a href="${type!}.html">MORE>></a>
		</div>
	</div>
	
	<div id="index_${type!}_main">
		<#if recommendList?? && 0 < recommendList?size>
			<#list recommendList as recommend>
				<div class="product_block_small">
					<div class="product_block_small_picture">
						<a href="${recommend.productId!}.html" target="_blank">
							<img src="./upload/category_${recommend.picture!}" width="111" height="82" title="${recommend.name!}" />
						</a>
					</div>
					<div class="product_block_small_name">
						<a href="${recommend.productId!}.html" title="${recommend.name!}" target="_blank">
							<#if (recommend.name!?length > 9)>
								${recommend.name[0..8]!}...
							<#else>
								${recommend.name!}
							</#if>
						</a>
					</div>
					<div class="product_block_small_name1">
						市场价：${recommend.price!?c}&nbsp;元
					</div>
					<div class="product_block_small_name">
						折扣价：<span class="font_red">${recommend.offPrice!?c}&nbsp;元</span>
					</div>
				</div>
			</#list>
		</#if>
	</div>
</div>