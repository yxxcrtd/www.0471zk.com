package cn.pub.param;

import cn.pub.param.base.BaseQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.param.base.QueryParam;

/**
 * 数据字典的查询参数
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-17 00:53:22
 */
public class DictQueryParam extends BaseQueryParam implements QueryParam {
	
	public QueryHelper createQuery(boolean bol) {
		QueryHelper query = new QueryHelper();
		query.fromClause = "FROM Dict";
		query.orderClause = "ORDER BY dictId DESC";
		
		// 查询关键字
		if (null != k && k.length() > 0) {
			query.addAndWhere("dictValue LIKE :likeKey");
			query.setString("likeKey", "%" + k + "%");
		}
		
		// 对象
		if (null != o && o.length() > 0) {
			query.addAndWhere("(dictKey = :obj)");
			query.setString("obj", o);
		}
		
		// 返回
		return query;
	}

}
