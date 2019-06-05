<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>返回的提示信息</title>
	</head>

	<body>
		<center>
			<div style="color: #00FF00; font-size: 26px; font-weight: bold; margin-top: 30px;">
				<#if actionMessages??>
					<#list actionMessages as message>
						<#if ("new_user" == message)>
							<@s.text name="system.info.new.user" />
						<#elseif ("invalidate" == message)>
							<@s.text name="system.info.invalidate" />
						<#else>
							<@s.text name="system.operate.ok" />
						</#if>
					</#list>
				</#if>
			</div>
			
			<div style="border: 1px solid #0F0; font-size: 14px; font-weight: bold; text-align: left; width: 75%; padding: 2px; margin-top: 12px;">
				<ul>
					<#if actionMessages??>
						<#list actionMessages as message>
							<#if ("user" == message)>
								<br />
								<li>
									<a href="user.action?cmd=edit">返回个人信息</a>
								</li>
								<br />
								<#if ("admin" == username)>
									<li>
										<a href="user.action">返回列表</a>
									</li>
								</#if>
							<#elseif ("product" == message)>
								<br />
								<li>
									<a href="product.action?cmd=edit">发布商品</a>
								</li>
								<br />
								<br />
								<li>
									<a href="product.action">商品管理</a>
								</li>
							<#elseif ("tuan" == message)>
								<br />
								<li>
									<a href="tuan.action?cmd=edit">发布团购</a>
								</li>
								<br />
								<br />
								<li>
									<a href="tuan.action">团购管理</a>
								</li>
							<#elseif ("updpwd" == message)>
								<br />
								<li>
									密码修改成功!
								</li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
		</center>
	</body>
</html>
