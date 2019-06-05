package cn.pub.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import cn.pub.param.DictQueryParam;
import cn.pub.pojos.Dict;
import cn.pub.util.Pager;

/**
 * 数据字典服务
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-07 20:03:22
 */
public interface DictService {
	
	/**
	 * 根据主键标识获得对象
	 * 
	 * @param id
	 * @return
	 */
	public Dict findById(int id);
	
	/**
	 * 保存字典对象
	 * 
	 * @param dict
	 */
	public void save(Dict dict);
	
	/**
	 * 修改字典对象
	 * 
	 * @param dict
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String update(Dict dict) throws UnsupportedEncodingException;

	/**
	 * 数据字典列表
	 * 
	 * @param param
	 * @param pager
	 * @return
	 */
	public List<Dict> getDictList(DictQueryParam param, Pager pager);
	
	/**
	 * 获取数据字典对象
	 * 
	 * @param param
	 * @return
	 */
	public List<Dict> getAreaOfDict(DictQueryParam param);
	
	/**
	 * 获得字典列表
	 * 
	 * @param dictKey
	 * @return
	 */
	public List<Dict> getDictList(String dictKey);
	
	/**
	 * 删除字典对象
	 * 
	 * @param dictId
	 */
	public void delete(int dictId);

}
