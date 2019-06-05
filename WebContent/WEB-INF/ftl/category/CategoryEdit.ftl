<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
		<title>编辑分类</title>
		<link rel="stylesheet" type="text/css" href="./css/manage.css" />
	</head>

	<body>
		<form action="?" method="post">
			<table id="table" cellspacing="1">
				<tr>
					<td colspan="2">
						<div id="form_title">
							<#if (0 == category.categoryId)>添加<#else>修改</#if>分类
						</div>
					</td>
				</tr>
				<tr>
					<td class="right height" width="35%">
						系统分类：
					</td>
					<td class="left height">
						<select name="category.parentId" >
							<#if (0 == category.parentId!0)>
								<option value="">根分类</option>
							<#else>
								<#list categoryTree.all as c>
									<option value="${c.categoryId}" ${(c.categoryId == (category.parentId!0))?string("selected", "")}>${c.treeFlag2} ${c.name!?html}</option>
								</#list>
							</#if>
						</select>
					</td>
				</tr>
				<tr>
					<td class="right height">
						分类名称：
					</td>
					<td class="left height">
						<input type="text" name="category.name" value="${category.name!?html}" />
					</td>
				</tr>
				<tr>
					<td class="right height">
						分类排序：
					</td>
					<td class="left height">
						<input type="text" name="category.orderby" value="${category.orderby!0}" />
					</td>
				</tr>
				<tr>
					<td class="center height" colspan="2">
						<input class="btn" type="submit" value="${(category.categoryId == 0)?string("添加分类", "修改/移动分类")}" />
						<input class="btn" type="button" value="取消返回" onclick="window.history.back()" />
					</td>
				</tr>
			</table>
			<input type="hidden" name="cmd" value="save" />
			<input type="hidden" name="category.type" value="${category.type!}" />
			<input type="hidden" name="category.categoryId" value="${category.categoryId!}" />
		</form>
	</body>
</html>
