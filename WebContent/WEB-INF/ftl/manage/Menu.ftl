<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="styleSheet" type="text/css" href="./css/menu.css" />
		<style type="text/css">
			li a {
				display: inline-block;
			}
			li a {
				display: block;
			}
		</style>
	</head>

	<body>
		<div id="welcome">
			<@s.text name="system.welcome" /><span id="info">${username!}</span>&nbsp;&nbsp;
			<@s.a href="logout.action">
				<@s.text name="system.logout" />
			</@s.a>
		</div>
		
		<ul id="menu" class="menu noaccordion expandfirst">
			<#if ("admin" == username)>
			
				<#-- 商品管理 -->
				<li>
					<a id="firstMenu" class="subMenu" href="javascript:void(0);">
						<@s.text name="system.product.list" />
					</a>
					<ul>
						<li>
							<a href="product.action?cmd=edit" target="mainFrame">
								<@s.text name="system.product.pub" />
							</a>
						</li>
						<li>
							<a href="product.action" target="mainFrame">
								<@s.text name="system.product.list" />
							</a>
						</li>
					</ul>
				</li>
			
				<#-- 团购管理 -->
				<li>
					<a class="subMenu" href="javascript:void(0);">
						<@s.text name="system.tuan.list" />
					</a>
					<ul>
						<li>
							<a href="tuan.action?cmd=edit" target="mainFrame">
								<@s.text name="system.tuan.pub" />
							</a>
						</li>
						<li>
							<a href="tuan.action" target="mainFrame">
								<@s.text name="system.tuan.list" />
							</a>
						</li>
					</ul>
				</li>
				
				<#-- 友情连接管理 -->
				<li>
					<a class="subMenu" href="javascript:void(0);">
						<@s.text name="system.menu.link" />
					</a>
					<ul>
						<li>
							<a href="link.action?cmd=edit" target="mainFrame">
								<@s.text name="system.menu.link.add" />
							</a>
						</li>
						<li>
							<a href="link.action" target="mainFrame">
								<@s.text name="system.menu.link.list" />
							</a>
						</li>
					</ul>
				</li>
				
				<#-- 数据字典 -->
				<li>
					<a class="subMenu" href="javascript:void(0);">
						<@s.text name="system.menu.dict" />
					</a>
					<ul>
						<li>
							<a href="dict.action?cmd=edit" target="mainFrame">
								<strong><@s.text name="system.menu.dict.category.add" /></strong>
							</a>
						</li>
						<li>
							<a href="dict.action?obj=tuan" target="mainFrame">
								<@s.text name="system.menu.dict.tuan.category" />
							</a>
						</li>
						<li>
							<a href="dict.action?obj=pai" target="mainFrame">
								<@s.text name="system.menu.dict.pai.category" />
							</a>
						</li>
						<li>
							<a href="dict.action?obj=tao" target="mainFrame">
								<@s.text name="system.menu.dict.tao.category" />
							</a>
						</li>
						<li>
							<a href="dict.action?obj=jing" target="mainFrame">
								<@s.text name="system.menu.dict.jing.category" />
							</a>
						</li>
						<li>
							<a href="dict.action?obj=quan" target="mainFrame">
								<@s.text name="system.menu.dict.quan.category" />
							</a>
						</li>
						<li>
							<a href="dict.action?obj=status" target="mainFrame">
								<@s.text name="system.menu.dict.status" />
							</a>
						</li>
						<li>
							<a href="dict.action?obj=area" target="mainFrame">
								<@s.text name="system.menu.dict.area" />
							</a>
						</li>
					</ul>
				</li>
				
				<#-- 系统管理 -->
				<li>
					<a class="subMenu" href="javascript:void(0);">
						<@s.text name="system.menu.manage" />
					</a>
					<ul>
						<li>
							<a href="category.action" target="mainFrame">
								<@s.text name="system.menu.category" />
							</a>
						</li>
						<li>
							<a href="user.action?cmd=updpwd" target="mainFrame">
								<@s.text name="system.menu.manage.updpwd" />
							</a>
						</li>
						<#if ("admin" == username)>
							<li>
								<a href="user.action" target="mainFrame">
									<@s.text name="system.menu.manage.user" />
								</a>
							</li>
						</#if>
					</ul>
				</li>
			</#if>
		</ul>
		<script type="text/javascript" src="./js/jquery.js"></script>
		<script type="text/javascript" src="./js/menu.js"></script>
	</body>
</html>
