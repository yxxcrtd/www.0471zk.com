// Copyright 2012
// Author: Yang XinXin


$(function() {
	// 商品名称的最大值限制
	$("#name, #address").maxlength({
		maxCharacters: 50
	});
	
	// 商品使用说明的最大值限制
	$("#instruction").maxlength({
		maxCharacters: 165
	});
	
	// 商品商家简介的最大值限制
	$("#introduce").maxlength({
		maxCharacters: 300
	});
	
	// 商品图片
	var pictureNode = $("#picture");
	
	// 优惠券
	var printNode = $("#print");
	
	// 原价
	var priceNode = $("#price");
	var priceTipNode = $("#priceTip");
	
	// 现价
	var offPriceNode = $("#offPrice");
	var offPriceTipNode = $("#offPriceTip");
	
	// 会员价
	var memberPriceNode = $("#memberPrice");
	
	// 商品名称
	var nameNode = $("#name");
	
	// 商品名称后面的提示
	var nameTipNode = $("#nameTip");
	
	// 商品使用地址
	var addressNode = $("#address");
	
	// 商品使用地址后面的提示
	var addressTipNode = $("#addressTip");
	
	// 去除商品名称前后的空格
	nameNode.bind("blur", function() {
		$(this).val($.trim($(this).val()));
		nameTipNode.html("＊").css("color", "#FF0000");
	});
	
	nameNode.bind("focus", function() {
		nameTipNode.html("");
	});
	
	// 去除商品名称前后的空格
	addressNode.bind("blur", function() {
		$(this).val($.trim($(this).val()));
		addressTipNode.html("＊").css("color", "#FF0000");
	});
	
	addressNode.bind("focus", function() {
		addressTipNode.html("");
	});
	
	nameTipNode.html("＊").css("color", "#FF0000");
	priceTipNode.html("＊").css("color", "#FF0000");
	offPriceTipNode.html("＊").css("color", "#FF0000");
	addressTipNode.html("＊").css("color", "#FF0000");

	// 商品原价的  '键盘按下'和'失去焦点' 事件
	priceNode.keypress(function(event) {
		// 兼容IE和Firefox获得keyBoardEvent对象
		event = (event) ? event : ((window.event) ? window.event : "");
		// 兼容IE和Firefox获得keyBoardEvent对象的键值
		var key = event.keyCode?event.keyCode:event.which;
		// alert(key); Backspace=8
		// 同时按下了Ctrl和回车键：event.ctrlKey
		if(key < 48 || key > 57) {
			if(key == 46 && !/\./.test($(this).val())) {
				var currentVal = $(this).val();
				if(!isNaN(parseInt(currentVal))) {
					$(this).val(currentVal + ".");
				} else {
					$(this).val("0.");
				}
			}
			event.preventDefault();
		}
	}).blur(function() {
		var the_Val = parseFloat($(this).val());
		if(!isNaN(the_Val)) {
			if(!/\./.test($(this).val())) {
				$(this).val(the_Val + ".00");
			} else {
				$(this).val(the_Val.toFixed(2));
			}
		}
	});
	
	// 商品现价的  '键盘按下'和'失去焦点' 事件
	offPriceNode.keypress(function(event) {
		// 兼容IE和Firefox获得keyBoardEvent对象
		event = (event) ? event : ((window.event) ? window.event : "");
		// 兼容IE和Firefox获得keyBoardEvent对象的键值
		var key = event.keyCode?event.keyCode:event.which;
		// alert(key); Backspace=8
		// 同时按下了Ctrl和回车键：event.ctrlKey
		if(key < 48 || key > 57) {
			if(key == 46 && !/\./.test($(this).val())) {
				var currentVal = $(this).val();
				if(!isNaN(parseInt(currentVal))) {
					$(this).val(currentVal + ".");
				} else {
					$(this).val("0.");
				}
			}
			event.preventDefault();
		}
	}).blur(function() {
		var the_Val = parseFloat($(this).val());
		if(!isNaN(the_Val)) {
			if(!/\./.test($(this).val())) {
				$(this).val(the_Val + ".00");
			} else {
				$(this).val(the_Val.toFixed(2));
			}
		}
		
		// 判断现价不能大于原价
		var price_val = parseFloat(priceNode.val());
		var now_val = parseFloat($(this).val());
//		console.info("原价:" + price_val);
//		console.info("现价:" + now_val);
		if(!isNaN(now_val)) {
			if (now_val > price_val) {
				alert("现价不能大于原价！");
				$(this).focus();
				$(this).select();
				return;
			}
		}
	});

	// 商品会员价的  '键盘按下'和'失去焦点' 事件
	memberPriceNode.keypress(function(event) {
		// 兼容IE和Firefox获得keyBoardEvent对象
		event = (event) ? event : ((window.event) ? window.event : "");
		// 兼容IE和Firefox获得keyBoardEvent对象的键值
		var key = event.keyCode?event.keyCode:event.which;
		// alert(key); Backspace=8
		// 同时按下了Ctrl和回车键：event.ctrlKey
		if(key < 48 || key > 57) {
			if(key == 46 && !/\./.test($(this).val())) {
				var currentVal = $(this).val();
				if(!isNaN(parseInt(currentVal))) {
					$(this).val(currentVal + ".");
				} else {
					$(this).val("0.");
				}
			}
			event.preventDefault();
		}
	}).blur(function() {
		var the_Val = parseFloat($(this).val());
		if(!isNaN(the_Val)) {
			if(!/\./.test($(this).val())) {
				$(this).val(the_Val + ".00");
			} else {
				$(this).val(the_Val.toFixed(2));
			}
		}
	});
	
	
	// 表单提交
	$("form").submit(function(e) {
		// 验证有没有选择上传商品图片（TODO，两个问题：1，只能得到文件名，无法得到文件的全路径；2，即使验证了非法文件清理之后，在表单提交的时候还是能获取到刚选择的非法文件名）
		if ("" == pictureNode.val()) {
			alert("请选择商品图片！");
			pictureNode.focus();
			pictureNode.click();
			return false;
		}
		
		// 验证有没有选择上传优惠券
		if ("" == printNode.val()) {
			alert("请选择优惠券！");
			printNode.focus();
			printNode.click();
			return false;
		}
		
		var nameNodeValue = $.trim(nameNode.val());
		if ("" == nameNodeValue) {
			alert("商品名称不能为空！");
			nameNode.focus();
			return false;
		}
		
		var addressNodeValue = $.trim(addressNode.val());
		if ("" == addressNodeValue) {
			alert("商品使用地址不能为空！");
			addressNode.focus();
			return false;
		}
		
	    $("#product_submit").attr({disabled : "disabled", cursor : "progress"});
		$("#product_submit").val("数据提交中...").show();
	});
});


