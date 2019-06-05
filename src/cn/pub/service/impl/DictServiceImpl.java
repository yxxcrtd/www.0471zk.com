package cn.pub.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import cn.pub.param.DictQueryParam;
import cn.pub.pojos.Dict;
import cn.pub.service.DictService;
import cn.pub.service.impl.base.BaseServiceImpl;
import cn.pub.util.Pager;

/**
 * 数据字典服务的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-07 20:11:51
 */
public class DictServiceImpl extends BaseServiceImpl implements DictService {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.DictService#findById(int)
	 */
	@Override
	public Dict findById(int id) {
		return dictDao.findById(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.DictService#save(cn.pub.pojos.Dict)
	 */
	@Override
	public void save(Dict dict) {
		// 不管是添加还是修改，只要有重复的记录就不操作数据库
		if (null == dictDao.findDictByKeyAndValue(dict.getKey(), dict.getValue())) {
			dictDao.saveOrUpdateDict(dict);
		}
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.DictService#update(cn.pub.pojos.Dict)
	 */
	@Override
	public String update(Dict dict) throws UnsupportedEncodingException {
		dict.setValue(URLDecoder.decode(URLDecoder.decode(dict.getValue(), "UTF-8"), "UTF-8"));
		if (null == dictDao.findDictByKeyAndValue(dict.getKey(), dict.getValue())) {
			dictDao.saveOrUpdateDict(dict);
			return SUCCESS;
		} else {
			return NONE;
		}
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.DictService#getDictList(cn.pub.param.DictQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<Dict> getDictList(DictQueryParam param, Pager pager) {
		return dictDao.getDictList(param, pager);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.DictService#getAreaOfDict(cn.pub.param.DictQueryParam)
	 */
	@Override
	public List<Dict> getAreaOfDict(DictQueryParam param) {
		return dictDao.getAreaOfDict(param);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.DictService#getDictList(java.lang.String)
	 */
	@Override
	public List<Dict> getDictList(String dictKey) {
		return dictDao.getDictList(dictKey);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.DictService#delete(int)
	 */
	@Override
	public void delete(int dictId) {
		Dict dict = dictDao.findById(dictId);
		if (null != dict) {
			dictDao.delete(dict);
		}
	}
	
}
