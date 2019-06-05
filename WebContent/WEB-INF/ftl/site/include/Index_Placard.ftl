<div id="placard">
	<div id="placard_top"></div>
	<div id="placard_bottom">
		<#if indexPlacardList?? && 0 < indexPlacardList?size>
			<#list indexPlacardList as placard>
				<div class="placard_bottom_item">
					<img src="./images/point.jpg" />&nbsp;
					<a href="${placard.productId!}.html" title="${placard.name!}" target="_blank">
						<#if (placard.name!?length > 15)>
							${placard.name[0..14]!}...
						<#else>
							${placard.name!}
						</#if>
					</a>
				</div>
				<#if (4 == placard_index)>
					<#break>
				</#if>
			</#list>
		</#if>
	</div>
</div>