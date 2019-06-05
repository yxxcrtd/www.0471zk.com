package cn.pub.service;

import java.util.List;

import cn.pub.param.TuanQueryParam;
import cn.pub.pojos.Tuan;
import cn.pub.util.Pager;

/**
 * 团购服务
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-18 17:00:38
 */
public interface TuanService {
	
	/**
	 * Find By Id
	 * 
	 * @param id
	 * @return
	 */
	public Tuan findById(int id);

	/**
	 * Get Tuan List with Pager
	 * 
	 * @param param
	 * @param pager
	 * @return
	 */
	public List<Tuan> getTuanList(TuanQueryParam param, Pager pager);
	
	/**
	 * Get Tuan List with Number
	 * 
	 * @param param
	 * @param num
	 * @return
	 */
	public List<Tuan> getTuanList(TuanQueryParam param, int num);
	
	/**
	 * Upsert Tuan
	 * 
	 * @param tuan
	 */
	public void upsertTuan(Tuan tuan);
	
	/**
	 * Delete
	 * 
	 * @param tuanId
	 */
	public void delete(int tuanId);
	
}
