package cn.pub.action;

import cn.pub.action.base.BaseUserAction;

/**
 * 后台管理
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-15 23:03:35
 */
public class ManageAction extends BaseUserAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6598542521532036003L;

	@Override
	protected String execute(String cmd) throws Exception {
		return SUCCESS;
	}

	/**
	 * 菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String menu() throws Exception {
		return "menu";
	}

	/**
	 * 中间切换线
	 * 
	 * @return
	 * @throws Exception
	 */
	public String line() throws Exception {
		return "line";
	}
	
	/**
	 * Main
	 * 
	 * @return
	 * @throws Exception
	 */
	public String main() throws Exception {
		return "main";
	}
	
}
