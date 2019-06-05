<div id="product_top_placard">
	<div id="product_top_placard_top"></div>
	<div id="product_top_placard_bottom">
		<#if productPlacardList?? && 0 < productPlacardList?size>
			<#list productPlacardList as placard>
				<div class="product_top_placard_bottom_item">
					<img src="./images/point.jpg" />&nbsp;
					<a href="${placard.productId!}.html" title="${placard.name!}" target="_blank">
						<#if (placard.name!?length > 15)>
							${placard.name[0..14]!}...
						<#else>
							${placard.name!}
						</#if>
					</a>
				</div>
			</#list>
		</#if>
	</div>
</div>