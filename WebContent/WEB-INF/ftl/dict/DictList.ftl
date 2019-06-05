<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.menu.dict" /><@s.text name="system.manage" /></title>
        <link type="text/css" rel="styleSheet" href="./css/style.css" />
	</head>
	
	<body>
		<div class="tableSearch">
			<@s.form name="search_form" action="dict" method="get">
				<@s.hidden name="obj" value="${obj}" />
				<@s.textfield cssClass="input" name="k" value="${k!?html}" onmouseover="this.select();" /> 
				<@s.submit cssClass="btn" value="%{getText('system.button.search')}" />
			</@s.form>
		</div>
		
  		<table class="table" cellSpacing="1">
  			<thead>
	  			<tr>
					<th width="20%">ID</th>
					<th width="30%"><@s.text name="system.dict.key" /></th>
					<th width="30%"><@s.text name="system.dict.value" />(<@s.text name="system.click.update.save" />)</th>
					<th width="20%"><@s.text name="system.operate" /></th>
  				</tr>
  			</thead>
  			
  			<tbody>
				<#list dictList as dict>
					<tr bgColor="#FFFFFF" onMouseOver="changeBgColor(this, '#F4F4F4')" onMouseOut="changeBgColor(this, '#FFFFFF')">
						<td class="center">
							${dict.dictId}
						</td>
						<td class="center">
							${dict.dictKey}
						</td>
						<td class="edit">
							${dict.dictValue}
						</td>
						<td class="center">
							<@s.a href="?cmd=del&amp;obj=${obj}&amp;dict.dictId=${dict.dictId}" onclick="return confirm('%{getText('system.delete.confirm')}');"><@s.text name="system.delete" /></@s.a>
						</td>
					</tr>
				</#list>
            	<#if 0 == dictList?size>
            		<tr>
            			<td colSpan="4" class="tip"><@s.text name="system.no.record" /></td>
            		</tr>
            	</#if>
  			</tbody>
  		</table>
        
        <#if dictList?? && dictList?size != 0>
            <@s.div id="pager">
                <#include "../include/Pager.ftl">
            </@s.div>
		</#if>
        
        <script language="javaScript" src="./js/jquery.js"></script>
        <script language="javaScript" src="./js/public.js"></script>
        <script language="javaScript" src="./js/dictList.js"></script>
	</body>
</html>
