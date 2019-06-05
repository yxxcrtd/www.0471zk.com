package cn.pub.param;

import cn.pub.param.base.BaseQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.param.base.QueryParam;

/**
 * 团购的查询参数
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-18 15:56:37
 */
public class TuanQueryParam extends BaseQueryParam implements QueryParam {

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.param.base.QueryParam#createQuery(boolean)
	 */
	public QueryHelper createQuery(boolean bol) {
		QueryHelper query = new QueryHelper();
		query.fromClause = "FROM Tuan";
		query.orderClause = "ORDER BY operateTime DESC, tuanId DESC";

		// 查询关键字
		if (null != k && k.length() > 0) {
			query.addAndWhere("(name LIKE :likeKey) OR (url LIKE :likeKey)");
			query.setString("likeKey", "%" + k + "%");
		}
		
		// 返回
		return query;
	}

}
