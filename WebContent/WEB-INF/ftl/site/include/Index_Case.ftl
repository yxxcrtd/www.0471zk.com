<div id="case">
	<div id="case_top">
		<div id="case_top_arrow">
			<img src="./images/bg_case_arrow.jpg" />
		</div>
		<div id="case_top_left">最新商家</div>
		<div id="case_top_right">
			<ul id="tab">
				<li class="tabin">家居建材</li>
				<li>餐饮美食</li>
				<li>休闲娱乐</li>
				<li>出行旅游</li>
				<li>庆典礼仪</li>
				<li>教育培训</li>
				<li>寻医问诊</li>
				<li>烟酒礼品</li>
			</ul>
		</div>
	</div>
	
	<div id="case_bottom">
		<#-- 分类循环 -->
		<#assign sequence = ["house", "food", "fun", "travel", "celebration", "education", "medical", "gift"]>
		<#list sequence as seq>
			<#-- 默认显示 -->
			<#if ("house" == seq)>
				<div class="contentin">
			<#else>
				<div class="content">
			</#if>
				<div class="gap_row"></div>
				<div id="case_${seq}"></div>
			</div>
		</#list>
	</div>
</div>