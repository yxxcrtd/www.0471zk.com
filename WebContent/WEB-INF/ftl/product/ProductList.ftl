<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.product.list" /></title>
        <link type="text/css" rel="styleSheet" href="./css/manage.css" />
        <script language="javaScript" src="./js/table.js"></script>
	</head>
	
	<body>
		<div id="tableSearch">
			<@s.form name="search_form" action="product" method="get">
				<@s.hidden name="obj" value="${obj}" />
				<@s.textfield cssClass="input" name="k" value="${k!?html}" onmouseover="this.select();" /> 
				<@s.submit cssClass="btn" value="%{getText('system.button.search')}" />
			</@s.form>
		</div>
		
  		<table id="table" cellSpacing="1">
  			<thead>
	  			<tr>
					<th width="8%">ID</th>
					<th width="9%">商品分类</th>
					<th width="10%">商品图片</th>
					<th width="25%" class="left">商品名称 / 截止日期</th>
					<th width="30%" class="left">节省 / 折扣 / 会员价</th>
					<th width="9%">商品状态</th>
					<th width="9%">操&nbsp;作</th>
  				</tr>
  			</thead>
  			<tbody>
				<#if productList?size == 0>
            		<tr>
            			<td colSpan="9" class="tip">
							<@s.text name="system.no.record" />
						</td>
            		</tr>
				</#if>
				<#list productList as product>
					<tr bgColor="#FFFFFF" onMouseOver="changeBgColor(this, '#F4F4F4')" onMouseOut="changeBgColor(this, '#FFFFFF')">
						<td class="center">
							${product.productId!}
						</td>
						<td class="center">
							<#if ("house" == product.type)>家居建材
								<#elseif ("food" == product.type)>餐饮美食
								<#elseif ("fun" == product.type)>休闲娱乐
								<#elseif ("travel" == product.type)>出行旅游
								<#elseif ("celebration" == product.type)>庆典礼仪
								<#elseif ("education" == product.type)>教育培训
								<#elseif ("medical" == product.type)>寻医问诊
								<#elseif ("gift" == product.type)>烟酒礼品
								<#else><font color="#FF0000">非法的分类</font>
							</#if>
						</td>
						<td class="center">
							<#if (product.picture?? && "" != product.picture)>
								<img src="./upload/category_${product.picture!}" width="80" height="60" />
							</#if>
						</td>
						<td class="left">
							<a href="${product.productId!}.html" target="_blank">
								${product.name!}
							</a>
							<br />
							(点击量:<span class="font_fff">${product.hit!}</span>)
							<#if (0 < product.counts!0)>
								<span class="font_red">(限量抢购:${product.counts!})</span>
							</#if>
							${product.endTime?string("yyyy-MM-dd")}
						</td>
						<td class="left">
							${product.price?string.currency} - ${product.offPrice?string.currency} = ${product.economize?string.currency}
							<br />
							${product.offPrice?string.currency} / ${product.price?string.currency} = ${product.discount!}
							<br />
							${product.memberPrice?string.currency}
						</td>
						<td class="center">
							<#if (0 == product.status)>普通商品
								<#elseif (1 == product.status)>推荐
								<#elseif (2 == product.status)>公告
								<#elseif (3 == product.status)>团购
								<#elseif (4 == product.status)>精品滚动
								<#elseif (5 == product.status)>体验卡
							</#if>
						</td>
						<td class="center">
							<@s.a href="?obj=${obj}&amp;cmd=edit&amp;product.productId=${product.productId}"><@s.text name="system.update" /></@s.a>&nbsp;
							<@s.a href="?cmd=del&amp;product.productId=${product.productId}" onclick="return confirm('%{getText('system.delete.confirm')}');"><@s.text name="system.delete" /></@s.a>
						</td>
					</tr>
				</#list>
  			</tbody>
  		</table>
        
        <#if productList?? && 0 != productList?size>
            <@s.div id="pager">
                <#include "../include/Pager.ftl">
            </@s.div>
        </#if>
	</body>
</html>
