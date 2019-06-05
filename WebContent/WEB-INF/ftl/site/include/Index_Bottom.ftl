<div id="bottom">
	<#if recommendList?? && 0 < recommendList?size>
		<#list recommendList as recommend>
			<div class="product_block_big">
				<div class="product_block_big_picture">
					<a href="${recommend.productId!}.html" target="_blank">
						<img src="./upload/recommend_${recommend.picture!}" width="174" height="133" title="${recommend.name!}" />
					</a>
				</div>
				<div class="product_block_big_name">
					<a href="${recommend.productId!}.html" title="${recommend.name!}" target="_blank">
						<#if (recommend.name!?length > 12)>
							${recommend.name[0..11]!}...
						<#else>
							${recommend.name!}
						</#if>
					</a>
				</div>
			</div>
		</#list>
	</#if>
</div>