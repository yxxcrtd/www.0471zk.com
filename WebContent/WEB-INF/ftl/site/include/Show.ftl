<script language="javascript">
<!--
	linkarr = new Array();
	picarr = new Array();
	textarr = new Array();
	var focus_width = 471;
	var focus_height = 263;
	var text_height = 0;
	var pics = "";
	var links = "";
	var texts = "";
	var swf_height = focus_height + text_height;
	var defJpeg = "./upload/1.jpg";
	
	<#if indexShowList?? && 0 < indexShowList?size>
		<#list indexShowList as show>
			linkarr[${show_index + 1}] = "${show.productId!}.html";
			picarr[${show_index + 1}] = "./upload/index_${show.picture!}";
			textarr[${show_index + 1}] = "${show.name!}";
		</#list>
	</#if>
	
	for(i = 1; i < picarr.length; i++) {
		if (pics == "")
			pics = picarr[i];
		else
			pics += "|" + picarr[i];
	}
	
	for (i = 1; i < linkarr.length; i++) {
		if (links == "")
			links = linkarr[i];
		else
			links += "|" + linkarr[i];
	}
	
	for (i = 1; i < textarr.length; i++) {
		if (texts == "")
			texts = textarr[i];
		else
			texts += "|" + textarr[i];
	}
	document.write('<object type="application/x-shockwave-flash" data="./images/flash/slide.swf" width="' + focus_width + '" height="' + swf_height + '">');
	document.write('<param name="movie" value="./images/flash/slide.swf" />');
	document.write('<param name="allowScriptAcess" value="sameDomain" />');
	document.write('<param name="quality" value="best" />');
	document.write('<param name="bgcolor" value="#EEEEEE" />');
	document.write('<param name="scale" value="noScale" />');
	document.write('<param name="menu" value="false">');
	document.write('<param name="wmode" value="opaque" />');
	document.write('<param name="FlashVars" value="playerMode=embedded&pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'" />');
	document.write('</object>');
-->
</script>