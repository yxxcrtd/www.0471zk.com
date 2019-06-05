<div id="category_${type!}">
	<#if categoryTree??>
		<#list categoryTree.all as c>
			<#if c.parentId??><#-- 一级分类是没有parentId的 -->
				<#if (c.itemNum > 0)><#-- 子分类数量 -->
					<#if (1 == c_index)><#else></div></#if><#-- 只有第二个才有结束 -->
					<div class="category_item_left"><a href="${type!}.html">${c.name!}</a></div>
					<div class="category_item_right_all">
				<#else>
					<div class="category_item_right"><a href="c${c.categoryId!}.html">${c.name!}</a></div>
					<#if c_has_next><span class="separator2">|</span><#else></div></#if>
				</#if>
			</#if>
		</#list>
	</#if>
</div>