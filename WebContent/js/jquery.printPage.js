// jQuery 页面打印插件
(function($) {
	$.fn.printPage = function(options) {
		var pluginOptions = {
			attr : "href",
			url : false,
			message : "正在为您启动打印机，请稍候 ..."
		};
		$.extend(pluginOptions, options);

		this.live("click", function() {
			PrintPgae.loadPrintDocument(this, pluginOptions);
			return false;
		});

		var PrintPgae = {
			loadPrintDocument : function(el, pluginOptions) {
				this.creatMsgBox(pluginOptions.message).appendTo(document.body);
				// For IE6
				if ($.browser.msie && parseFloat($.browser.version) < 7) {
					var $window = $(window);
					var controlTop = ($window.height() - $("#printMessageBox").height()) / 2 + $window.scrollTop();
					$("#printMessageBox").css("top", controlTop);
				}
				$("#printMessageBox").css("opacity", 0);
				$("#printMessageBox").animate({
					opacity : 1
				}, 300, function() {
					PrintPgae.addIframeToPage(el, pluginOptions);
				});
			},
			creatMsgBox : function(message) {
				return $("<div>", {
					id : "printMessageBox",
					html : pluginOptions.message
				});
			},
			iframe : function(url) {
				return '<iframe id="printPage" name="printPage" src=' + url + ' style="position: absolute; top: 0px; left: 0px; width: 0px; height: 0px; border: 0px; overfow: none; z-index: -1"></iframe>';
			},
			addIframeToPage : function(el, pluginOptions) {
				var url = pluginOptions.url ? pluginOptions.url : $(el).attr(
						pluginOptions.attr);
				if (!$("#printPage")[0]) {
					$("body").append(PrintPgae.iframe(url));
					$('#printPage').bind("load", function() {
						PrintPgae.printit();
					});
				} else {
					$('#printPage').attr("src", url);
				}
			},
			// 打印
			printit : function() {
				frames["printPage"].focus(); // For IE
				frames["printPage"].print();
				this.unloadMessage();
			},
			// 加载打印机，弹出打印效果，延迟1秒
			unloadMessage : function() {
				$("#printMessageBox").delay(1000).animate({
					opacity : 0
				}, 700, function() {
					$(this).remove();
				});
			}
		};
	};
})(jQuery);
