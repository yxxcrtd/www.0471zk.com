<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
		<title>系统分类管理</title>
		<link rel="stylesheet" type="text/css" href="./css/manage.css" />
	</head>

	<body>
		<table id="table" cellspacing="1">
			<thead>
				<tr>
					<td colspan="3">
						<div id="form_title">系统分类树管理</div>
						<@s.actionerror />
					</td>
				</tr>
				<tr>
					<th width="20%">分类ID</th>
					<th width="40%" class="left">分类名称&nbsp;(子分类数)</th>
					<th width="40%" class="left">分类操作</th>
				</tr>
			</thead>
			<tbody>
				<#if (0 == categoryList?size)>
					<tr>
						<td colspan="3" class="tip">
							<#if category??>对不起，[${category.name!?html}] 没有子分类！</#if>
						</td>
					</tr>
				</#if>
				
				<#list categoryList as category>
					<tr>
						<td class="center">
							${category.categoryId}
						</td>
						<td class="left">
							<a href="?cmd=list&amp;parentId=${category.categoryId}">${category.name!}</a>
							<#if (0 < category.number)>
								(${category.number})
							</#if>
						</td>
						<td class="left">
							<a href="?cmd=add&amp;type=${category.type!}&amp;parentId=${category.categoryId}">添加子分类</a>&nbsp;&nbsp;
							<a href="?cmd=edit&amp;categoryId=${category.categoryId}">修改</a>&nbsp;&nbsp;
							<#if (0 == category.number)>
								<a href="?cmd=del&amp;categoryId=${category.categoryId}" onclick="return confirm('确定要删除分类 [${category.name!?js_string}] 吗？\n\n警告：分类删除后不可恢复，并且该分类下的所有商品都将失去分类！');">删除</a>
							</#if>
						</td>
					</tr>
				</#list>
			</tbody>
		</table>
		
		<form name="addSubmitForm" action="?" method="get" style="display:none">
			<input type="hidden" name="cmd" value="add" />
			<input type="hidden" name="type" value="<#if category??>${category.type!}</#if>" />
			<input type="hidden" name="parentId" value="${parentId!}" />
		</form>
		
		<div class="funcButton">
			
			<#if category??>
				<input type="button" class="btn" value="添加分类" onclick="document.addSubmitForm.submit();" />
				<#--
					<#if (0 == categoryList?size)>
					<#else><input type="button" class="btn" value="分类排序" onclick="cateOrder();" />
					</#if>
				-->
				<input type="button" class="btn" value="返回上级分类" onclick="document.backParentForm.submit();" />
				<input type="button" class="btn" value="返回根分类" onclick="document.backRootForm.submit();" />

				<#-- 返回上级分类的表单 -->
				<form name="backParentForm" action="?" method="get" style="display:none">
					<input type="hidden" name="cmd" value="list" />
					<input type="hidden" name="parentId" value="${category.parentId!}" />
				</form>
				<#-- 返回根分类的表单 -->
				<form name="backRootForm" action="?" method="get" style="display:none">
					<input type="hidden" name="cmd" value="list" />
				</form>
			</#if>
		</div>
		
		<#--
		<form name="setOrderForm" action="category.actoin" method="post" style="display:none">
			<input type="hidden" name="cmd" value="order" />
			<input type="hidden" name="type" value="${type!}" />
			<input type="hidden" name="parentId" value="${parentId!}" />
		</form>
		<script language="javascript">
		function cateOrder() {
			document.setOrderForm.submit();
		}
		</script>
		-->
	</body>
</html>



<dl>
	<dt></dt>
	<dd>
		<script type="text/javascript" src="./js/tree2.js"></script>
		<link rel="styleSheet" type="text/css" href="./css/tree.css" />
		<script type="text/javascript">
		<!--
			d = new dTree("d");
			d.add(0, -1, "<b>系统分类树</b>", "#");
			<#if categoryTree??>
				<#list categoryTree.all as c>
					<#if c.parentId??>
						d.add(${c.id}, ${c.parentId}, "${c.name}<#if (c.itemNum > 0)>(${c.itemNum})</#if>", "category.action?cmd=list&amp;parentId=${c.parentId}");
					<#else>
						d.add(${c.id}, 0, "${c.name}<#if (c.itemNum > 0)>(${c.itemNum})</#if>", "category.action?cmd=list");
					</#if>
				</#list>
			</#if>
			document.write(d);
			d.openAll();
		//-->
		</script>
	</dd>
</dl>

