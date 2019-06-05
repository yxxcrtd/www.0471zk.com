package cn.pub.dao.hibernate.extend;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 提供对 HibernateTemplate 的简单扩展 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-04-12 20:33:56
 */
@SuppressWarnings("rawtypes")
public class HibernateTemplateExtend extends HibernateTemplate {
	
	/**
	 * 构造函数	 * 
	 * @param sessionFactory
	 */
	public HibernateTemplateExtend(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	/**	 * 使用指定查询语句进行查询，并返回最多前 count 个结果
	 * @param queryString
	 * @param count
	 * @return
	 */
	public List findTopCount(String queryString, int count) {
		return find(queryString, (Object[])null, -1, count);
	}
	
	/**
	 * 使用指定查询语句进行查询，并返回最多前 count 个结果	 * @param queryString
	 * @param count
	 * @param params - 查询参数
	 * @return
	 */
	public List findTopCount(String queryString, int count, Object... params) {
		return find(queryString, params, -1, count);
	}

	/**
	 * 使用指定的查询语句，但只查询第一个对象	 * @param queryString
	 * @return
	 */
	public Object findFirst(String queryString) {
		List list = find(queryString, null, -1, 1);
		if (list == null || list.size() == 0) return null;
		return list.get(0);
	}

	/**
	 * 使用指定的查询语句，但只查询一个对象
	 * @param queryString
	 * @param param1 - 绑定的参数1 
	 * @return
	 */
	public Object findFirst(String queryString, Object param1) {
		List list = find(queryString, new Object[]{param1}, -1, 1);
		if (list == null || list.size() == 0) return null;
		return list.get(0);
	}

	/**
	 * 使用指定的查询语句，但只查询一个对象
	 * @param queryString
	 * @param param1 - 绑定的参数1 
	 * @param param2 - 绑定的参数2
	 * @return
	 */
	public Object findFirst(String queryString, Object param1, Object param2) {
		List list = find(queryString, new Object[]{param1, param2}, -1, 1);
		if (list == null || list.size() == 0) return null;
		return list.get(0);
	}

	/**
	 * 进行查询，并指定查询参数和从第几行获取、获取最多多少条	 * @param queryString
	 * @param values
	 * @param firstResult - 从第几条开始，-1 表示不设置此参数	 *    Set the first row to retrieve. If not set, rows will be retrieved beginnning from row 0
	 * @param maxResults - 最多获取多少，-1 表示不设置此参数	 *    Set the maximum number of rows to retrieve. If not set, there is no limit to the number of rows retrieved
	 * @return
	 * @throws DataAccessException
	 */
	
	public List find(final String queryString, final Object[] values, 
			final int firstResult, final int maxResults) throws DataAccessException {
		return (List) execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				if (firstResult != -1)
					queryObject.setFirstResult(firstResult);
				if (maxResults != -1)
					queryObject.setMaxResults(maxResults);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
					}
				}
				return queryObject.list();
			}
		}); //升级sping jar 包后，删除了第二个参数 true.原来是 (List) execute(xx, true)
	}

	/**
	 * 执行指定的查询语句，并返回期待的第一行第一列的数字值. 如果值为 null 或者不是数字，则返回 0
	 * @param queryString
	 * @return
	 */
	public int executeIntScalar(final String queryString) {
		Object o = scalar(this.find(queryString, null, -1, 1));
		return int_value(o);
	}
	
	/**
	 * 执行指定的查询语句，并返回期待的第一行第一列的数字值. 如果值为 null 或者不是数字，则返回 0	 * @param queryString
	 * @param value - 替代 ? 参数
	 * @return
	 */
	public int executeIntScalar(final String queryString, Object... params) {
		Object o = scalar(find(queryString, params, -1, 1));
		return int_value(o);
	}
	
	private static int int_value(Object o) {
		if (o == null) return 0;
		if (o instanceof Number) return ((Number)o).intValue();
		
		return 0;
	}
	
	private static Object scalar(List list) {
		if (list == null || list.size() == 0) return null;
		Object o = list.get(0);
		if (o instanceof Object[]) {
			Object[] array = (Object[])o;
			if (array == null || array.length == 0) return null;
			return array[0];
		} else
			return o;
	}
	
	/**
	 * 执行指定的查询语句，并返回期待的第一行第一列的字符串值. 如果不是字符串，则用 toString() 转为字符串
	 * 	 * @param queryString
	 * @return 可能返回 null
	 */
	public String executeScalar(final String queryString) {
		Object o = findFirst(queryString);
		if (o == null) return null;
		if (o instanceof String) return (String)o;
		return o.toString();
	}
	
}
