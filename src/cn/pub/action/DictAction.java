package cn.pub.action;

import cn.pub.action.base.BasePublicAction;
import cn.pub.param.DictQueryParam;
import cn.pub.pojos.Dict;

/**
 * 数据字典
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-17 00:43:15
 */
public class DictAction extends BasePublicAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3717490837901576066L;

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
		} else if ("update".equals(cmd)) {
			return update();
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
		DictQueryParam param = new DictQueryParam();
		if (null == k || "".equals(k) || k.length() == 0) {
			// Ignore
		} else {
			k = k.trim();
			param.k = k;
		}
		param.o = obj;
		dictList = dictService.getDictList(param, pager);
		return SUCCESS;
	}
	
	/**
	 * 添加或修改
	 * 
	 * @return
	 * @throws Exception
	 */
	private String edit() throws Exception {
		if (null == dict) {
			dict = new Dict();
			dict.setDictId(0);
		} else {
			dict = dictService.findById(dict.getDictId());
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
		obj = dict.getKey();
		dictService.save(dict);
		return list();
	}
	
	/**
	 * Ajax修改
	 * 
	 * @return
	 * @throws Exception
	 */
	private String update() throws Exception {
		return (dictService.update(dict));
	}
	
	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	private String del() throws Exception {
		dictService.delete(dict.getDictId());
		return list();
	}

}
