package cn.pub.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pub.dao.UserDao;
import cn.pub.param.UserQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.pojos.User;
import cn.pub.util.Pager;

/**
 * 用户DAO的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-07 20:20:05
 */
@SuppressWarnings("unchecked")
public class UserDaoHibernate extends HibernateDaoSupport implements UserDao {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.UserDao#findById(int)
	 */
	@Override
	public User findById(int id) {
		return (User) this.getHibernateTemplate().get(User.class, id);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.UserDao#getUserByQueryString(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUserByQueryString(String queryString, String value) {
		List<User> list = this.getHibernateTemplate().find("FROM User WHERE (" + queryString + " = ?)", value);
		return (null != list && list.size() > 0) ? (User) list.get(0) : null;
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.UserDao#getUserList(cn.pub.param.UserQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<User> getUserList(UserQueryParam param, Pager pager) {
		QueryHelper queryHelper = param.createQuery(false);
		if (null == pager) {
			return queryHelper.queryData(this.getHibernateTemplate(), -1, param.count);
		} else {
			return queryHelper.queryDataAndTotalCount(this.getHibernateTemplate(), pager);
		}
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.dao.UserDao#saveOrUpdate(cn.pub.pojos.User)
	 */
	@Override
	public void saveOrUpdate(User user) {
		this.getHibernateTemplate().saveOrUpdate(user);
	}

}
