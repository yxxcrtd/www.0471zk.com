package cn.pub.action.base;

import java.util.List;

import cn.pub.param.ProductQueryParam;
import cn.pub.pojos.Category;
import cn.pub.pojos.Product;
import cn.pub.util.CommonUtil;

/**
 * 商品基类
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-18 15:58:58
 */
public abstract class BaseProductAction extends BaseUserAction {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6165488634493246569L;
	
	/**
	 * 生成静态文件
	 * 
	 * @throws Exception
	 */
	protected void generateHTML() throws Exception {
		logger.info("当前选择的分类是：" + type);
		map.put("type", type);
		
		// 1，生成首页最新的8条(不同分类)商品记录
		ProductQueryParam param1 = new ProductQueryParam();
		param1.o = type;
		map.put("newestProductList", productService.getProductList(param1, 8));
		CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Index_Case_Detail.ftl", "index_case_" + type + ".html", map, servletContext);
		logger.info(type + " 最新案例生成成功！");
		
		// 需要判断商品的status，根据其属性来生成相应的模块
		// 1，生成推荐
		if (1 == product.getStatus()) {
			ProductQueryParam param2 = new ProductQueryParam();
			param2.status = 1;
			param2.o = type;
			map.put("recommendList", productService.getProductList(param2, 5)); // 所有推荐都是5个
			
			// 1，首页5个推荐模块（只有：house, food, fun, travel, celebration）
			if ("house".equals(type) || "food".equals(type) || "fun".equals(type) || "travel".equals(type) || "celebration".equals(type)) {
				CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Index_Recommend.ftl", "index_" + type + ".html", map, servletContext);
				logger.info("首页的：" + type + " 推荐模块生成成功！");
			}
			
			// 生成所有二级页面的推荐
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Index_Bottom.ftl", type + "_bottom.html", map, servletContext);
			logger.info("二级页面的：" + type + " 推荐生成成功！");
			
			// 2，只要是推荐，都生成静态文件
			param2.o = null;
			map.put("recommendList", productService.getProductList(param2, 5));
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Index_Bottom.ftl", "index_bottom.html", map, servletContext);
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Top_Recommend.ftl", "top_recommend.html", map, servletContext);
			logger.info("首页的整站推荐(包括顶部的热门专题推荐)生成成功！");
		}
		
		// 2，生成公告
		if (2 == product.getStatus()) {
			// 首页公告
			ProductQueryParam param3 = new ProductQueryParam();
			param3.status = 2;
			map.put("indexPlacardList", productService.getProductList(param3, 5));
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Index_Placard.ftl", "index_placard.html", map, servletContext);
			logger.info("首页的5个最新公告生成成功！");
			
			// 二级页面公告
			ProductQueryParam param4 = new ProductQueryParam();
			param4.status = 2;
			param4.o = type;
			map.put("productPlacardList", productService.getProductList(param4, 10));
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Product_Placard.ftl", type + "_placard.html", map, servletContext);
			logger.info(type + " 二级页面的10个最新公告生成成功！");
		}
		
		// 3，限量抢购
		if (0 < product.getCounts()) {
			generateProductLimitHTML(product);
		}
		
		// 4，体验卡
		if (5 == product.getStatus()) {
			ProductQueryParam param = new ProductQueryParam();
			param.status = 5;
			map.put("indexAttemptList", productService.getProductList(param, 5));
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Index_Attempt.ftl", "index_attempt.html", map, servletContext);
			logger.info("首页的6个体验卡生成成功！");
		}
		
		// 5，生成滚动（因这两个滚动都不支持html的load，所以目前只能在不判断的情况下，添加或修改一个商品的时候都从数据库中取记录，没必要的效率损失）
//		if (4 == product.getStatus()) {
			// 生成首页最新的6个Flash滚动
			ProductQueryParam param5 = new ProductQueryParam();
			param5.status = 4;
			map.put("indexShowList", productService.getProductList(param5, 6));
			// CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Show.ftl", "index_show.html", map, servletContext);
			logger.info("首页的6个最新Flash滚动生成成功！");
			
			// 二级页面的5个滚动
			ProductQueryParam param6 = new ProductQueryParam();
			param6.status = 4;
			param6.o = type;
			map.put("productShowList", productService.getProductList(param6, 5));
			// CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Product_Scroll.ftl", type + "_show.html", map, servletContext);
			logger.info(type + " 二级页面的5个滚动生成成功！");
//		}
		
		logger.info("新增或修改的商品Id：" + product.getProductId());
		map.put("product", product);
		
		// 二级页面
		// 根据当前类型获得分类Id，并获得所有二级分类
		int parent_id = getCategoryId(type);
		List<Category> categoryList = categoryService.getChildCategories(type, parent_id);
		map.put("categoryList", categoryList);

		// 根据上面的二级分类的分类Id得到商品列表
		int i = 0;
		for (Category c : categoryList) {
			logger.info("当前二级分类的分类Id：" + c.getCategoryId());
			map.put("id", ++i);
			// 根据当前商品分类Id在分类表中的父分类Id，获取商品列表
			map.put("productList", productService.getProductList(c.getCategoryId()));
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Product_Case_Detail.ftl", type + "_case_" + c.getCategoryId() + ".html", map, servletContext);
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Product_List_Detail.ftl", type + "_list_" + c.getCategoryId() + ".html", map, servletContext);
			logger.info(type + " 二级页面的分类(" + c.getCategoryId() + ")商品列表生成成功！");
		}
		
		// 三级页面
		map.put("productId", product.getProductId()); // 在生成三级页面的时候，赋给productId值，为判断登录返回而使用
		map.put("interrelatedList", productService.getInterrelatedProductList(product.getCategory()));
		CommonUtil.generateHTML("WEB-INF/ftl/site", "ProductId.ftl", product.getProductId() + ".html", map, servletContext);
		logger.info("三级商品页面(Id:" + product.getProductId() + ")生成成功！");
		CommonUtil.generateHTML("WEB-INF/ftl/site", "Print.ftl", "iframes/iframe" + product.getProductId() + ".html", map, servletContext);
		logger.info("三级商品的打印页面(Id:" + product.getProductId() + ")生成成功！");
		
		// 在生成二级页面的时候，将productId设空，为判断登录返回而使用
		map.put("productId", "");
		CommonUtil.generateHTML("WEB-INF/ftl/site", "Product.ftl", type + ".html", map, servletContext);
		logger.info(type + " 二级页面生成成功！");
		
		// 生成分类
		map.put("category", categoryService.findById(product.getCategory()));
		map.put("productCategoryList", productService.getProductCategoryList(product.getCategory()));
		CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Product_Category.ftl", "c" + product.getCategory() + ".html", map, servletContext);
		logger.info("当前所属分类(Id:" + product.getCategory() + ")生成成功！");
		
		// 首页
		map.put("type", ""); // 将首页的type设置为空，为了区别当前页面菜单的显示颜色
		CommonUtil.generateHTML("WEB-INF/ftl/site", "Index.ftl", "index.html", map, servletContext);
		logger.info("网站首页生成成功！");
	}
	
	/**
	 * 系统约定的功能菜单的分类Id，暂不从数据库中读取。（在系统主菜单不变的情况下）
	 * 
	 * @param type
	 * @return
	 */
	private int getCategoryId(String type) {
		if ("house".equals(type)) {
			return 1;
		} else if ("food".equals(type)) {
			return 2;
		} else if ("fun".equals(type)) {
			return 3;
		} else if ("travel".equals(type)) {
			return 4;
		} else if ("celebration".equals(type)) {
			return 5;
		} else if ("education".equals(type)) {
			return 6;
		} else if ("medical".equals(type)) {
			return 7;
		} else if ("gift".equals(type)) {
			return 8;
		} else {
			return 0;
		}
	}
	
	/**
	 * 生成首页限量抢购模块
	 * 
	 * @param product
	 * @throws Exception
	 */
	protected void generateProductLimitHTML(Product product) throws Exception {
		ProductQueryParam param = new ProductQueryParam();
		param.count = product.getCounts();
		map.put("productLimitList", productService.getProductList(param, 1));
		CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Limit.ftl", "index_limit.html", map, servletContext);
		logger.info("首页的限量抢购生成成功！");
	}

}
