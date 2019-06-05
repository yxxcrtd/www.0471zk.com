<div id="attempt_top"></div>
<div id="attempt_bottom">
	<#if indexAttemptList?? && 0 < indexAttemptList?size>
		<#list indexAttemptList as product>
			<#if (0 == product_index)>
				<div id="attempt_bottom_first">
					<div id="placard_bottom_first_top">
						<a href="${product.productId!}.html" title="${product.name!}" target="_blank">
							<#if (product.name!?length > 14)>
								${product.name[0..13]!}...
							<#else>
								${product.name!}
							</#if>
						</a>
					</div>
					<div class="product_hit_picture">
						<a href="${product.productId!}.html" target="_blank">
							<img src="./upload/category_${product.picture!}" width="92" height="67" title="${product.name!}" />
						</a>
					</div>
					<div class="product_hit_introduce">
						<div class="product_hit_introduce_item">
							<a href="${product.productId!}.html" title="${product.name!}" target="_blank">
								<#if (product.name!?length > 8)>
									${product.name[0..7]!}...
								<#else>
									${product.name!}
								</#if>
							</a>
						</div>
						<div class="product_hit_introduce_item">
							折扣价：<span class="font_red">${product.offPrice!?c}&nbsp;元</span>
						</div>
						<div class="product_hit_introduce_item">
							<a href="${product.productId!}.html" target="_blank">
								<span class="font_red">【查看】</span>
							</a>
						</div>
					</div>
				</div>
			<#else>
				<div class="placard_bottom_item">
					<img src="./images/point.jpg" />&nbsp;
					<a href="${product.productId!}.html" title="${product.name!}" target="_blank">
						<#if (product.name!?length > 15)>
							${product.name[0..14]!}...
						<#else>
							${product.name!}
						</#if>
					</a>
				</div>
			</#if>
		</#list>
	</#if>
</div>