package cn.pub.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.pub.action.base.BasePublicAction;
import cn.pub.param.ProductQueryParam;
import cn.pub.param.SearchQueryParam;
import cn.pub.util.CommonUtil;
import freemarker.template.TemplateException;

/**
 * 定时生成站点的静态HTML文件
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-18 19:38:07
 */
public class SiteAction extends BasePublicAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6211763690273554931L;

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		return NONE;
	}
	
	/**
	 * 定时任务
	 */
	public void doAuth() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 热门商品排行
		ProductQueryParam param = new ProductQueryParam();
		param.hit = true;
		map.put("hitProductList", productService.getProductList(param, 6));
		
		// 热门搜索排行
		SearchQueryParam param2 = new SearchQueryParam();
		map.put("hotSearchList", searchService.getSearchList(param2));
		
		try {
			// 1，热门排行榜
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Hit.ftl", "hit.html", map, servletContext);
			logger.info(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL", new Date()) + " - 热门排行榜生成成功！");
			
			// 2，热门搜索
			CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Top_Search.ftl", "top_search.html", map, servletContext);
			logger.info(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL", new Date()) + " - 热门搜索生成成功！");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
}
