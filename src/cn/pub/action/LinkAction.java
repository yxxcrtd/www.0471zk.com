package cn.pub.action;

import java.util.Date;

import cn.pub.action.base.BasePublicAction;
import cn.pub.param.LinkQueryParam;
import cn.pub.pojos.Link;
import cn.pub.util.CommonUtil;

/**
 * 友情连接
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-04-23 20:08:27
 */
public class LinkAction extends BasePublicAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5864481004450277616L;

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		if ("edit".equals(cmd)) {
			return edit();
		} else if ("save".equals(cmd)) {
			return save();
		} else if ("del".equals(cmd)) {
			return del();
		} else {
			return list();
		}
	}
	
	/**
	 * 列表
	 * 
	 * @return
	 * @throws Exception
	 */
	private String list() throws Exception {
		LinkQueryParam param = new LinkQueryParam();
		if (null == k || "".equals(k) || k.length() == 0) {
			// Ignore
		} else {
			k = k.trim();
			param.k = k;
		}
		linkList = linkService.getLinkList(param, pager);
		return SUCCESS;
	}
	
	/**
	 * 添加或修改
	 * 
	 * @return
	 * @throws Exception
	 */
	private String edit() throws Exception {
		if (null == link) {
			link = new Link();
			link.setLinkId(0);
		} else {
			link = linkService.findById(link.getLinkId());
		}
		return EDIT_SUCCESS;
	}
	
	/**
	 * 保存
	 * 
	 * @return
	 * @throws Exception
	 */
	private String save() throws Exception {
		link.setModified(new Date());
		linkService.save(link);
		
		// 生成静态文件
		map.put("linkList", linkService.getLinkList());
		CommonUtil.generateHTML("WEB-INF/ftl/site", "Link.ftl", "link.html", map, servletContext);
		return list();
	}
	
	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	private String del() throws Exception {
		linkService.delete(link.getLinkId());
		return list();
	}

}
