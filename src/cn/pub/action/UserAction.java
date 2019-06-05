package cn.pub.action;

import cn.pub.action.base.BaseUserAction;
import cn.pub.param.UserQueryParam;
import cn.pub.pojos.User;

/**
 * 用户管理
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-07 17:17:11
 */
public class UserAction extends BaseUserAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 974541381780839594L;

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
		} else if ("updpwd".equals(cmd)) {
			return updpwd();
		} else if ("valid".equals(cmd)) {
			return valid();
		} else if ("update".equals(cmd)) {
			return update();
		} else if ("del".equals(cmd)) {
			return delete();
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
		logger.info("当前操作用户信息的用户名：" + username);
		logger.info("当前操作用户信息的用户Id：" + userId);
		
		// 用户权限判断
		if ((!"admin".equals(username)) && (1 < Integer.valueOf(userId))) {
			return this.unknownCommand(cmd);
		}
		
		UserQueryParam param = new UserQueryParam();
		if (null == k || "".equals(k) || k.length() == 0) {
			// Ignore
		} else {
			k = k.trim();
			param.k = k;
		}
		userList = userService.getUserList(param, pager);
		return SUCCESS;
	}

	/**
	 * 编辑个人信息
	 * 
	 * @return
	 * @throws Exception
	 */
	private String edit() throws Exception {
		logger.info("当前修改用户信息的登录用户Id：" + userId);
		logger.info("当前修改用户信息的参数用户Id：" + uid);
		
		// 非系统管理员不能修改其他用户的个人信息
		if ((uid > 0) && (Integer.valueOf(userId) != uid)) {
			// 如果这两个Id不相等，则需要判断是不是系统管理员，否则就是有意修改别人信息！
			if ((!"admin".equals(username)) && (1 < Integer.valueOf(userId))) {
				// 解决的方法就是：将自己的登录用户Id 赋给：参数Id
				logger.info("用户Id为：" + userId + "的用户试图修改：" + uid + "的个人信息！");
				uid = Integer.valueOf(userId);
			}
		}
		
		user = userService.findById(uid == 0 ? Integer.valueOf(userId) : uid);
		
//		DictQueryParam param = new DictQueryParam();
//		param.o = "area";
//		dictList = dictService.getAreaOfDict(param);
		
		return EDIT_SUCCESS;
	}
	
	/**
	 * 保存
	 * 
	 * @return
	 * @throws Exception
	 */
	private String save() throws Exception {
		logger.info("当前保存用户信息的登录用户名：" + username);
		logger.info("当前保存用户信息的登录用户Id：" + userId);
		
		// 根据要修改的用户Id获取用户对象
		User u = userService.findById(user.getUserId());
		userService.saveOrUpdate(u);
		this.addActionMessage("user");
		return TIP_INFO;
	}
	
	/**
	 * 显示修改密码
	 * 
	 * @return
	 * @throws Exception
	 */
	private String updpwd() throws Exception {
		logger.info("显示修改密码的登录用户名：" + username);
		logger.info("显示修改密码的登录用户Id：" + userId);
		return UPDPWD_SUCCESS;
	}
	
	private String valid() throws Exception {
		logger.info("当前修改密码的登录用户名：" + username);
		logger.info("当前修改密码的登录用户Id：" + userId);
		
		// 根据Session中的userId获取用户对象
		User u = userService.findById(Integer.valueOf(userId));
		if (equalPassword(u.getPassword(), user.getPassword())) {
			out.print(SUCCESS);
		} else {
			out.print("");
		}
		out.flush();
		out.close();
		return NONE;
	}
	
	/**
	 * 修改密码
	 * 
	 * @return
	 * @throws Exception
	 */
	private String update() throws Exception {
		logger.info("当前修改密码的登录用户名：" + username);
		logger.info("当前修改密码的登录用户Id：" + userId);
		
		// 根据Session中的userId获取用户对象
		User u = userService.findById(Integer.valueOf(userId));
		resetPassword(u, user.getPassword());
		this.addActionMessage("updpwd");
		return TIP_INFO;
	}
	
	/**
	 * 删除用户（更改用户状态）
	 * 
	 * @return
	 * @throws Exception
	 */
	private String delete() throws Exception {
		logger.info("当前修改密码的登录用户名：" + username);
		logger.info("当前修改用户信息的登录用户Id：" + userId);
		logger.info("当前修改用户信息的参数用户Id：" + uid);
		
		// 只有系统管理员才能删除其他用户，但是管理员不能删除自己
		if (("admin".equals(username)) && (1 == Integer.valueOf(userId) && (1 < uid))) {
			user = userService.findById(uid);
			
			// 如果该用户已经是删除状态，则不用操作数据库
			if (9 != user.getRole()) {
				// 将用户状态设置为：已删除
				user.setRole(9);
				userService.saveOrUpdate(user);
			}
		}
		
		// 返回用户列表
		return list();
	}
	
}
