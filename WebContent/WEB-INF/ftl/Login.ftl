<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.login" /></title>
		<link rel="styleSheet" type="text/css" href="./css/login.css" />
		<!--[if IE]>
		<style type="text/css">
		div {
			behavior: url(./css/ie-css3.htc);
			background: #FFF;
		}
		</style>
		<![endif]-->
	</head>

	<body>
		<table width="100%" height="100%">
			<tr>
				<td>&nbsp;</td>
				<td align="center" width="45%">
					<div>
						<@s.form action="login" name="loginForm">
							<table border="0">
								<tr>
									<td colspan="3" align="center" height="40">
										<h2>
											<@s.text name="system.user" /><@s.text name="system.login" />
										</h2>
										<@s.actionerror />
									</td>
								</tr>
								<tr>
									<td align="right" width="36%" height="40">
										<@s.label for="username" value="%{getText('system.username')}" />
									</td>
									<td>
										<@s.textfield id="username" name="user.username" />
									</td>
									<td>
										<@s.if test="'' == user.username">
											<@s.fielderror>
												<@s.param>user.username</@s.param>
											</@s.fielderror>
										</@s.if>
									</td>
								</tr>
								<tr>
									<td align="right" height="40">
										<@s.label for="password" value="%{getText('system.password')}" />
									</td>
									<td>
										<@s.password id="password" name="user.password" />
									</td>
									<td>
										<@s.if test="'' == user.password">
											<@s.fielderror>
												<@s.param>user.password</@s.param>
											</@s.fielderror>
										</@s.if>
									</td>
								</tr>
								<tr>
									<td colSpan="3" align="center" height="40">
										<@s.submit cssClass="btn" value="%{getText('system.button.login')}" />
										<@s.reset cssClass="btn" value="%{getText('system.button.reset')}" />
									</td>
								</tr>
							</table>
						</@s.form>
					</div>
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>
        <script language="javaScript" src="./js/jquery.js"></script>
        <script language="javaScript" src="./js/login.js"></script>
	</body>
</html>
