package cn.pub.service;

import java.util.Map;

/**
 * 站点服务
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2011-03-07 20:03:22
 */
public interface SiteService {
	
	/**
	 * 生成首页
	 * 
	 * @param ftl 模板文件
	 * @param htmlName 最后生成的文件名称
	 * @param map 数据
	 * @param fileName 模板加载的父目录
	 */
	public void generateIndex(String ftl, String htmlName, Map<String, Object> map, String folderName);
	
}
