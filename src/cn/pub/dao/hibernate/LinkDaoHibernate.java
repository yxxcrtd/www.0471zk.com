package cn.pub.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pub.dao.LinkDao;
import cn.pub.param.LinkQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.pojos.Link;
import cn.pub.util.Pager;

/**
 * 友情连接DAO的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-04-23 20:05:53
 */
@SuppressWarnings("unchecked")
public class LinkDaoHibernate extends HibernateDaoSupport implements LinkDao {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.LinkDao#findById(int)
	 */
	@Override
	public Link findById(int id) {
		return (Link) this.getHibernateTemplate().get(Link.class, id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.LinkDao#getLinkList(cn.pub.param.LinkQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<Link> getLinkList(LinkQueryParam param, Pager pager) {
		QueryHelper query = param.createQuery(false);
		if (null == pager) {
			return query.queryData(this.getHibernateTemplate(), -1, param.count);
		} else {
			return query.queryDataAndTotalCount(this.getHibernateTemplate(), pager);
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.LinkDao#getLinkList()
	 */
	@Override
	public List<Link> getLinkList() {
		return this.getHibernateTemplate().find("FROM Link ORDER BY modified DESC");
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.LinkDao#findLinkByNameAndUrl(java.lang.String, java.lang.String)
	 */
	@Override
	public Link findLinkByNameAndUrl(String name, String url) {
		List<Link> list = this.getHibernateTemplate().find("FROM Link WHERE name = ? AND url = ?", new Object[] { name, url });
		return (null != list && list.size() > 0) ? (Link) list.get(0) : null;
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.LinkDao#saveOrUpdateLink(cn.pub.pojos.Link)
	 */
	@Override
	public void saveOrUpdateLink(Link link) {
		this.getHibernateTemplate().saveOrUpdate(link);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.LinkDao#delete(cn.pub.pojos.Link)
	 */
	@Override
	public void delete(Link link) {
		this.getHibernateTemplate().delete(link);
	}

}
