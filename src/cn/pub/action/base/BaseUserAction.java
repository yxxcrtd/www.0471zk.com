package cn.pub.action.base;

import javax.servlet.http.Cookie;

import cn.pub.interceptor.LoginInterceptor;
import cn.pub.pojos.User;
import cn.pub.util.CommonUtil;
import cn.pub.util.MD5;

/**
 * 用户基类
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-06 02:20:17
 */
public abstract class BaseUserAction extends BasePublicAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -654683625831953582L;
	
	/**
	 * Cookie 失效时间为：两周  = 14天 * 24小时 * 60分钟 * 60秒
	 */
	private static final int INT_COOKIE_ABATE_TIME_NEGATIVE = 14 * 24 * 60 * 60;
	
	/**
	 * 关闭浏览器即失效
	 */
	private static final int INT_COOKIE_ABATE_IN_MEMORY = -1;
	
	/**
	 * Cookie 失效时间为：0，表示：立即销毁 Cookie
	 */
	private static final int INT_COOKIE_ABATE_TIME_ZERO = 0;
	
	/**
	 * 用户Id（用户管理中修改和删除用户的Id）
	 */
	protected int uid;
	
	/**
	 * 用户Id的set方法（用户管理中修改和删除用户的Id）
	 * 
	 * @param uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * 检验验证码是否相同
	 * 
	 * @param sessionVerifyCode Session中的验证码
	 * @param verifyCode 用户页面中输入的验证码
	 * @return
	 */
	protected Boolean isValidVerifyCode(String sessionVerifyCode, String verifyCode) {
		logger.info("Session中的验证码：" + sessionVerifyCode);
		logger.info("用户输入的验证码：" + verifyCode);

		// 比较
		if (CommonUtil.stringEqualsIgnoreCase(sessionVerifyCode, verifyCode)) {
			return true;
		} else {
			this.addActionError(this.getText("system.login.verifyCode.incorrect"));
			return false;
		}
	}

	/**
	 * 根据用户名用户对象
	 * 
	 * @param queryString
	 * @return
	 */
	protected User getUserByUsername(String queryString) {
		logger.info("用户输入的用户名：" + queryString);
		
		// 获取用户对象
		user = userService.getUserByQueryString(queryString);
		
		logger.info("用户对象：" + user);
		
		// 如果对象为空，显示通用的提示信息(用户不存在！)
		if (null == user) {
			this.addActionError(this.getText("system.login.username.not.exist"));
		}
		return user;
	}

	/**
	 * 验证密码是否相等
	 *
	 * @param dbPassword 数据库中的MD5密码
	 * @param inputPassword 用户页面中输入的密码
	 * @return
	 */
	protected Boolean equalPassword(String dbPassword, String inputPassword) {
		if (CommonUtil.stringEquals(dbPassword, MD5.toMD5(inputPassword))) {
			return true;
		} else {
			// 密码错误，显示通用的提示信息(请输入正确的用户名和密码！)
			this.addActionError(this.getText("system.login.password.incorrect"));
			return false;
		}
	}
	
	/**
	 * 验证E-Mail是否相等
	 *
	 * @param dbEmail 数据库中的E-Mail
	 * @param inputEMail 用户页面中输入的E-Mail
	 * @return
	 */
	protected Boolean equalEmail(String dbEmail, String inputEMail) {
		if (CommonUtil.stringEquals(dbEmail, inputEMail)) {
			return true;
		} else {
			this.addActionError(this.getText("system.find.email.incorrect"));
			return false;
		}
	}	
	
	/**
	 * 重置用户密码
	 * 
	 * @param u 当前用户对象
	 * @param inputPassword 用户页面中输入的新密码
	 */
	protected void resetPassword(User u, String inputPassword) {
		u.setPassword(MD5.toMD5(inputPassword));
		userService.saveOrUpdate(u);
	}

	/**
	 * 验证登录名的合法性
	 * 
	 * @param loginName
	 * @return
	 */
	protected static boolean isValidLoginName(String string) {
		// 禁用的关键字，以后放到系统配置项中
		if ("webmaster".equalsIgnoreCase(string)
				|| "administrator".equalsIgnoreCase(string)
				|| "fuckyou".equalsIgnoreCase(string)
				|| "garbage".equalsIgnoreCase(string)
				|| "stupid".equalsIgnoreCase(string)
				|| "dammit".equalsIgnoreCase(string)) {
			return true;
		}

		// 合法性检测
		if (CommonUtil.isValidName(string) == false) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证用户名/邮件地址是否重复
	 * 
	 * @param queryString
	 * @return
	 */
	protected boolean isUserExist(String queryString) {
		if (null != userService.getUserByQueryString(queryString)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 保存用户注册信息
	 * 
	 * @param user
	 */
	protected void registerUser(User user) {
		user.setUsername(user.getUsername().trim().toLowerCase());
		user.setPassword(MD5.toMD5(user.getPassword()));
		userService.saveOrUpdate(user);
	}
	
	/**
	 * 往客户端写 Cookie
	 */
	protected void writeCookieIntoClient() {
		Cookie cookie = new Cookie("UserName", user.getUsername());
		String domain = getDomain(request.getServerName());
		logger.info("登录时的域名：" + domain);
		
		// 设置Session失效时间为：两周
		cookie.setMaxAge(INT_COOKIE_ABATE_TIME_NEGATIVE);
		
		// 设置第二个 Cookie ，是为了人性化地显示用户曾经登录过本站，让两个 Cookie 失效时间不同，关闭浏览器即失效一个
		Cookie c2 = new Cookie("UserId", String.valueOf(user.getUserId()));
		c2.setMaxAge(INT_COOKIE_ABATE_IN_MEMORY);
		
		// 域名为：空(localhost) || IP(包括:127.0.0.1) || com.cn，都不设置(&& !"com.cn".equals(domain))
		if (!"".equals(domain) && !Character.isDigit(domain.charAt(0))) {
			cookie.setDomain(domain);
			c2.setDomain(domain);
		}
		cookie.setPath("/");
		c2.setPath("/");
		
		logger.info("往客户端写的UserCookie的值：" + cookie.getValue());
		response.addCookie(cookie);
		response.addCookie(c2);
	}
	
	/**
	 * 获取域名（URL为：localhost/所有的IP地址(包括:127.0.0.1)/长度为2的(www.com,www.cn)直接返回：空）
	 * 
	 * @param domain
	 * @return
	 */
	private String getDomain(String url) {
		// 最后返回的域名
		String returnDomain = "";
		
		// 默认是IP地址
		Boolean isIP = true;
		
		// URL是否包含'.'，不包含基本可以肯定是：localhost
		if (url.contains(".")) {
			// 创建一个临时数组
			String[] tempArray = url.split("\\.");
			
			// 依次解析后，只要包含字母，就认为是IP地址
			for (int i = 0; i < tempArray.length; i++) {
				try {
					logger.info("数组的第" + i + "个元素是：" + tempArray[i]);
					// 解析异常之后，即可判断是IP地址
					Integer.parseInt(tempArray[i]);
				} catch (NumberFormatException e) {
					isIP = false;
					break;
				}
			}
			
			// 是IP地址就返回：空
			if (isIP) {
				returnDomain = "";
			} else {
				logger.info("数组的长度：" + tempArray.length);
				switch (tempArray.length) {
				// 2位域名直接返回
				case 2:
					returnDomain = url;
//					logger.info("最后返回的域名：" + returnDomain);
					break;
				// 3位域名直接返回
//				case 3:
//					returnDomain = url;
//					logger.info("最后返回的域名：" + returnDomain);
//					break;
				default:
					// 去掉前面的二级域名
					returnDomain = url.substring(url.indexOf(".") + 1);
					break;
				}
			}
		} else {
			// 不包含点号直接返回：空
			returnDomain = "";
		}
		return returnDomain;
	}

	/**
	 * 销毁 Cookie
	 */
	protected void destroyCookies() {
		Cookie[] cookies = request.getCookies();
		try {
			if (null != cookies) {
				for (Cookie cookie : cookies) {
					if ("UserName".equals(cookie.getName())) {
						cookie.setMaxAge(INT_COOKIE_ABATE_TIME_ZERO);
						cookie.setPath("/");
						String domain = getDomain(request.getServerName());
						if (!"".equals(domain) && !Character.isDigit(domain.charAt(0))) {
							cookie.setDomain("." + domain);
						}
						response.addCookie(cookie);
					}
					if ("UserId".equals(cookie.getName())) {
						cookie.setMaxAge(INT_COOKIE_ABATE_TIME_ZERO);
						cookie.setPath("/");
						String domain = getDomain(request.getServerName());
						if (!"".equals(domain) && !Character.isDigit(domain.charAt(0))) {
							cookie.setDomain("." + domain);
						}
						response.addCookie(cookie);
					}
				
				}
			}
		} catch (Exception e) {
		}
	}
	
	/**
	 * 在服务器端写 Session
	 */
	protected void writeSessionInServer() {
		// 将用户对象放到登录拦截器中
		session.put(LoginInterceptor.USER_SESSION_KEY, user);
		session.put("username", user.getUsername());
		session.put("userId", String.valueOf(user.getUserId()));
	}
	
	/**
	 * 清理：Session
	 */
	protected void cleanSession() {
		session.put(LoginInterceptor.USER_SESSION_KEY, null);
		session.put("username", null);
		session.put("userId", null);
	}

}
