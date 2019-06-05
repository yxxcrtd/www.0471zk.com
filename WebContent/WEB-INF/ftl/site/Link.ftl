<div id="link_left">
	友情连接：
</div>
<div id="link_right">
	<#if linkList?? && 0 < linkList?size>
		<#list linkList as link>
			<a href="http://${link.url!}" title="${link.name!}" target="_blank">${link.name!}</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</#list>
	</#if>
</div>