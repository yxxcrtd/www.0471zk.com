<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.tuan.list" /></title>
        <link type="text/css" rel="styleSheet" href="./css/manage.css" />
        <script language="javaScript" src="./js/table.js"></script>
	</head>
	
	<body>
		<div id="tableSearch">
			<@s.form name="search_form" action="tuan" method="get">
				<@s.hidden name="obj" value="${obj}" />
				<@s.textfield cssClass="input" name="k" value="${k!?html}" onmouseover="this.select();" /> 
				<@s.submit cssClass="btn" value="%{getText('system.button.search')}" />
			</@s.form>
		</div>
		
  		<table id="table" cellSpacing="1">
  			<thead>
	  			<tr>
					<th width="10%">ID</th>
					<th width="15%">团购图片</th>
					<th width="40%" class="left">团购名称 / 连接</th>
					<th width="20%" class="left">现价 / 原价 / 折扣</th>
					<th width="15%">操&nbsp;作</th>
  				</tr>
  			</thead>
  			<tbody>
				<#if tuanList?size == 0>
            		<tr>
            			<td colSpan="9" class="tip">
							<@s.text name="system.no.record" />
						</td>
            		</tr>
				</#if>
				<#list tuanList as tuan>
					<tr bgColor="#FFFFFF" onMouseOver="changeBgColor(this, '#F4F4F4')" onMouseOut="changeBgColor(this, '#FFFFFF')">
						<td class="center">
							${tuan.tuanId!}
						</td>
						<td class="center">
							<#if (tuan.picture?? && "" != tuan.picture)>
								<img src="./upload/${tuan.picture!}" width="100" height="75" />
							</#if>
						</td>
						<td class="left">
							<a href="${tuan.tuanId!}.html" target="_blank">
								${tuan.name!}
							</a>
							<br />
							<a href="${tuan.url!}" target="_blank">
								${tuan.url!}
							</a>
						</td>
						<td class="left">
							${tuan.offPrice?string.currency} / ${tuan.price?string.currency} = ${tuan.discount!}
						</td>
						<td class="center">
							<@s.a href="?obj=${obj}&amp;cmd=edit&amp;tuan.tuanId=${tuan.tuanId}"><@s.text name="system.update" /></@s.a>&nbsp;
							<@s.a href="?cmd=del&amp;tuan.tuanId=${tuan.tuanId}" onclick="return confirm('%{getText('system.delete.confirm')}');"><@s.text name="system.delete" /></@s.a>
						</td>
					</tr>
				</#list>
  			</tbody>
  		</table>
        
        <#if tuanList?? && 0 != tuanList?size>
            <@s.div id="pager">
                <#include "../include/Pager.ftl">
            </@s.div>
        </#if>
	</body>
</html>
