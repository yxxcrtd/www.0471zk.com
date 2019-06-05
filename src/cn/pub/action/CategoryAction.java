package cn.pub.action;

import cn.pub.action.base.BasePublicAction;
import cn.pub.pojos.Category;
import cn.pub.util.CommonUtil;

/**
 * 系统分类树
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-17 00:43:15
 */
@SuppressWarnings("serial")
public class CategoryAction extends BasePublicAction {

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		if ("add".equals(cmd) || "edit".equals(cmd)) {
			return edit();
		} else if ("save".equals(cmd)) {
			return save();
		} else if ("del".equals(cmd)) {
			return del();
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

		// 分类列表
		categoryList = categoryService.getChildCategories(type, parentId);
		
		// 分类树(为了客户能够形象的看到系统分类树)
		categoryTree = categoryService.getCategoryTree(type);
		
		// 是否存在父分类对象
		if (null != parentId) {
			category = categoryService.findById(parentId);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 编辑
	 * 
	 * @return
	 * @throws Exception
	 */
	private String edit() throws Exception {
		// 将“添加”方法和“修改”方法合并到一起，仅仅用cmd参数做判断即可
		if ("add".equals(cmd)) {
			category = new Category();
			category.setType(type);
			category.setParentId(parentId);
		} else {
			if (null != categoryId) {
				category = categoryService.findById(categoryId);
				//category.setParentId(parentId);
			}
		}
		
		// 分类树(为了客户能够形象的看到系统分类树)
		categoryTree = categoryService.getCategoryTree(type);
		
		return EDIT_SUCCESS;
	}
	
	/**
	 * 保存
	 * 
	 * @return
	 * @throws Exception
	 */
	private String save() throws Exception {
		// 根据categoryId判断是新增还是修改
		if (0 == category.getCategoryId()) {
			categoryService.createCategory(category.getParentId(), category);
		} else {
			categoryService.updateCategory(category);
		}
		
		// 1，生成二级或三级分类的的静态页面
		categoryTree = categoryService.getCategoryTree(category.getType());
		map.put("categoryId", categoryTree.getRoot().get(0).getCategoryId());
		map.put("categoryTree", categoryTree);
		map.put("type", category.getType());
		CommonUtil.generateHTML("WEB-INF/ftl/site", "Category.ftl", "tree_" + category.getType() + ".html", map, servletContext);
		logger.info("生成二级或三级分类的静态页面！");
		
		// 2，生成首页分类的静态页面模块（只是样式有区别）
		CommonUtil.generateHTML("WEB-INF/ftl/site/include", "Index_Tree.ftl", "index_tree_" + category.getType() + ".html", map, servletContext);
		logger.info("生成首页分类的静态页面模块！");
		
		return list();
	}
	
	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	private String del() throws Exception {
		if (null != categoryId || !"".equals(categoryId)) {
			// 先要验证是否有子分类
			if (0 < categoryService.getChildrenCount(categoryId)) {
				this.addActionError("（" + categoryService.findById(categoryId).getName() + "）分类下面有子分类，不能删除！");
				return list();
			}
		
			// 删除当前分类对象
			categoryService.deleteCategory(categoryId);
		}
		// 返回列表
		return list();
	}

}
