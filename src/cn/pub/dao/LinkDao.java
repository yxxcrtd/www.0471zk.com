package cn.pub.dao;

import java.util.List;

import cn.pub.param.LinkQueryParam;
import cn.pub.pojos.Link;
import cn.pub.util.Pager;

/**
 * 友情连接DAO
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-04-23 20:06:18
 */
public interface LinkDao {
	
	/**
	 * 根据主键标识获得对象
	 * 
	 * @param id
	 * @return
	 */
	public Link findById(int id);
	
	/**
	 * 得到带分页的友情连接列表
	 * 
	 * @param param
	 * @param pager
	 * @return
	 */
	public List<Link> getLinkList(LinkQueryParam param, Pager pager);
	
	/**
	 * 获得全部的友情连接列表
	 * 
	 * @return
	 */
	public List<Link> getLinkList();
	
	/**
	 * 保存友情连接对象
	 * 
	 * @param link
	 */
	public void saveOrUpdateLink(Link link);
	
	/**
	 * 根据名称和地址查找对象
	 * 
	 * @param name
	 * @param url
	 * @return
	 */
	public Link findLinkByNameAndUrl(String name, String url);
	
	/**
	 * 删除友情连接对象
	 * 
	 * @param link
	 */
	public void delete(Link link);

}
