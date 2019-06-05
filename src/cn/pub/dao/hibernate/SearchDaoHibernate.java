package cn.pub.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pub.dao.SearchDao;
import cn.pub.param.SearchQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.pojos.Search;

/**
 * 搜索DAO的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-07 20:20:05
 */
@SuppressWarnings("unchecked")
public class SearchDaoHibernate extends HibernateDaoSupport implements SearchDao {

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.SearchDao#getSearchList(cn.pub.param.SearchQueryParam)
	 */
	@Override
	public List<Search> getSearchList(SearchQueryParam param) {
		QueryHelper query = param.createQuery(true);
		return query.queryData(this.getHibernateTemplate(), 0, 8);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.SearchDao#findByKeyword(java.lang.String)
	 */
	@Override
	public Search findByKeyword(String keyword) {
		List<Search> list = this.getHibernateTemplate().find("FROM Search WHERE keyword = ?", keyword);
		return (null != list && list.size() > 0) ? (Search) list.get(0) : null;
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.SearchDao#increaseCounts(int)
	 */
	@Override
	public void increaseCounts(int searchId) {
		this.getHibernateTemplate().bulkUpdate("UPDATE Search SET counts = counts + 1 WHERE searchId = ?", searchId);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.SearchDao#saveOrUpdate(cn.pub.pojos.Search)
	 */
	@Override
	public void saveOrUpdate(Search search) {
		this.getHibernateTemplate().saveOrUpdate(search);
	}

}
