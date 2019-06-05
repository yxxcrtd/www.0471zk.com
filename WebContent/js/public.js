// Copyright 2012
// Author: Yang XinXin


var timeoutId;
$(function() {
	// 屏蔽右键
	$(document).bind("contextmenu", function(e) {
		return false;
	});

	// 用户名和密码
	var usernameNode = $("#username");
	var passwordNode = $("#password");
	
	// 登录成功的节点
	var login_successNode = $("#login_success");
	var login_success1 = "<span class='separator1'>|</span><a href='manage.action' target='_blank'>进入后台管理</a>";
	var login_success2 = "<span class='separator1'>|</span><a href='logout.action'>注销</a>";
	
	// 根据Cookie中的登录信息判断是否可以打印
	var printNode = $("#productId_right_instruction_main_print");
	var print1Node = $("#productId_right_instruction_main_print1");
	
	// 获取 Cookie
	var c_u = $.cookie("UserName");
	var c2 = $.cookie("UserId");
	// alert("c_u:" + c_u + "===c2:" + c2);
	
	// 只有两个 Cookie 都有值才显示欢迎信息，否则实现记住用户名的人性化操作
	if (c_u && c2) {
		$("#top_middel_login").hide();
		if (c2 > 1) {
			login_success1 = "";
		}
		login_successNode.html("<strong>欢 迎 您：<font color='#FF0000'>" + c_u + "</strong></font>" + login_success1 + login_success2).css("padding-top", "7px");
		
		// 显示打印
		printNode.show();
	} else {
		// 写 Cookie，设置其有效时间为 365 天
		$.cookie("UserName", c_u, {
			expires : 365,
			path : "/",
			domain : "0471zk.com"
		});
		
		// 让用户名节点显示 Cookie 中保存的用户名
		usernameNode.val(c_u);

		// 不显示打印
		printNode.hide();
		print1Node.html("只有登录用户才能打印优惠券！");
	}

	// 如果Cookie中有登录信息的话，就让密码框获得光标，否则使用户名的输入框 获得焦点
	if (0 < usernameNode.val().length) {
		passwordNode.focus();
	} else {
		usernameNode.focus();
	}
	
	// 显示热门搜索
	$("#top_middel_hot_search").load("./top_search.html");
	
	// 显示热门专题推荐
	var recommendNode = $("#recommend");
	recommendNode.load("./top_recommend.html");
	
	
//	// 首页最新的6个Flash滚动
//	var indexShowNode = $("#show");
//	indexShowNode.load("./index_show.html");
//	// 8个二级页面滚动
//	var houseShowNode = $("#house_show");
//	houseShowNode.load("./house_show.html");
//	var foodShowNode = $("#food_show");
//	foodShowNode.load("./food_show.html");
//	var funShowNode = $("#fun_show");
//	funShowNode.load("./fun_show.html");
//	var travelShowNode = $("#travel_show");
//	travelShowNode.load("./travel_show.html");
//	var celebrationShowNode = $("#celebration_show");
//	celebrationShowNode.load("./celebration_show.html");
//	var educationShowNode = $("#education_show");
//	educationShowNode.load("./education_show.html");
//	var medicalShowNode = $("#medical_show");
//	medicalShowNode.load("./medical_show.html");
//	var giftShowNode = $("#gift_show");
//	giftShowNode.load("./gift_show.html");
	
	// 限量抢购
	$("#limit").load("./index_limit.html");
	
	// 首页最新的5条公告
	var indexPlacardNode = $("#index_placard");
	indexPlacardNode.load("./index_placard.html");
	// 8个二级页面公告
	var housePlacardNode = $("#house_placard");
	housePlacardNode.load("./house_placard.html");
	var foodPlacardNode = $("#food_placard");
	foodPlacardNode.load("./food_placard.html");
	var funPlacardNode = $("#fun_placard");
	funPlacardNode.load("./fun_placard.html");
	var travelPlacardNode = $("#travel_placard");
	travelPlacardNode.load("./travel_placard.html");
	var celebrationPlacardNode = $("#celebration_placard");
	celebrationPlacardNode.load("./celebration_placard.html");
	var educationPlacardNode = $("#education_placard");
	educationPlacardNode.load("./education_placard.html");
	var medicalPlacardNode = $("#medical_placard");
	medicalPlacardNode.load("./medical_placard.html");
	var giftPlacardNode = $("#gift_placard");
	giftPlacardNode.load("./gift_placard.html");

	// 显示最新的8条案例
	var caseHouseNode = $("#case_house");
	caseHouseNode.load("./index_case_house.html");
	var caseFoodNode = $("#case_food");
	caseFoodNode.load("./index_case_food.html");
	var caseFunNode = $("#case_fun");
	caseFunNode.load("./index_case_fun.html");
	var caseTravelNode = $("#case_travel");
	caseTravelNode.load("./index_case_travel.html");
	var caseCelebrationNode = $("#case_celebration");
	caseCelebrationNode.load("./index_case_celebration.html");
	var caseEducationNode = $("#case_education");
	caseEducationNode.load("./index_case_education.html");
	var caseMedicalNode = $("#case_medical");
	caseMedicalNode.load("./index_case_medical.html");
	var caseGiftNode = $("#case_gift");
	caseGiftNode.load("./index_case_gift.html");
	
	// 所有分类
	// $("#category").load("./tree_category.html");
	
	// 显示团购
	$("#tuan").load("./index_tuan.html");
	
	// 显示体验卡
	$("#attempt").load("./index_attempt.html");
	
	// 显示热门排行榜
	var hitNode = $("#hit");
	hitNode.load("./hit.html");
	
	// 显示友情连接
	var linkNode = $("#link");
	linkNode.load("./link.html");
	
	// 显示最新的5条推荐
	var indexHouseNode = $("#index_house");
	indexHouseNode.load("./index_house.html");
	var indexFoodNode = $("#index_food");
	indexFoodNode.load("./index_food.html");
	var indexFunNode = $("#index_fun");
	indexFunNode.load("./index_fun.html");
	var indexTravelNode = $("#index_travel");
	indexTravelNode.load("./index_travel.html");
	var indexCelebrationNode = $("#index_celebration");
	indexCelebrationNode.load("./index_celebration.html");
	
	// 显示整站最新的5个推荐，不分类
	var indexBottomNode = $("#index_bottom");
	indexBottomNode.load("./index_bottom.html");

	// 8个二级页面底部的推荐
	var houseBottomNode = $("#house_bottom");
	houseBottomNode.load("./house_bottom.html");
	var foodBottomNode = $("#food_bottom");
	foodBottomNode.load("./food_bottom.html");
	var funBottomNode = $("#fun_bottom");
	funBottomNode.load("./fun_bottom.html");
	var travelBottomNode = $("#travel_bottom");
	travelBottomNode.load("./travel_bottom.html");
	var celebrationBottomNode = $("#celebration_bottom");
	celebrationBottomNode.load("./celebration_bottom.html");
	var educationBottomNode = $("#education_bottom");
	educationBottomNode.load("./education_bottom.html");
	var medicalBottomNode = $("#medical_bottom");
	medicalBottomNode.load("./medical_bottom.html");
	var giftBottomNode = $("#gift_bottom");
	giftBottomNode.load("./gift_bottom.html");
	
	// 单滑动门效果
	$("#case_top_right li").each(function(index) {
		// 有了index的值之后，就可以找到当前标签对应的内容区域
		$(this).mouseover(function() {
			var liNode = $(this);
			timeoutId = setTimeout(function() {
				// 将当前显示的区域隐藏
				$("div.contentin").removeClass("contentin").addClass("content");
				// 显示鼠标移上的区域
				$("div.content").eq(index).removeClass("content").addClass("contentin");
				$("#case_top_right li.tabin").removeClass("tabin");
				liNode.addClass("tabin");
			}, 300);
		}).mouseout(function() {
			clearTimeout(timeoutId);
		});
	});
	
	// 多滑动门效果
	$("#list_top_right li").each(function(index) {
		$(this).mouseover(function() {
			var liNode = $(this);
			timeoutId = setTimeout(function() {
				// 背景：因为在css样式表中定义了content1不可见，所以无法生成分页数
				// 实现：将style.css中的div.content1样式去掉（直接不用），虽然程序中定义，只是为了统一。
				// 方法：在原有的基础上，1，使用：.css("display", "none")就是将之前显示的内容隐藏；2，使用：.css("display", "block")就是将当前显示的内容块显示出来
				$("div.contentin1").removeClass("contentin1").addClass("content1").css("display", "none");
				$("div.content1").eq(index).removeClass("content1").css("display", "block").addClass("contentin1");
				$("#list_top_right li.tabin1").removeClass("tabin1");
				liNode.addClass("tabin1");
			}, 300);
		}).mouseout(function() {
			clearTimeout(timeoutId);
		});
	});

});
