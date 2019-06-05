热门搜索：
<#if hotSearchList?? && 0 < hotSearchList?size>
	<#list hotSearchList as search>
		<a href="product.action?cmd=search&obj=&k=${search.keyword!}" title="${search.keyword!}" target="_blank">${search.keyword!}</a>&nbsp;
	</#list>
</#if>