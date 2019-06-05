package cn.pub.dao.hibernate;

import java.util.List;

import cn.pub.dao.CategoryDao;
import cn.pub.dao.hibernate.extend.HibernateDaoSupportExtend;
import cn.pub.pojos.Category;
import cn.pub.util.CategoryHelper;
import cn.pub.util.CommonUtil;

/**
 * 系统分类DAO的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-28 11:27:18
 */
@SuppressWarnings("unchecked")
public class CategoryDaoHibernate extends HibernateDaoSupportExtend implements CategoryDao {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.CategoryDao#findById(int)
	 */
	@Override
	public Category findById(int id) {
		return (Category) this.getHibernateTemplate().get(Category.class, id);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.CategoryDao#getChildCategories(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Category> getChildCategories(String type, Integer parentId) {
		if (null == parentId) {
			return this.getHibernateTemplate().find("FROM Category WHERE parentId IS NULL ORDER BY orderby, categoryId");
		} else {
			return this.getHibernateTemplate().find("FROM Category WHERE parentId = ? ORDER BY orderby, categoryId", parentId);
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.CategoryDao#getCategoryList(java.lang.String)
	 */
	@Override
	public List<Category> getCategoryList(String type) {
		if ("".equals(type) || 0 == type.length()) {
			return this.getHibernateTemplate().find("FROM Category ORDER BY parentPath, orderby, categoryId");
		} else {
			return this.getHibernateTemplate().find("FROM Category WHERE type = ? ORDER BY parentPath, orderby, categoryId", type);
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.CategoryDao#createCategory(java.lang.Integer, cn.pub.pojos.Category, cn.pub.pojos.Category)
	 */
	@Override
	public void createCategory(Integer parentId, Category category, Category parentCategory) {
		category.setParentId(parentId);
		category.setParentPath(calculateParentPath(parentCategory));
		
		// 计算该分类在该层的排序值，2012-07-29修改，为了可以自定义排序值
		// category.setOrderby(nextOrderNumber(parentId, category.getType()));
		
		// 保存
		this.getHibernateTemplate().save(category);
		
		// 如果有父分类，更新父分类的子分类数量
		if (null != parentId) {
			updateParentChildCount(parentId);
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.CategoryDao#updateCategory(cn.pub.pojos.Category, cn.pub.pojos.Category)
	 */
	@Override
	public void updateCategory(Category category, Category originCategory) {
		// 仅仅是更新，没有移动操作
		if (CommonUtil.equals(category.getParentId(), originCategory.getParentId())) {
			this.getHibernateTemplate().update(category);
			
			// 程序运行到此，不必再执行下去
			return;
		}
		
		// 得到新分类
		Category newCategory = null;
		if (null != category.getParentId()) {
			newCategory = findById(category.getParentId());
			if (null != newCategory) {
				this.evict(newCategory);
			}
		}
		
		checkCanMove(category);
		
		// 计算新的父分类下的排序值
		int orderby = 1 + getLastOrderby(category.getType(), category.getParentId());
		String parentPath = CategoryHelper.calcCategoryPath(newCategory);
		
		// 更新子孙的parentPath
		updateAllChildrenParentPath(originCategory, parentPath);
		
		// 更新自己
		category.setOrderby(orderby);
		category.setParentPath(parentPath);
		category.setType(newCategory.getType());
		this.getHibernateTemplate().update(category);
		
		// 更新：原父分类子分类数量
		if (null != originCategory.getParentId()) {
			updateParentChildCount(originCategory.getParentId());
		}
		
		// 更新：新父分类子分类数量
		if (null != category.getParentId()) {
			updateParentChildCount(category.getParentId());
		}
	}
	
	/**
	 * 更新 category 之下所有子孙节点的 parentPath，前面部分替换为所给参数 parentPath
	 * 
	 * @param category
	 * @param parentpath
	 */
	private void updateAllChildrenParentPath(Category category, String parentPath) {
		// 示例: category = 12(/1/), 其子孙节点有  13(/1/C/), 14(/1/C), 15(/1/C/D/)
		// 新 parentPath = '/3/', 也即将 category 移动到新的父节点 3(/3/) 下面
		// 
		// 节点标识  原父路径   新父路径
		//  12	/1/		/3/
		//  13	/1/C/	/3/C/
		//  14	/1/C/	/3/C/
		//  15	/1/C/D/	/3/C/D/
		
		// 计算原 category 路径前缀 (如: /1/)
		String old_path = category.getParentPath();
		
		// 得到所有子孙节点.
		List<Object[]> all_child = internalGetAllChildren(category);
		for (Object[] o : all_child) {
			// o[0] 分类标识, o[1] 分类 parentPath
			Integer categoryId = (Integer)o[0];
			String path = (String)o[1];
			
			// 新路径 = '/3/' + '/1/C/'(去掉 '/1/') 部分. 
			String new_path = parentPath + path.substring(old_path.length());
			
			// 更新数据库.
			String hql = "UPDATE Category SET parentPath = ? WHERE categoryId = ?";
			getHibernateTemplateExtend().bulkUpdate(hql, new Object[]{new_path, categoryId});
		}
	}

	/**
	 * 得到指定分类的所有子孙分类
	 * 
	 * @param category
	 * @return 返回 List<Object[categoryId, parentPath]>
	 */
	private List<Object[]> internalGetAllChildren(Category category) {
		String like = category.getCategoryPath() + "%";
		String hql = "SELECT categoryId, parentPath FROM Category WHERE type = ? AND parentPath LIKE ?";
		return getHibernateTemplateExtend().find(hql, new Object[] { category.getType(), like });
	}
	
	private int getLastOrderby(String type, Integer parentId) {
		if (null == parentId) {
			String hql = "SELECT MAX(orderby) FROM Category WHERE parentId IS NULL AND type = ?";
			return this.getHibernateTemplateExtend().executeIntScalar(hql, type);
		} else {
			String hql = "SELECT MAX(orderby) FROM Category WHERE type = ? AND parentId = ?";
			return this.getHibernateTemplateExtend().executeIntScalar(hql, type, parentId);
		}
	}
	
	/**
	 * 检查是否可以将分类移动到它指定的父分类下
	 * 
	 * @param category
	 */
	private void checkCanMove(Category category) {
		// 不能作为系统根分类（有父分类Id，可以移动）
		if (null != category.getParentId()) {
			return;
		}
		
		// 不能将自己移动成为自己的子分类
		if (category.getCategoryId() == category.getParentId()) {
			throw new RuntimeException("不能将自己移动成为自己的子分类！");
		}
		
		// 遍历其所有分类，如果有一个是自己，则不能移动
		Integer tempParentId = category.getParentId();
		while (null != tempParentId) {
			if (tempParentId == category.getCategoryId()) {
				throw new RuntimeException("不能将自己移动成为自己的子分类！");
			}
			
			Category tempParentCategory = this.findById(tempParentId);
			if (null == tempParentCategory) {
				throw new RuntimeException("父分类不存在，可能数据库记录不合法或被改动！");
			}
			
			this.evict(tempParentCategory);
			
			// 继续验证父分类的父分类
			tempParentId = tempParentCategory.getParentId();
		}
	}
	
	/**
	 * 计算父分类的路径
	 * 
	 * @param category
	 * @return
	 */
	private static final String calculateParentPath(Category category) {
		return (category.getParentPath() + Integer.toString(category.getCategoryId(), 36) + "/").toUpperCase();
	}

	/**
	 * 计算指定分类类型下 一级分类的下一个排序号
	 * 
	 * @param item_type
	 * @return
	 */
//	private int nextOrderNumber(Integer parentId, String type) {
//		String hql = "SELECT MAX(orderby) FROM Category WHERE parentId = ? AND type = ?";
//		return 1 + getHibernateTemplateExtend().executeIntScalar(hql, new Object[] { parentId, type });
//	}
	
	/**
	 * 获取子分类的数量
	 * 
	 * @param categoryId
	 * @return
	 */
	public int getChildrenCount(int categoryId) {
		String hql = "SELECT COUNT(*) FROM Category WHERE parentId = ?";
		return getHibernateTemplateExtend().executeIntScalar(hql, categoryId);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.CategoryDao#deleteCategory(cn.pub.pojos.Category)
	 */
	@Override
	public void deleteCategory(Category category) {
		// 删除对象
		this.getHibernateTemplate().delete(category);
		
		// 如果有父分类，需要重新计算父分类下的子分类数量，并更新
		Integer parentId = category.getParentId();
		if (null != parentId) {
			updateParentChildCount(parentId);
		}
	}
	
	/**
	 * 重新计算指定父分类的子分类数量，并更新该数量
	 * 
	 * @param parentId
	 */
	private void updateParentChildCount(int parentId) {
		// 计算子分类数量
		int childNumber = getChildrenCount(parentId);
		
		// 更新父分类的子分类数量
		String update_hql = "UPDATE Category SET number = ? WHERE categoryId = ?";
		this.getHibernateTemplate().bulkUpdate(update_hql, new Object[] {childNumber, parentId} );
	}
	
}
