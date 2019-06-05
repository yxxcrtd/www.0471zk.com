package cn.pub.pojos;

import java.io.Serializable;

import cn.pub.util.CategoryHelper;

/**
 * 系统分类对象
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-17 00:29:27
 */
public class Category implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2726964904994153588L;

	/** 
	 * 分类Id
	 */
	private int categoryId;

	/** 
	 * 分类类型
	 */
	private String type;

	/** 
	 * 分类名称
	 */
	private String name;

	/** 
	 * 父分类Id
	 */
	private Integer parentId;

	/** 
	 * 父分类路径
	 */
	private String parentPath;

	/** 
	 * 子分类数量
	 */
	private int number;

	/** 
	 * 排列顺序
	 */
	private int orderby;

	/**
	 * Default Constructor
	 */
	public Category() {
		//
	}
	
	/**
	 * 获取分类的自己的路径 = parentPath + id（36进制） + "/"
	 * 
	 * @return
	 */
	public String getCategoryPath() {
		return this.parentPath + CategoryHelper.toPathString(this.categoryId) + "/";
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getOrderby() {
		return orderby;
	}

	public void setOrderby(int orderby) {
		this.orderby = orderby;
	}

}
