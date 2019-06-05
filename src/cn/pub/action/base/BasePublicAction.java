package cn.pub.action.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.pub.model.CategoryTreeModel;
import cn.pub.pojos.Category;
import cn.pub.pojos.Dict;
import cn.pub.pojos.Link;
import cn.pub.pojos.Product;
import cn.pub.pojos.Search;
import cn.pub.pojos.Tuan;
import cn.pub.pojos.User;
import cn.pub.service.CategoryService;
import cn.pub.service.DictService;
import cn.pub.service.LinkService;
import cn.pub.service.ProductService;
import cn.pub.service.SearchService;
import cn.pub.service.SiteService;
import cn.pub.service.TuanService;
import cn.pub.service.UserService;

/**
 * 系统数据字典基类
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-17 01:07:17
 */
public abstract class BasePublicAction extends BaseAbstractAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 890851363800654759L;

	/**
	 * 用户对象
	 */
	protected User user;

	/**
	 * 系统分类对象
	 */
	protected Category category;
	
	/**
	 * 商品对象
	 */
	protected Product product;
	
	/**
	 * 数据字典对象
	 */
	protected Dict dict;
	
	/**
	 * 友情连接对象
	 */
	protected Link link;
	
	/**
	 * 团购对象
	 */
	protected Tuan tuan;
	
	/**
	 * 搜索对象
	 */
	protected Search search;
	

	/**
	 * 用户服务
	 */
	protected UserService userService;
	
	/**
	 * 系统分类服务
	 */
	protected CategoryService categoryService;

	/**
	 * 商品服务
	 */
	protected ProductService productService;
	
	/**
	 * 数据字典服务
	 */
	protected DictService dictService;
	
	/**
	 * 友情连接服务
	 */
	protected LinkService linkService;
	
	/**
	 * 站点服务
	 */
	protected SiteService siteService;
	
	/**
	 * 团购服务
	 */
	protected TuanService tuanService;
	
	/**
	 * 搜索服务
	 */
	protected SearchService searchService;
	
	
	/**
	 * 用户列表
	 */
	protected List<User> userList = new ArrayList<User>();

	/**
	 * 系统分类列表
	 */
	protected List<Category> categoryList = new ArrayList<Category>();
	
	/**
	 * 分类树
	 */
	protected CategoryTreeModel categoryTree;

	/**
	 * 商品列表
	 */
	protected List<Product> productList = new ArrayList<Product>();

	/**
	 * 数据字典列表
	 */
	protected List<Dict> dictList = new ArrayList<Dict>();
	
	/**
	 * 友情连接列表
	 */
	protected List<Link> linkList = new ArrayList<Link>();
	
	/**
	 * 团购列表
	 */
	protected List<Tuan> tuanList = new ArrayList<Tuan>();
	
	
	/**
	 * 系统分类Id
	 */
	protected Integer categoryId;

	/**
	 * 文件的 name （是<input type="file" name="file" ...>中的 name）
	 */
	protected List<File> file;

	/**
	 * 文件名（由属性 file + FileName 固定组成）
	 */
	protected List<String> fileFileName;

	/**
	 * 文件类型（由属性 file + ContentType 固定组成）
	 */
	protected List<String> fileContentType;

	
	/**
	 * 用户对象的get方法
	 * 
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户对象的set方法
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 系统分类对象的get方法
	 * 
	 * @return
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * 系统分类对象的set方法
	 * 
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * 商品对象的get方法
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * 团购对象的get方法
	 * 
	 * @return
	 */
	public Tuan getTuan() {
		return tuan;
	}

	/**
	 * 团购对象的set方法
	 * 
	 * @param tuan
	 */
	public void setTuan(Tuan tuan) {
		this.tuan = tuan;
	}

	/**
	 * 商品对象的set方法
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * 数据字典对象的get方法
	 * 
	 * @return
	 */
	public Dict getDict() {
		return dict;
	}

	/**
	 * 数据字典对象的set方法
	 * 
	 * @param dict
	 */
	public void setDict(Dict dict) {
		this.dict = dict;
	}

	/**
	 * 友情连接对象的get方法
	 * 
	 * @return
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * 友情连接对象的set方法
	 * 
	 * @param link
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * 用户列表的get方法
	 * 
	 * @return
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * 系统分类列表的get方法
	 * 
	 * @return
	 */
	public List<Category> getCategoryList() {
		return categoryList;
	}
	
	/**
	 * 分类树的get方法
	 * 
	 * @return
	 */
	public CategoryTreeModel getCategoryTree() {
		return categoryTree;
	}

	/**
	 * 商品列表的get方法
	 * 
	 * @return
	 */
	public List<Product> getProductList() {
		return productList;
	}
	
	/**
	 * 数据字典列表的get方法
	 * 
	 * @return
	 */
	public List<Dict> getDictList() {
		return dictList;
	}
	
	/**
	 * 友情连接列表的get方法
	 * 
	 * @return
	 */
	public List<Link> getLinkList() {
		return linkList;
	}

	/**
	 * 团购列表的get方法
	 * 
	 * @return
	 */
	public List<Tuan> getTuanList() {
		return tuanList;
	}

	
	/**
	 * 用户服务的set方法
	 * 
	 * @param userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 系统分类服务的set方法
	 * 
	 * @param categoryService
	 */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * 商品服务的set方法
	 * 
	 * @param productService
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * 数据字典服务的set方法
	 * 
	 * @param dictService
	 */
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}

	/**
	 * 友情连接服务的set方法
	 * 
	 * @param linkService
	 */
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}

	/**
	 * 站点服务的set方法
	 * 
	 * @param siteService
	 */
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	
	/**
	 * 团购服务的set方法
	 * 
	 * @param tuanService
	 */
	public void setTuanService(TuanService tuanService) {
		this.tuanService = tuanService;
	}

	/**
	 * 搜索服务的set方法
	 * 
	 * @param searchService
	 */
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	
	/**
	 * 文件流的get方法
	 * 
	 * @return
	 */
	public List<File> getFile() {
		return file;
	}

	/**
	 * 文件流的set方法
	 * 
	 * @param file
	 */
	public void setFile(List<File> file) {
		this.file = file;
	}

	/**
	 * 文件名的get方法
	 * 
	 * @return
	 */
	public List<String> getFileFileName() {
		return fileFileName;
	}

	/**
	 * 文件名的set方法
	 * 
	 * @param filedataFileName
	 */
	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	/**
	 * 文件类型的get方法
	 * 
	 * @return
	 */
	public List<String> getFileContentType() {
		return fileContentType;
	}

	/**
	 * 文件类型的set方法
	 * 
	 * @param filedataContentType
	 */
	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	/**
	 * 系统分类Id的get方法
	 * 
	 * @return
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * 系统分类Id的set方法
	 * 
	 * @param categoryId
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
