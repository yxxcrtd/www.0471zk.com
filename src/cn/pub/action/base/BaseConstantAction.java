package cn.pub.action.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.pub.util.Pager;
import cn.pub.util.ParamUtil;

import com.opensymphony.xwork2.ActionContext;

/**
 * 所有常量的基类
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-06 01:08:22
 */
public abstract class BaseConstantAction extends BaseAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8524525381349297121L;

	/**
	 * 日志
	 */
	protected static final Logger logger = LoggerFactory.getLogger(BaseConstantAction.class);
	
	/**
	 * 显示编辑页面
	 */
	protected static final String EDIT_SUCCESS = "Edit_Success";
	
	/**
	 * 显示保存后的页面
	 */
	protected static final String SAVE_SUCCESS = "Save_Success";
	
	/**
	 * 显示统一的提示信息页面
	 */	
	protected static final String TIP_INFO = "Tip_Info";
	
	/**
	 * 显示修改密码的页面
	 */
	protected static final String UPDPWD_SUCCESS = "UpdPwd_Success";
	
	/**
	 * Search Success
	 */
	protected static final String SEARCH_SUCCESS = "Search_Success";
	
	
	/**
	 * 用户名
	 */
	protected String username;

	/**
	 * 用户Id
	 */
	protected String userId;

	/**
	 * 获取参数辅助对象
	 */
	protected ParamUtil paramUtil;

	/**
	 * 命令参数
	 */
	protected String cmd;

	/**
	 * 查询关键字
	 */
	protected String k;

	/**
	 * 返回URL
	 */
	protected String returnUrl;
	
	/**
	 * 当用户请求验证码Servlet时，放入到Session中的验证码
	 */
	protected String sessionVerifyCode;

	/**
	 * 分页参数
	 */
	protected String p;

	/**
	 * 分页对象
	 */
	protected Pager pager = null;

	/**
	 * 对象
	 */
	protected String obj;
	
	/**
	 * 类型（可以作为：系统分类类型、......）
	 */
	protected String type;
	
	/**
	 * 系统父分类Id
	 */
	protected Integer parentId;

	/**
	 * 命令参数的get方法
	 * 
	 * @return
	 */
	public String getCmd() {
		return cmd;
	}

	/**
	 * 查询关键字的get方法（必须存在：查询之后的输入框必须有查询关键字）
	 * 
	 * @return
	 */
	public String getK() {
		return k;
	}

	/**
	 * 返回URL的get方法（没有get方法，则无法实现登录后的跳转）
	 * 
	 * @return
	 */
	public String getReturnUrl() {
		return returnUrl;
	}

	/**
	 * 分页参数的get方法（必须存在：负责显示切换的分页数）
	 * 
	 * @return
	 */
	public String getP() {
		return p;
	}

	/**
	 * 分页参数的set方法（必须存在：没有则没有效果）
	 * 
	 * @param p
	 */
	public void setP(String p) {
		this.p = p;
	}

	/**
	 * 分页对象的get方法（必须存在：显示用）
	 * 
	 * @return
	 */
	public Pager getPager() {
		return pager;
	}

	/**
	 * 对象的get方法
	 * 
	 * @return
	 */
	public String getObj() {
		return obj;
	}
	
	/**
	 * 类型的get方法
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 系统父分类Id的get方法
	 * 
	 * @return
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 未知的命令
	 * 
	 * @param cmd
	 * @return
	 */
	protected String unknownCommand(String cmd) {
		super.addActionError("不支持的命令：" + cmd);
		return ERROR;
	}

	/**
	 * 得到 Action 上下文对象
	 * 
	 * @return
	 */
	public ActionContext getActionContext() {
		return ActionContext.getContext();
	}

}
