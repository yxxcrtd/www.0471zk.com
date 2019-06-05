<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="system.menu.dict" /><@s.text name="system.manage" /></title>
		<link rel="styleSheet" type="text/css" href="./css/public.css" />
        <link type="text/css" rel="styleSheet" href="./css/style.css" />
	</head>
	
	<body>
  		<@s.form action="dict">
  			<table class="table" cellSpacing="1">
				<thead>
					<tr>
						<td colspan="2">
							<div id="theader">
								<@s.text name="system.menu.dict.category.add" />
							</div>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr height="35">
	  					<td class="right" width="30%">
	  						<strong>
					  			<@s.label for="dictKey" value="%{getText('system.dict.key')}" />:
	  						</strong>
	  					</td>
	  					<td class="left">
				  			<@s.radio name="dict.dictKey" list=r"#{'tuan':'团购分类', 'pai':'品牌分类', 'tao':'导购分类', 'jing':'精品分类', 'quan':'优惠卷分类', 'status':'信息状态', 'area':'地区'}" />
				  			<span id="keyTip"></span>
	  					</td>
	  				</tr>
					<tr height="35">
	  					<td class="right">
	  						<strong>
					  			<@s.label for="dictValue" value="%{getText('system.dict.value')}" />:
	  						</strong>
	  					</td>
	  					<td class="left">
				  			<@s.textfield id="dictValue" cssClass="input" name="dict.dictValue" maxlength="10" onfocus="tip=setInterval(showValueTip, 500);" onblur="clearInterval(tip);" />
				  			<span id="valueTip"></span>
	  					</td>
	  				</tr>
					<tr height="50">
						<td class="center" colspan="2">
							<@s.hidden name="cmd" value="save" />
							<@s.submit id="dict_submit" cssClass="btn" value="%{getText('system.button.add')}" />
							<input class="btn" type="button" onClick="javascript:history.back();" value="<@s.text name="system.button.back" />" />
						</td>
					</tr>
	  			</tbody>
  			</table>
  		</@s.form>
        
        <script language="javaScript" src="./js/jquery.js"></script>
        <script language="javaScript" src="./js/public.js"></script>
        <script language="javaScript" src="./js/dictEdit.js"></script>
	</body>
</html>
