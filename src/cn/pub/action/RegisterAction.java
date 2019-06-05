package cn.pub.action;

import cn.pub.action.base.BaseUserAction;

/**
 * 注册
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-05-26 06:36:35
 */
public class RegisterAction extends BaseUserAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6992829175766125538L;

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		
		// 1，检验验证码
		if (!isValidVerifyCode(sessionVerifyCode, user.getVerifyCode())) {
			return INPUT;
		}
		
		// 2，验证用户名是否合法
		if (isValidLoginName(user.getUsername().trim().toLowerCase())) {
			this.addActionError(this.getText("system.register.username.invalid"));
			return INPUT;
		}
		
		// 3，验证用户名是否重复
		if (isUserExist(user.getUsername())) {
			this.addActionError(this.getText("system.register.username.is.exist"));
			return INPUT;
		}
		
		// 4，验证Email是否重复
		if (isUserExist(user.getEmail())) {
			this.addActionError(this.getText("system.register.email.is.exist"));
			return INPUT;
		}
		
		// 5，保存用户信息
		registerUser(user);
		
		// 6，往客户端写 Cookie
		writeCookieIntoClient();
		
		// 7，在服务器端写 Session
		writeSessionInServer();
		
		// 8，返回
		return SUCCESS;
	}

}
