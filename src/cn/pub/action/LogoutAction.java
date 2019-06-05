package cn.pub.action;

import cn.pub.action.base.BaseUserAction;

/**
 * 注销
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-08 15:08:13
 */
public class LogoutAction extends BaseUserAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3293261024954638275L;

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		
		// 防止用户注销后到首页后点了后退按纽
		if (null != username) {
			logger.info("用户：" + username + " 注销 ...");

			// 1，销毁：Cookie
			destroyCookies();
			
			// 2，清理：Session
			cleanSession();
		}

		// 2，返回
		return SUCCESS;
	}

}
