package cn.pub.param.base;

/**
 * 查询参数的基类
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2009-06-16 18:19:09
 */
public abstract class BaseQueryParam {
	
	/** 
	 * 默认的记录数
	 */
	public int count;

	/** 
	 * 查询关键字 keyword
	 */
	public String k = null;
	
	/**
	 * 查询对象
	 */
	public String o = null;
	
	/**
	 * 用户Id的过滤
	 */
	public int userId;
	
	/**
	 * 商品状态的条件过滤
	 */
	public int status;
	
	/**
	 * 点击率
	 */
	public boolean hit;
	
}
