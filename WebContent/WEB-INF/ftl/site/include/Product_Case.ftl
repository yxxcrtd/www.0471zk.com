<div id="case">
	<div id="case_top">
		<div id="case_top_arrow">
			<img src="./images/bg_case_arrow.jpg" />
		</div>
		<div id="case_top_left">最新商家</div>
		<div id="case_top_right">
			<ul id="tab">
				<#if categoryList?? && 0 < categoryList?size>
					<#list categoryList as category>
						<li <#if (0 == category_index)> class="tabin"</#if>>${category.name!}</li>
					</#list>
				</#if>
			</ul>
		</div>
	</div>
	
	<div id="case_bottom">
		<#if categoryList?? && 0 < categoryList?size>
			<#list categoryList as category>
				<#if (0 == category_index)>
					<div class="contentin">
				<#else>
					<div class="content">
				</#if>
						<div class="gap_row"></div>
						<div id="product_case_${category.categoryId!}"></div>
						<script type="text/javascript" language="javascript">
						<!-- 
						$("#product_case_${category.categoryId!}").load("./${type}_case_${category.categoryId!}.html");
						-->
						</script>
					</div>
			</#list>
		</#if>
	</div>
</div>