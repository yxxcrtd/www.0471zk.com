package cn.pub.action;

import cn.pub.action.base.BaseUserAction;

/**
 * Reset Password
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-09-17 19:06:28
 */
public class ResetAction extends BaseUserAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2983110441879892386L;

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		
		// 用户在页面中输入的密码
		String password = user.getPassword();
		String email = user.getEmail();
		
		// 1，根据用户名得到用户对象
		if (null == this.getUserByUsername(user.getUsername().trim())) {
			return INPUT;
		}
		
		// 2，验证用户的E-Mail，防止用户从地址栏直接输入用户名来修改密码
		if (!equalEmail(user.getEmail(), email)) {
			return INPUT;
		}
		
		// 3，重置用户密码
		resetPassword(user, password);
		
		// 4，重置密码成功
		user = null;
		this.addActionError(this.getText("system.password.reset.success"));
		
		// 5，返回
		return SUCCESS;
	}

}
