<div id="recommend_main">
	<span>热门专题推荐：</span>
	<#if recommendList?? && 0 < recommendList?size>
		<#list recommendList as recommend>
			<a href="${recommend.productId!}.html" title="${recommend.name!}" target="_blank"><#if (recommend.name!?length > 15)>${recommend.name[0..14]!}...<#else>${recommend.name!}</#if></a>
			&nbsp;
		</#list>
	</#if>
</div>