// 图片预览
function priview(obj, width, height, i) {
	// 图片的预览区
	var imgNode = $("#img");
	// 打印的预览区
	var voucherNode = $("#voucher");
	
	// 图片Id
	var pictureNode = $("#picture");
	// 优惠券Id
	var printNode = $("#print");
	
	// 验证图片格式
	if (!obj.value.match(/.jpg|.jpeg|.gif|.png|.bmp/i)) {
		alert("图片格式不正确！");

		// 设置为空的方法一
		if (0 == i) {
			// pictureNode.attr("value", ""); // 无法清理上传控件中的内容，弃用
			pictureNode.replaceWith(pictureNode.clone().val(""));
			imgNode.attr("src", "./images/bg_blank.gif").attr("width", 0).attr("height", 0);
			pictureNode.focus();
		}
		// 设置为空的方法二
		if (1 == i) {
			printNode.replaceWith(printNode.clone().val(""));
			voucherNode.attr("src", "./images/bg_blank.gif").attr("width", 0).attr("height", 0);
			printNode.focus();
		}
		return false;
	}
	
//	// 正则表达式的验证
//	var filter = /^(image\/bmp|image\/cis-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x-cmu-raster|image\/x-cmx|image\/x-icon|image\/x-portable-anymap|image\/x-portable-bitmap|image\/x-portable-graymap|image\/x-portable-pixmap|image\/x-rgb|image\/x-xbitmap|image\/x-xpixmap|image\/x-xwindowdump)$/i;
//	var pictureNodeObj = obj.files[0];
//	if (!filter.test(pictureNodeObj.type)) {
//		alert("图片格式不正确！！！");
//		return;
//	}
	
	// IE浏览器验证
	if ($.browser.msie) {
		// IE 6.0
		if (6.0 == $.browser.version) {
			// 设置图片预览区域的方法一
			if (0 == i) {
				imgNode.attr("src", obj.value).attr("width", width).attr("height", height);
			}
			// 设置图片预览区域的方法二
			if (1 == i) {
				voucherNode.attr({ src : obj.value, width : width, height : height });
			}
		} else { // TODO：IE 6.0+ 待验证！
			var objPreview = document.getElementById("preview");
			var objPreviewFake = document.getElementById("preview_fake");
			var objPreviewSizeFake = document.getElementById("preview_size_fake");
			obj.select();
			var imgSrc = document.selection.createRange().text;
			objPreviewFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;
			objPreviewSizeFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;
			autoSizePreview(objPreviewFake, objPreviewSizeFake.offsetWidth, objPreviewSizeFake.offsetHeight);
			objPreview.style.display = "none";
		}
	}
	// Mozilla Firefox
	if ($.browser.mozilla) {
		// 这个方法在 Firefox4.0以后，将getAsDataURL()方法去掉了。
		// imgNode.attr("src", obj.files[0].getAsDataURL()).attr("width", width).attr("height", height);
		
		// Firefox4.0+ 以后的方法
		reader = new FileReader();
		reader.onload = function(event) {
			// 设置图片预览区域的方法一
			if (0 == i) {
				imgNode.attr("src", event.target.result).attr("width", width).attr("height", height);
			}
			// 设置图片预览区域的方法二
			if (1 == i) {
				voucherNode.attr({ src : event.target.result, width : width, height : height });
			}
		};
		reader.readAsDataURL(obj.files[0]);
	}
}

