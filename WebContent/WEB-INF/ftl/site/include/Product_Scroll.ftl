<div id="product_top_scroll">
	<div id="featured">
		<ul class="ui-tabs-nav">
			<#if productShowList?? && 0 < productShowList?size>
				<#list productShowList as show>
					<li class="ui-tabs-nav-item<#if (0 == show_index)> ui-tabs-selected</#if>" id="nav-fragment-${show_index + 1}">
						<a href="#fragment-${show_index + 1}">
							<span>
								<#if (show.name!?length > 10)>
									${show.name[0..9]!}...
								<#else>
									${show.name!}
								</#if>
							</span>
						</a>
					</li>
				</#list>
			</#if>
		</ul>
		
		<#if productShowList?? && 0 < productShowList?size>
			<#list productShowList as show>
				<div id="fragment-${show_index + 1}" class="ui-tabs-panel<#if (0 == show_index)><#else> ui-tabs-hide</#if>">
					<a href="${show.productId!}.html" title="${show.name!}" target="_blank">
						<img src="./upload/product_${show.picture!}" width="513" height="240" />
					</a>
				</div>
			</#list>
		</#if>
	</div>
</div>