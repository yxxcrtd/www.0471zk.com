<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.menu.link.list" /></title>
        <link type="text/css" rel="styleSheet" href="./css/manage.css" />
        <script language="javaScript" src="./js/table.js"></script>
	</head>
	
	<body>
		<div id="tableSearch">
			<@s.form id="form_link" name="search_form" action="link" method="get">
				<@s.textfield cssClass="input" name="k" value="${k!?html}" onmouseover="this.select();" /> 
				<@s.submit cssClass="btn" value="%{getText('system.button.search')}" />
			</@s.form>
		</div>
		
  		<table id="table" cellSpacing="1">
  			<thead>
	  			<tr>
					<th width="15%">ID</th>
					<th width="20%" class="left"><@s.text name="system.link.name" /></th>
					<th width="30%" class="left"><@s.text name="system.link.url" /></th>
					<th width="20%" class="left"><@s.text name="system.link.modified" /></th>
					<th width="15%"><@s.text name="system.operate" /></th>
  				</tr>
  			</thead>
  			
  			<tbody>
				<#list linkList as link>
					<tr bgColor="#FFFFFF" onMouseOver="changeBgColor(this, '#F4F4F4')" onMouseOut="changeBgColor(this, '#FFFFFF')">
						<td class="center">
							${link.linkId}
						</td>
						<td class="left">
							${link.name!}
						</td>
						<td class="left">
							<a href="http://${link.url!}" target="_blank">
								${link.url!}
							</a>
						</td>
						<td class="left">
							${link.modified!?string("yyyy-MM-dd HH:mm:ss")}
						</td>
						<td class="center">
							<@s.a href="?cmd=edit&amp;link.linkId=${link.linkId!}"><@s.text name="system.update" /></@s.a>&nbsp;&nbsp;&nbsp;&nbsp;
							<@s.a href="?cmd=del&amp;link.linkId=${link.linkId!}" onclick="return confirm('%{getText('system.delete.confirm')}');"><@s.text name="system.delete" /></@s.a>
						</td>
					</tr>
				</#list>
            	<#if 0 == linkList?size>
            		<tr>
            			<td colSpan="4" class="tip"><@s.text name="system.no.record" /></td>
            		</tr>
            	</#if>
  			</tbody>
  		</table>
        
        <#if linkList?? && linkList?size != 0>
            <@s.div id="pager">
                <#include "../include/Pager.ftl">
            </@s.div>
		</#if>
	</body>
</html>
