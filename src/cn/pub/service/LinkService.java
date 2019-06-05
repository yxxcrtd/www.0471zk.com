package cn.pub.service;

import java.util.List;

import cn.pub.param.LinkQueryParam;
import cn.pub.pojos.Link;
import cn.pub.util.Pager;

/**
 * 友情连接服务
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-04-23 20:05:29
 */
public interface LinkService {
	
	/**
	 * 根据主键标识获得对象
	 * 
	 * @param id
	 * @return
	 */
	public Link findById(int id);
	
	/**
	 * 获得友情连接列表
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
	public void save(Link link);
	
	/**
	 * 删除友情连接对象
	 * 
	 * @param linkId
	 */
	public void delete(int linkId);

}
