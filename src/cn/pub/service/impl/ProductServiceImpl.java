package cn.pub.service.impl;

import java.io.File;
import java.util.List;

import cn.pub.param.ProductQueryParam;
import cn.pub.pojos.Product;
import cn.pub.service.ProductService;
import cn.pub.service.impl.base.BaseServiceImpl;
import cn.pub.util.Pager;

/**
 * 信息服务的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-18 17:18:19
 */
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#findById(int)
	 */
	@Override
	public Product findById(int id) {
		return productDao.findById(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#getProductList(cn.pub.param.ProductQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<Product> getProductList(ProductQueryParam param, Pager pager) {
		return productDao.getProductList(param, pager);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#getProductList(cn.pub.param.ProductQueryParam, int)
	 */
	@Override
	public List<Product> getProductList(ProductQueryParam param, int num) {
		return productDao.getProductList(param, num);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#getInterrelatedProductList(int)
	 */
	@Override
	public List<Product> getInterrelatedProductList(int categoryId) {
		return productDao.getInterrelatedProductList(categoryId);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#getProductCategoryList(int)
	 */
	@Override
	public List<Product> getProductCategoryList(int categoryId) {
		return productDao.getProductCategoryList(categoryId);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#getProductList(int)
	 */
	@Override
	public List<Product> getProductList(int id) {
		return productDao.getProductList(id);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#saveOrUpdateProduct(cn.pub.pojos.Product)
	 */
	@Override
	public void saveOrUpdateProduct(Product product) {
		productDao.saveOrUpdateProduct(product);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#delete(int)
	 */
	@Override
	public void delete(int productId) {
		// 信息对象
		Product product = productDao.findById(productId);
		
		// 删除信息
		if (null != product) {
			productDao.delete(product);
			
			// 文件的物理连接
			String pictureAddress = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append(product.getPicture()).toString();		
			String category_pictureAddress = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append("category_").append(product.getPicture()).toString();		
			String case_pictureAddress = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append("case_").append(product.getPicture()).toString();		
			String recommend_pictureAddress = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append("recommend_").append(product.getPicture()).toString();		
			String show_pictureAddress = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append("show_").append(product.getPicture()).toString();		
			String index_pictureAddress = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append("index_").append(product.getPicture()).toString();		
			String product_pictureAddress = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append("product_").append(product.getPicture()).toString();		
			
			String voucherAddress = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append(product.getVoucher()).toString();		
			String voucher_Address = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append("voucher_").append(product.getVoucher()).toString();		

			// 删除物理文件
			new File(pictureAddress).delete();
			new File(category_pictureAddress).delete();
			new File(case_pictureAddress).delete();
			new File(recommend_pictureAddress).delete();
			new File(show_pictureAddress).delete();
			new File(index_pictureAddress).delete();
			new File(product_pictureAddress).delete();
			
			new File(voucherAddress).delete();
			new File(voucher_Address).delete();
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#increaseHit(int)
	 */
	@Override
	public void increaseHit(int productId) {
		productDao.increaseHit(productId);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.ProductService#decreaseCount(int)
	 */
	@Override
	public void decreaseCount(int productId) {
		productDao.decreaseCount(productId);
	}

}
