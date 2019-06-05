package cn.pub.action;

import cn.pub.action.base.BaseUserAction;

/**
 * 登录
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-06 02:29:28
 */
public class LoginAction extends BaseUserAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2319013258762710940L;

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		returnUrl = (String) session.get("returnUrl");
		logger.info("从 session 得到的 returnUrl：" + returnUrl);
		
		// 如果 session 中的值为空，就从隐藏域中获取
		if (null == returnUrl) {
			returnUrl = paramUtil.safeGetStringParam("returnUrl");
			logger.info("从登录隐藏域中获取的 returnUrl：" + returnUrl);
		}
		
		// 用户在页面中输入的密码
		String password = user.getPassword();
		
		// 1，根据用户名得到用户对象
		if (null == this.getUserByUsername(user.getUsername().trim())) {
			return INPUT;
		}
		
		// 2，验证用户密码
		if (!equalPassword(user.getPassword(), password)) {
			return INPUT;
		}
		
		// 3，往客户端写 Cookie
		writeCookieIntoClient();
		
		// 4，在服务器端写 Session
		writeSessionInServer();
		
		// 5，返回
		return SUCCESS;
	}

}
