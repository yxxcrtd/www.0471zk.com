package cn.pub.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pub.dao.TuanDao;
import cn.pub.param.TuanQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.pojos.Tuan;
import cn.pub.util.Pager;

/**
 * 团购DAO的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-18 15:58:59
 */
@SuppressWarnings("unchecked")
public class TuanDaoHibernate extends HibernateDaoSupport implements TuanDao {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.TuanDao#findById(int)
	 */
	@Override
	public Tuan findById(int id) {
		return (Tuan) this.getHibernateTemplate().get(Tuan.class, id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.TuanDao#getTuanList(cn.pub.param.TuanQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<Tuan> getTuanList(TuanQueryParam param, Pager pager) {
		QueryHelper query = param.createQuery(false);
		if (null == pager) {
			return query.queryData(this.getHibernateTemplate(), -1, param.count);
		} else {
			return query.queryDataAndTotalCount(this.getHibernateTemplate(), pager);
		}
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.TuanDao#getTuanList(cn.pub.param.TuanQueryParam, int)
	 */
	@Override
	public List<Tuan> getTuanList(TuanQueryParam param, int num) {
		QueryHelper query = param.createQuery(true);
		if (0 == num) {
			return query.queryData(this.getHibernateTemplate());
		} else {
			return query.queryData(this.getHibernateTemplate(), 0, num);
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.TuanDao#upsertTuan(cn.pub.pojos.Tuan)
	 */
	@Override
	public void upsertTuan(Tuan tuan) {
		this.getHibernateTemplate().saveOrUpdate(tuan);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.TuanDao#delete(cn.pub.pojos.Tuan)
	 */
	@Override
	public void delete(Tuan tuan) {
		this.getHibernateTemplate().delete(tuan);
	}

}
