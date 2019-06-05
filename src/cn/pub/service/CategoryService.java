package cn.pub.service;

import java.util.List;

import cn.pub.model.CategoryTreeModel;
import cn.pub.pojos.Category;

/**
 * 系统分类服务
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-07 20:03:22
 */
public interface CategoryService {
	
	/**
	 * 根据 分类Id 得到 分类对象
	 * 
	 * @param id
	 * @return
	 */
	public Category findById(int id);
	
	/**
	 * 得到指定类型、指定分类标识的所有子分类
	 * 
	 * @param type 分类类型
	 * @param parentId 父分类Id，如果为：null，表示根分类
	 * @return 返回分类对象列表
	 */
	public List<Category> getChildCategories(String type, Integer parentId);
	
	/**
	 * 得到指定系统分类类型的分类树
	 * 
	 * @param type
	 * @return
	 */
	public CategoryTreeModel getCategoryTree(String type);
	
	/**
	 * 创建分类
	 * 
	 * @param category
	 */
	public void createCategory(Integer parentId, Category category);
	
	/**
	 * 修改 / 移动 分类
	 * 
	 * @param category
	 */
	public void updateCategory(Category category);
	
	/**
	 * 得到指定标识的分类的子分类数量
	 * 
	 * @param categoryId
	 * @return
	 */
	public int getChildrenCount(int categoryId);
	
	/**
	 * 删除分类
	 * 
	 * @param categoryId
	 */
	public void deleteCategory(int categoryId);
	
}
