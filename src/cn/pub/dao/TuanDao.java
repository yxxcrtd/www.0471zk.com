package cn.pub.dao;

import java.util.List;

import cn.pub.param.TuanQueryParam;
import cn.pub.pojos.Tuan;
import cn.pub.util.Pager;

/**
 * 团购DAO
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-18 15:53:39
 */
public interface TuanDao {
	
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
	 * @param tuan
	 */
	public void delete(Tuan tuan);
	
}
