package cn.pub.param;

import cn.pub.param.base.BaseQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.param.base.QueryParam;

/**
 * 用户的查询参数
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-04-02 13:30:14
 */
public class UserQueryParam extends BaseQueryParam implements QueryParam {
	
	public QueryHelper createQuery(boolean bol) {		
		QueryHelper query = new QueryHelper();
		query.fromClause = "FROM User";
		query.orderClause = "ORDER BY userId DESC";
		
		// 查询关键字
		if (null != k && k.length() > 0) {
			query.addAndWhere("(username LIKE :likeKey) OR (email LIKE :likeKey) OR (phone LIKE :likeKey)");
			query.setString("likeKey", "%" + k + "%");
		}
		
		// 返回
		return query;
	}
	
}
