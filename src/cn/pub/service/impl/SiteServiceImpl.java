package cn.pub.service.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.context.ServletContextAware;

import cn.pub.service.SiteService;
import cn.pub.service.impl.base.BaseServiceImpl;
import freemarker.template.TemplateException;

/**
 * 站点服务的实现
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-06-10 15:05:01
 */
public class SiteServiceImpl extends BaseServiceImpl implements SiteService, ServletContextAware {

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.service.SiteService#generateIndex(java.lang.String, java.lang.String, java.util.Map, java.lang.String)
	 */
	@Override
	public void generateIndex(String ftl, String htmlName, Map<String, Object> map, String folderName) {
		try {
			generateHTML(ftl, htmlName, map, folderName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
