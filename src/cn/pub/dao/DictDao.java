package cn.pub.dao;

import java.util.List;

import cn.pub.param.DictQueryParam;
import cn.pub.pojos.Dict;
import cn.pub.util.Pager;

/**
 * 数据字典DAO
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-07 20:19:03
 */
public interface DictDao {
	
	/**
	 * 根据主键标识获得对象
	 * 
	 * @param id
	 * @return
	 */
	public Dict findById(int id);
	
	/**
	 * 根据字典键和字典值获得字典对象
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Dict findDictByKeyAndValue(String key, String value);
	
	/**
	 * 保存或修改字典对象
	 * 
	 * @param dict
	 */
	public void saveOrUpdateDict(Dict dict);
	
	/**
	 * 得到带分页的数据字典列表
	 * 
	 * @param param
	 * @param pager
	 * @return
	 */
	public List<Dict> getDictList(DictQueryParam param, Pager pager);
	
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
	 * @param dict
	 */
	public void delete(Dict dict);

}
