package cn.pub.action.base;

import cn.pub.param.TuanQueryParam;
import cn.pub.util.CommonUtil;

/**
 * 团购基类
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-18 15:58:58
 */
public abstract class BaseTuanAction extends BaseUserAction {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 145966386293666568L;

	/**
	 * 生成静态文件
	 * 
	 * @throws Exception
	 */
	protected void generateHTML() throws Exception {
		TuanQueryParam param = new TuanQueryParam();
		map.put("tuanList", tuanService.getTuanList(param, 8));
		CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Index_Tuan.ftl", "index_tuan.html", map, servletContext);
		logger.info("首页团购模块生成成功！");
	}

}
