package cn.pub.service.impl;

import java.util.List;

import cn.pub.param.SearchQueryParam;
import cn.pub.pojos.Search;
import cn.pub.service.SearchService;
import cn.pub.service.impl.base.BaseServiceImpl;

/**
 * 搜索服务的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-07 20:11:51
 */
public class SearchServiceImpl extends BaseServiceImpl implements SearchService {

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.SearchService#getSearchList(cn.pub.param.SearchQueryParam)
	 */
	@Override
	public List<Search> getSearchList(SearchQueryParam param) {
		return searchDao.getSearchList(param);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.SearchService#saveOrUpdate(java.lang.String)
	 */
	@Override
	public void saveOrUpdate(String k) {
		Search search = searchDao.findByKeyword(k);
		if (null != search) {
			searchDao.increaseCounts(search.getSearchId());
		} else {
			search = new Search();
			search.setKeyword(k);
			searchDao.saveOrUpdate(search);
		}
	}
	
}
