<div id="category_${type!}">
	<#if categoryTree??>
		<#list categoryTree.all as c>
			<#if c.parentId??>
				<#if (categoryId == c.parentId)>
					<div class="category_root">${c.name!}</div>
				<#else>
					<div class="category_item">
						<a href="c${c.categoryId!}.html" title="${c.name!}">${c.name!}</a>
					</div>
					<#if c_has_next><span class="separator">|</span></#if>
				</#if>
			</#if>
		</#list>
	</#if>
</div>