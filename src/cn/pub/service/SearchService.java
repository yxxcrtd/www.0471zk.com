package cn.pub.service;

import java.util.List;

import cn.pub.param.SearchQueryParam;
import cn.pub.pojos.Search;

/**
 * 搜索服务
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-09-18 20:53:11
 */
public interface SearchService {
	
	/**
	 * 得到最热门的搜索列表
	 * 
	 * @param param
	 * @return
	 */
	public List<Search> getSearchList(SearchQueryParam param);
	
	/**
	 * 保存（会判断是保存还是增加搜索量）
	 * 
	 * @param k
	 */
	public void saveOrUpdate(String k);

}
