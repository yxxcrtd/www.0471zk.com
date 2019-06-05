package cn.pub.service.impl.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletContextAware;

import cn.pub.dao.CategoryDao;
import cn.pub.dao.DictDao;
import cn.pub.dao.LinkDao;
import cn.pub.dao.ProductDao;
import cn.pub.dao.SearchDao;
import cn.pub.dao.TuanDao;
import cn.pub.dao.UserDao;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Service接口实现的基类
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-10-12 13:05:30
 */
public class BaseServiceImpl implements ServletContextAware {

	/**
	 * 日志
	 */
	protected static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	/**
	 * servletContext
	 */
	protected ServletContext servletContext;

	/**
	 * success
	 */
	protected static final String SUCCESS = "success";

	/**
	 * error
	 */
	protected static final String ERROR = "error";

	/**
	 * none
	 */
	protected static final String NONE = "none";

	/**
	 * null
	 */
	protected static final String NULL = "null";

	
	/** 
	 * 用户DAO
	 */
	protected UserDao userDao;
	
	/**
	 * 系统分类DAO
	 */
	protected CategoryDao categoryDao;
	
	/**
	 * 商品DAO
	 */
	protected ProductDao productDao;
	
	/**
	 * 团购DAO
	 */
	protected TuanDao tuanDao;

	/** 
	 * 数据字典DAO
	 */
	protected DictDao dictDao;
	
	/**
	 * 友情连接DAO
	 */
	protected LinkDao linkDao;
	
	/**
	 * 搜索DAO
	 */
	protected SearchDao searchDao;
	
	/**
	 * 生成纯静态的HTML文件
	 * 
	 * @param ftl
	 * @param htmlName
	 * @param map
	 * @param folderName
	 * @throws IOException
	 * @throws TemplateException
	 */
	protected void generateHTML(String ftl, String htmlName, Map<String, Object> map, String folderName) throws IOException, TemplateException {
		Configuration cfg = new Configuration();
		// 如果将第二个参数设置为：null，则表示网站根目录（相对路径）
		cfg.setServletContextForTemplateLoading(servletContext, File.separator + folderName);
		cfg.setEncoding(Locale.getDefault(), "UTF-8"); // 防止乱码
		Template template = cfg.getTemplate(ftl);
		template.setEncoding("UTF-8");
		String path = servletContext.getRealPath("/");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + htmlName));
		File htmlFile = new File(path + htmlName);
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
		// map.put("JspTaglibs", new TaglibFactory(servletContext));
		template.process(map, out);
		bufferedWriter.close(); // 关闭缓冲流
		out.flush(); // 清除缓冲区
		out.close(); // 关闭输出流
	}
	

	/** 
	 * 用户DAO的set方法
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 系统分类DAO的set方法
	 * 
	 * @param categoryDao
	 */
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * 商品DAO的set方法
	 * 
	 * @param productDao
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	/**
	 * 团购DAO的set方法
	 * 
	 * @param tuanDao
	 */
	public void setTuanDao(TuanDao tuanDao) {
		this.tuanDao = tuanDao;
	}

	/** 
	 * 数据字典DAO的set方法
	 */
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}
	
	/**
	 * 友情连接DAO的set方法
	 * 
	 * @param linkDao
	 */
	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	/**
	 * 搜索DAO的set方法
	 * 
	 * @param searchDao
	 */
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}


	/* (non-Javadoc)
	 * 
	 * @see org.springframework.web.context.ServletContextAware#setServletContext(javax.servlet.ServletContext)
	 */
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
