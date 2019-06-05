<div id="list">
	<div id="list_top">
		<div id="list_top_picture">
			<img src="./images/bg_product_case_front.jpg" />
		</div>
		<div id="list_top_left">商品分类</div>
		<div id="list_top_right">
			<ul id="tab1">
				<#if categoryList?? && 0 < categoryList?size>
					<#list categoryList as category>
						<li <#if (0 == category_index)> class="tabin1"</#if>>${category.name!}</li>
					</#list>
				</#if>
			</ul>
		</div>
	</div>
	<div id="list_bottom">
		<#if categoryList?? && 0 < categoryList?size>
			<#list categoryList as category>
				<#if (0 == category_index)><div class="contentin1"><#else><div class="content1"></#if>
				<div id="product_list_${category.categoryId!}"></div>
					<script type="text/javascript" language="javascript">
					<!-- 
					$("#product_list_${category.categoryId!}").load("./${type}_list_${category.categoryId!}.html");
					-->
					</script>
				</div>
			</#list>
		</#if>
	</div>
</div>