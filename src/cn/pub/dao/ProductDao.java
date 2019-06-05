package cn.pub.dao;

import java.util.List;

import cn.pub.param.ProductQueryParam;
import cn.pub.pojos.Product;
import cn.pub.util.Pager;

/**
 * 商品DAO
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-18 15:53:39
 */
public interface ProductDao {
	
	/**
	 * 根据主键标识获得对象
	 * 
	 * @param id
	 * @return
	 */
	public Product findById(int id);
	
	/**
	 * 得到带分页的商品列表
	 * 
	 * @param param
	 * @param pager
	 * @return
	 */
	public List<Product> getProductList(ProductQueryParam param, Pager pager);
	
	/**
	 * 商品列表
	 * 
	 * @param param
	 * @param num
	 * @return
	 */
	public List<Product> getProductList(ProductQueryParam param, int num);
	
	/**
	 * 根据当前商品的分类获取商品表中的所有该分类的商品
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<Product> getInterrelatedProductList(int categoryId);
	
	/**
	 * 获得所有该分类的商品列表
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<Product> getProductCategoryList(int categoryId);
	
	/**
	 * 根据当前商品分类Id在分类表中的父分类Id，获取商品列表
	 * 
	 * @param id
	 * @return
	 */
	public List<Product> getProductList(int id);
	
	/**
	 * 保存或修改商品对象
	 * 
	 * @param product
	 */
	public void saveOrUpdateProduct(Product product);
	
	/**
	 * 删除文件
	 * 
	 * @param product
	 */
	public void delete(Product product);
	
	/**
	 * 增加点击量
	 */
	public void increaseHit(int productId);
	
	/**
	 * 减少限购量
	 * 
	 * @param productId
	 */
	public void decreaseCount(int productId);
	
}
