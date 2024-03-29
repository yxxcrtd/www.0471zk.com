package cn.pub.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.pub.pojos.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录拦截器
 *
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-06 00:56:50
 */
public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4341416242088283660L;

	/** 
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	/** 
	 * 用户 Session Key
	 */
	public static final String USER_SESSION_KEY = "user";
	
	/* (non-Javadoc)
	 *
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String returnUrl = (null == request.getParameter("cmd")) ? request.getRequestURL().toString() : request.getRequestURL() + "?cmd=" + request.getParameter("cmd");
		logger.info("登录拦截器的返回URL： " + returnUrl);
		
		Object action = actionInvocation.getAction();
		String actionName = action.getClass().getName().substring(14);
		logger.info("登录拦截器将拦截：" + actionName);
		
		// 商品的点击量和搜索不用登录
		if ("ProductAction".equals(actionName)) {
			if ("hit".equals(request.getParameter("cmd")) || "search".equals(request.getParameter("cmd"))) {
				return actionInvocation.invoke();
			}
		}
		
		// 1，先验证Session中有没有用户信息
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		session.put("returnUrl", returnUrl);
		
		if (null != session && null != session.get(USER_SESSION_KEY)) {
			User user = (User) session.get(USER_SESSION_KEY);
			logger.info("登录拦截器检测到Session中有用户信息，用户名：" + user.getUsername());
			return actionInvocation.invoke();
		}

		// 2，如果Session中都没有用户信息的话，即：用户未登录
		logger.info("没有登录/登录超时，返回登录页面！");
		return Action.LOGIN;
	}

}
