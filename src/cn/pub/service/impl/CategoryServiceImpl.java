package cn.pub.service.impl;

import java.util.List;

import cn.pub.model.CategoryTreeModel;
import cn.pub.pojos.Category;
import cn.pub.service.CategoryService;
import cn.pub.service.impl.base.BaseServiceImpl;

/**
 * 系统分类服务的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-07 20:11:51
 */
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.CategoryService#findById(int)
	 */
	@Override
	public Category findById(int id) {
		return categoryDao.findById(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.CategoryService#getChildCategories(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Category> getChildCategories(String type, Integer parentId) {
		return categoryDao.getChildCategories(type, parentId);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.CategoryService#getCategoryTree(java.lang.String)
	 */
	@Override
	public CategoryTreeModel getCategoryTree(String type) {
		List<Category> categoryList = categoryDao.getCategoryList(type);
		
		CategoryTreeModel tree = CategoryTreeModel.createTree(type, categoryList.iterator());
		return tree;
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.CategoryService#createCategory(java.lang.Integer, cn.pub.pojos.Category)
	 */
	@Override
	public void createCategory(Integer parentId, Category category) {
		Category parentCategory = categoryDao.findById(parentId);
		categoryDao.createCategory(parentId, category, parentCategory);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.CategoryService#updateCategory(cn.pub.pojos.Category)
	 */
	@Override
	public void updateCategory(Category category) {
		
		// 获取原始分类对象
		Category originCategory = categoryDao.findById(category.getCategoryId());
		categoryDao.evict(originCategory);
		
		// 设置一些不需要外部更新的属性
		setNotUpdateProperty(category, originCategory);
		
		categoryDao.updateCategory(category, originCategory);
		categoryDao.flush();
	}
	
	/**
	 * 
	 * 
	 * @param category
	 * @param originCategory
	 */
	private void setNotUpdateProperty(Category category, Category originCategory) {
		category.setType(originCategory.getType());
		category.setParentPath(originCategory.getParentPath());
		category.setNumber(originCategory.getNumber());
		//category.setOrderby(originCategory.getOrderby());
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.CategoryService#getChildrenCount(int)
	 */
	public int getChildrenCount(int categoryId) {
		return categoryDao.getChildrenCount(categoryId);
	}
	
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.CategoryService#deleteCategory(int)
	 */
	public void deleteCategory(int categoryId) {
		Category category = findById(categoryId);
		categoryDao.deleteCategory(category);
	}
	
}
