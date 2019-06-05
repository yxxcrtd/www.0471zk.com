package cn.pub.param;

import cn.pub.param.base.BaseQueryParam;
import cn.pub.param.base.QueryHelper;
import cn.pub.param.base.QueryParam;

/**
 * 信息的查询参数
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-18 15:56:37
 */
public class ProductQueryParam extends BaseQueryParam implements QueryParam {

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.param.base.QueryParam#createQuery(boolean)
	 */
	public QueryHelper createQuery(boolean bol) {
		QueryHelper query = new QueryHelper();
		query.fromClause = "FROM Product";
		query.orderClause = "ORDER BY createDate DESC, productId DESC";

		// 查询关键字
		if (null != k && k.length() > 0) {
			query.addAndWhere("(name LIKE :likeKey) OR (instruction LIKE :likeKey) OR (introduce LIKE :likeKey) OR (address LIKE :likeKey)");
			query.setString("likeKey", "%" + k + "%");
		}
		
		// 信息类型的过滤
		if (null != o && 0 < o.length()) {
			query.addAndWhere("(type = '" + o + "')");
			// query.setString("obj", String.valueOf(o));
			query.orderClause = "ORDER BY createDate DESC, productId DESC";
		}
		
		// 信息状态的过滤
		if (0 < status) {
			query.addAndWhere("(status = :obj)");
			query.setInteger("obj", status);
		}
		
		// 限量抢购
		if (0 < count) {
			query.addAndWhere("(counts > 0)");
			query.orderClause = "ORDER BY createDate DESC";
		}
		
		// 热门排行榜
		if (hit) {
			query.orderClause = "ORDER BY hit DESC";
		}
		
		// 返回
		return query;
	}

}
