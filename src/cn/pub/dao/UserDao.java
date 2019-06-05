package cn.pub.dao;

import java.util.List;

import cn.pub.param.UserQueryParam;
import cn.pub.pojos.User;
import cn.pub.util.Pager;

/**
 * 用户DAO
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-07 20:19:03
 */
public interface UserDao {
	
	/**
	 * 根据主键标识获得对象
	 * 
	 * @param id
	 * @return
	 */
	public User findById(int id);
	
	/**
	 * 根据查询字符串得到用户对象
	 *
	 * @param loginName
	 * @return
	 */
	public User getUserByQueryString(String queryString, String value);
	
	/**
	 * 得到带分页的用户列表
	 * 
	 * @param param
	 * @param pager
	 * @return
	 */
	public List<User> getUserList(UserQueryParam param, Pager pager);
	
	/**
	 * 保存或修改用户对象
	 * 
	 * @param user
	 */
	public void saveOrUpdate(User user);

}
