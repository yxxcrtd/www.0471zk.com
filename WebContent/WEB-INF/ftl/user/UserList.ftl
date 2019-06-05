<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>用户管理</title>
        <link type="text/css" rel="styleSheet" href="./css/manage.css" />
        <script language="javaScript" src="./js/table.js"></script>
	</head>
	
	<body>
		<div id="tableSearch">
			<@s.form name="search_form" action="user" method="get">
				<@s.textfield cssClass="input" name="k" value="${k!?html}" onmouseover="this.select();" /> 
				<@s.submit cssClass="btn" value="%{getText('system.button.search')}" />
			</@s.form>
		</div>
		
  		<table id="table" cellSpacing="1">
  			<thead>
	  			<tr>
					<th width="15%">用户ID</th>
					<th width="15%" class="left">用户名</th>
					<th width="20%" class="left">邮件地址</th>
					<th width="20%" class="left">手机</th>
					<th width="15%">用户角色</th>
					<th width="15%">操&nbsp;作</th>
  				</tr>
  			</thead>
  			
  			<tbody>
				<#list userList as user>
					<tr bgColor="#FFFFFF" onMouseOver="changeBgColor(this, '#F4F4F4')" onMouseOut="changeBgColor(this, '#FFFFFF')">
						<td class="center">
							${user.userId!}
						</td>
						<td class="left">
							${user.username!}
						</td>
						<td class="left">
							${user.email!}
						</td>
						<td class="left">
							${user.phone!}
						</td>
						<td class="center">
							<#if (1 == user.role)>系统管理员
								<#elseif (0 == user.role)><font color="#0000FF">会员</font>
								<#elseif (2 == user.role)><font color="#00FF00">商户</font>
								<#elseif (9 == user.role)><font color="#FF00FF">已删除</font>
								<#else><font color="#FF0000">有异常</font>
							</#if>
						</td>
						<td class="center">
							<@s.a href="?cmd=edit&amp;uid=${user.userId}"><@s.text name="system.update" /></@s.a>&nbsp;&nbsp;&nbsp;&nbsp;
							<@s.a href="?cmd=del&amp;uid=${user.userId}" onclick="return confirm('%{getText('system.delete.confirm')}');"><@s.text name="system.delete" /></@s.a>
						</td>
					</tr>
				</#list>
            	<#if 0 == userList?size>
            		<tr>
            			<td colSpan="6" class="tip"><@s.text name="system.no.record" /></td>
            		</tr>
            	</#if>
  			</tbody>
  		</table>
        
        <#if userList?? && userList?size != 0>
            <@s.div id="pager">
                <#include "../include/Pager.ftl">
            </@s.div>
        </#if>
	</body>
</html>
