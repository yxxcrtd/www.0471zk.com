<div id="tuan_top"></div>
<div id="tuan_bottom">
	<div id="big" onmouseover="zhuan()" onmouseout="jixu()">
		<div id="con">
			<ul id="tags">
				<#if tuanList?? && 0 < tuanList?size>
					<#list tuanList as tuan>
						<li <#if (0 == tuan_index)>class="selectTag"</#if>>
							<a onmouseover="selectTag('tagContent${tuan_index}', this)" href="javascript:void(0)" title="${tuan.name!}">
								${tuan_index + 1}
							</a>
						</li>
					</#list>
				</#if>
			</ul>
			<div id="tagContent">
				<#if tuanList?? && 0 < tuanList?size>
					<#list tuanList as tuan>
						<div class="tagContent<#if (0 == tuan_index)> selectTag</#if>" id="tagContent${tuan_index}">
							<li>
								<a href="${tuan.url!}" target="_blank">
									<img src="./upload/${tuan.picture!}" width="200" height="150" alt="${tuan.name!}" title="${tuan.name!}" />
								</a>
								<div class="tuan_title">
									<a href="${tuan.url!}" title="${tuan.name!}" target="_blank">
										<#if (tuan.name!?length > 15)>
											${tuan.name[0..14]!}...
										<#else>
											${tuan.name!}
										</#if>										
									</a>
								</div>
								<div class="tuan_price">
									团购价：<span class="font_red">${tuan.offPrice?string.currency}&nbsp;元</span>&nbsp;&nbsp;
									折扣：<span class="font_red">${tuan.discount!}</span>&nbsp;折
								</div>
							</li>
						</div>
					</#list>
				</#if>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" language="javascript">
<!--
	var obig = document.getElementById("big");
	function selectTag(showContent, selfObj) {
		var tag = document.getElementById("tags").getElementsByTagName("li");
		var taglength = tag.length;
		for(i = 0; i < taglength; i++) {
			tag[i].className = "";
		}
		selfObj.parentNode.className = "selectTag";
		for(i = 0; j = document.getElementById("tagContent" + i); i++) {
			j.style.display = "none";
		}
		document.getElementById(showContent).style.display = "block";
	}

	var x = 0;
	function scrollTag() {
		var tags = document.getElementById("tags").getElementsByTagName("a");
		if (x < (${tuanList?size} - 1)) {
			x = x + 1;
		} else {
			x = 0;
		}
		var tag = document.getElementById("tags").getElementsByTagName("li");
		var taglength = tag.length;
		for(i = 0; i < taglength; i++) {
			tag[i].className = "";
		}
		tags[x].parentNode.className = "selectTag";
		for(i = 0; j = document.getElementById("tagContent" + i); i++) {
			j.style.display = "none";
		}
		document.getElementById("tagContent" + x).style.display = "block";
	}
	var scrolll = setInterval(scrollTag, 3000);
	function zhuan() {
		clearInterval(scrolll);
	}
	function jixu() {
		scrolll = setInterval(scrollTag, 3000);
	}
//-->
</script>
