package cn.pub.param;

import cn.pub.param.base.BaseQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.param.base.QueryParam;

/**
 * 搜索的查询参数
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-09-18 20:10:29
 */
public class SearchQueryParam extends BaseQueryParam implements QueryParam {
	
	public QueryHelper createQuery(boolean bol) {		
		QueryHelper query = new QueryHelper();
		query.fromClause = "FROM Search";
		query.orderClause = "ORDER BY counts DESC, createDate DESC";
		
		// 返回
		return query;
	}
	
}
