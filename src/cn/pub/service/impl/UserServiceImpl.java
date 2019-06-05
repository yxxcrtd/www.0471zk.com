package cn.pub.service.impl;

import java.util.List;

import cn.pub.param.UserQueryParam;
import cn.pub.pojos.User;
import cn.pub.service.UserService;
import cn.pub.service.impl.base.BaseServiceImpl;
import cn.pub.util.Pager;

/**
 * 用户服务的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-07 20:11:51
 */
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.UserService#findById(int)
	 */
	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.UserService#getUserByQueryString(java.lang.String)
	 */
	@Override
	public User getUserByQueryString(String queryString) {
		if (null == queryString || "".equals(queryString) || queryString.length() == 0) {
			return null;
		}
		
		// 如果用户名中包含@，则认为是用email登录，否则是用户名来登录
		if (queryString.contains("@")) {
			return userDao.getUserByQueryString("email", queryString);
		} else {
			return userDao.getUserByQueryString("username", queryString);
		}
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.UserService#getUserList(cn.pub.param.UserQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<User> getUserList(UserQueryParam param, Pager pager) {
		return userDao.getUserList(param, pager);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.UserService#saveOrUpdate(cn.pub.pojos.User)
	 */
	@Override
	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}

}
