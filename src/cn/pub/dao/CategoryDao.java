package cn.pub.dao;

import java.util.List;

import cn.pub.dao.extend.DaoExtend;
import cn.pub.pojos.Category;

/**
 * 系统分类DAO
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-07 20:19:03
 */
public interface CategoryDao extends DaoExtend {
	
	/**
	 * 根据 分类Id 得到 分类对象
	 * 
	 * @param id
	 * @return
	 */
	public Category findById(int id);
	
	/**
	 * 
	 * 
	 * @param type
	 * @param parentId
	 * @return
	 */
	public List<Category> getChildCategories(String type, Integer parentId);
	
	/**
	 * 
	 * 
	 * @param type
	 * @return
	 */
	public List<Category> getCategoryList(String type);
	
	/**
	 * 
	 * 
	 * @param parentId
	 * @param category
	 * @param parentCategory
	 */
	public void createCategory(Integer parentId, Category category, Category parentCategory);
	
	/**
	 * 
	 * 
	 * @param category
	 * @param originCategory
	 */
	public void updateCategory(Category category, Category originCategory);
	
	/**
	 * 
	 * 
	 * @param categoryId
	 * @return
	 */
	public int getChildrenCount(int categoryId);
	
	/**
	 * 
	 * 
	 * @param category
	 */
	public void deleteCategory(Category category);

}
