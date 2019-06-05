package cn.pub.dao.hibernate.extend;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pub.dao.extend.DaoExtend;

/**
 * HibernateDaoSupport 扩展
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-04-12 19:23:37
 */
public class HibernateDaoSupportExtend extends HibernateDaoSupport implements DaoExtend {

	@Override
	protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplateExtend(sessionFactory);
	}

	/**
	 * 得到 HibernateTemplateExtend 对象，该对象提供了更多简易方法包装
	 * 
	 * @return
	 */
	public final HibernateTemplateExtend getHibernateTemplateExtend() {
		return (HibernateTemplateExtend) super.getHibernateTemplate();
	}

	@Override
	public void evict(Object object) {
		getHibernateTemplate().evict(object);
	}

	@Override
	public void flush() {
		getHibernateTemplate().flush();
	}

}
