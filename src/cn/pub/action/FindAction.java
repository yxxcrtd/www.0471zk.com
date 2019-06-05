package cn.pub.action;

import cn.pub.action.base.BaseUserAction;

/**
 * Find Password
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-09-16 21:11:11
 */
public class FindAction extends BaseUserAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3418415877899931954L;

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		// 用户在页面上输入的E-Mail
		String email = user.getEmail();
		
		// 1，检验验证码
		if (!isValidVerifyCode(sessionVerifyCode, user.getVerifyCode())) {
			return INPUT;
		}
		
		// 2，根据用户名得到用户对象
		if (null == this.getUserByUsername(user.getUsername().trim())) {
			return INPUT;
		}
		
		// 3，验证用户的E-Mail
		if (!equalEmail(user.getEmail(), email)) {
			// 因为在返回的用户对象包括当前用户的Email，所以还是将用户输入的Email还给用户
			user.setEmail(email);
			return INPUT;
		}
		
		// 将返回的用户对象中的用户密码设为空
		user.setPassword("");
		
		// 4，返回
		return SUCCESS;
	}

}
