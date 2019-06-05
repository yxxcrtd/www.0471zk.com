package cn.pub.dao;

import java.util.List;

import cn.pub.param.SearchQueryParam;
import cn.pub.pojos.Search;

/**
 * 搜索DAO
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-07 20:19:03
 */
public interface SearchDao {
	
	/**
	 * 得到最热门的搜索列表
	 * 
	 * @param param
	 * @return
	 */
	public List<Search> getSearchList(SearchQueryParam param);
	
	/**
	 * 根据关键字搜索对象
	 * 
	 * @param keyword
	 * @return
	 */
	public Search findByKeyword(String keyword);
	
	/**
	 * 增加搜索量
	 * 
	 * @param searchId
	 */
	public void increaseCounts(int searchId);
	
	/**
	 * 保存
	 * 
	 * @param search
	 */
	public void saveOrUpdate(Search search);

}
