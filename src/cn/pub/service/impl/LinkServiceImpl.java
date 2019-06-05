package cn.pub.service.impl;

import java.util.List;

import cn.pub.param.LinkQueryParam;
import cn.pub.pojos.Link;
import cn.pub.service.LinkService;
import cn.pub.service.impl.base.BaseServiceImpl;
import cn.pub.util.Pager;

/**
 * 友情连接服务的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-04-23 20:05:52
 */
public class LinkServiceImpl extends BaseServiceImpl implements LinkService {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.LinkService#findById(int)
	 */
	@Override
	public Link findById(int id) {
		return linkDao.findById(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.LinkService#getLinkList(cn.pub.param.LinkQueryParam, cn.pub.util.Pager)
	 */
	@Override
	public List<Link> getLinkList(LinkQueryParam param, Pager pager) {
		return linkDao.getLinkList(param, pager);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.LinkService#getLinkList()
	 */
	@Override
	public List<Link> getLinkList() {
		return linkDao.getLinkList();
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.LinkService#save(cn.pub.pojos.Link)
	 */
	@Override
	public void save(Link link) {
		// 不管是添加还是修改，只要有重复的记录就不操作数据库
		if (null == linkDao.findLinkByNameAndUrl(link.getName(), link.getUrl())) {
			linkDao.saveOrUpdateLink(link);
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.LinkService#delete(int)
	 */
	@Override
	public void delete(int linkId) {
		Link link = linkDao.findById(linkId);
		if (null != link) {
			linkDao.delete(link);
		}
	}
	
}
