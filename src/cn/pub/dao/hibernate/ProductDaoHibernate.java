package cn.pub.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pub.dao.ProductDao;
import cn.pub.param.ProductQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.pojos.Product;
import cn.pub.util.Pager;

/**
 * 商品DAO的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-18 15:58:59
 */
@SuppressWarnings("unchecked")
public class ProductDaoHibernate extends HibernateDaoSupport implements ProductDao {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.ProductDao#findById(int)
	 */
	@Override
	public Product findById(int id) {
		return (Product) this.getHibernateTemplate().get(Product.class, id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.ProductDao#getProductList(cn.pub.param.ProductQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<Product> getProductList(ProductQueryParam param, Pager pager) {
		QueryHelper query = param.createQuery(false);
		if (null == pager) {
			return query.queryData(this.getHibernateTemplate(), -1, param.count);
		} else {
			return query.queryDataAndTotalCount(this.getHibernateTemplate(), pager);
		}
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.ProductDao#getProductList(cn.pub.param.ProductQueryParam, int)
	 */
	@Override
	public List<Product> getProductList(ProductQueryParam param, int num) {
		QueryHelper query = param.createQuery(true);
		// 不限定数据记录数
		if (0 == num) {
			return query.queryData(this.getHibernateTemplate());
		} else {
			return query.queryData(this.getHibernateTemplate(), 0, num);
		}
	}
	
	@Override
	public List<Product> getInterrelatedProductList(int categoryId) {
		return this.getHibernateTemplate().find("FROM Product WHERE category = ? ORDER BY productId DESC", categoryId);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.ProductDao#getProductList(int)
	 */
	@Override
	public List<Product> getProductList(int id) {
		return this.getHibernateTemplate().find("FROM Product WHERE category IN (FROM Category WHERE parentId = ?) ORDER BY productId DESC", id);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.ProductDao#getProductCategoryList(int)
	 */
	@Override
	public List<Product> getProductCategoryList(int categoryId) {
		return this.getHibernateTemplate().find("FROM Product WHERE category = ? ORDER BY createDate DESC", categoryId);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.ProductDao#saveOrUpdateProduct(cn.pub.pojos.Product)
	 */
	@Override
	public void saveOrUpdateProduct(Product product) {
		this.getHibernateTemplate().saveOrUpdate(product);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.ProductDao#delete(cn.pub.pojos.Product)
	 */
	@Override
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.ProductDao#increaseHit(int)
	 */
	@Override
	public void increaseHit(int productId) {
		this.getHibernateTemplate().bulkUpdate("UPDATE Product SET hit = hit + 1 where productId = ?", productId);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.ProductDao#decreaseCount(int)
	 */
	@Override
	public void decreaseCount(int productId) {
		this.getHibernateTemplate().bulkUpdate("UPDATE Product SET counts = counts - 1 where productId = ?", productId);
	}

}
