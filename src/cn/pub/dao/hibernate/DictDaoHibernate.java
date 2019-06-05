package cn.pub.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pub.dao.DictDao;
import cn.pub.param.DictQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.pojos.Dict;
import cn.pub.util.Pager;

/**
 * 数据字典DAO的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-17 00:39:03
 */
@SuppressWarnings("unchecked")
public class DictDaoHibernate extends HibernateDaoSupport implements DictDao {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.DictDao#findById(int)
	 */
	@Override
	public Dict findById(int id) {
		return (Dict) this.getHibernateTemplate().get(Dict.class, id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.DictDao#findDictByKeyAndValue(java.lang.String, java.lang.String)
	 */
	@Override
	public Dict findDictByKeyAndValue(String key, String value) {
		List<Dict> list = this.getHibernateTemplate().find("FROM Dict WHERE dictKey = ? AND dictValue = ?", new Object[] { key, value });
		return (null != list && list.size() > 0) ? (Dict) list.get(0) : null;
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.DictDao#saveOrUpdateDict(cn.pub.pojos.Dict)
	 */
	@Override
	public void saveOrUpdateDict(Dict dict) {
		this.getHibernateTemplate().saveOrUpdate(dict);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.DictDao#getDictList(cn.pub.param.DictQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<Dict> getDictList(DictQueryParam param, Pager pager) {
		QueryHelper query = param.createQuery(false);
		if (null == pager) {
			return query.queryData(this.getHibernateTemplate(), -1, param.count);
		} else {
			return query.queryDataAndTotalCount(this.getHibernateTemplate(), pager);
		}
	}
	
	public List<Dict> getAreaOfDict(DictQueryParam param) {
		QueryHelper query = param.createQuery(true);
		return query.queryData(this.getHibernateTemplate());
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.DictDao#getDictList(java.lang.String)
	 */
	@Override
	public List<Dict> getDictList(String dictKey) {
		return this.getHibernateTemplate().find("FROM Dict WHERE dictKey = ?", dictKey);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.DictDao#delete(cn.pub.pojos.Dict)
	 */
	@Override
	public void delete(Dict dict) {
		this.getHibernateTemplate().delete(dict);
	}

}
