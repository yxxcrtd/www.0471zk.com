package cn.pub.service.impl;

import java.io.File;
import java.util.List;

import cn.pub.param.TuanQueryParam;
import cn.pub.pojos.Tuan;
import cn.pub.service.TuanService;
import cn.pub.service.impl.base.BaseServiceImpl;
import cn.pub.util.Pager;

/**
 * 团购服务的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-18 17:18:19
 */
public class TuanServiceImpl extends BaseServiceImpl implements TuanService {

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.TuanService#findById(int)
	 */
	@Override
	public Tuan findById(int id) {
		return tuanDao.findById(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.TuanService#getTuanList(cn.pub.param.TuanQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<Tuan> getTuanList(TuanQueryParam param, Pager pager) {
		return tuanDao.getTuanList(param, pager);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.TuanService#getTuanList(cn.pub.param.TuanQueryParam, int)
	 */
	@Override
	public List<Tuan> getTuanList(TuanQueryParam param, int num) {
		return tuanDao.getTuanList(param, num);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.TuanService#upsertTuan(cn.pub.pojos.Tuan)
	 */
	@Override
	public void upsertTuan(Tuan tuan) {
		tuanDao.upsertTuan(tuan);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.TuanService#delete(int)
	 */
	@Override
	public void delete(int tuanId) {
		// 信息对象
		Tuan tuan = tuanDao.findById(tuanId);
		
		// 删除信息
		if (null != tuan) {
			tuanDao.delete(tuan);
			
			// 文件的物理连接
			String pictureAddress = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).append(tuan.getPicture()).toString();		
			
			// 删除物理文件
			new File(pictureAddress).delete();
		}
	}

}
