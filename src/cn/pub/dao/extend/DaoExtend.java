package cn.pub.dao.extend;

/**
 * 通用 DAO 接口
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-28 16:18:18
 */
public interface DaoExtend {
	
	/**
	 * 删除 Hibernate session cache 中的所有对象
	 * 
	 * @param object
	 */
	public void evict(Object object);

	/**
	 * 从数据库清除所有在保存，修改和删除期间的对象
	 */
	public void flush();
	
}
