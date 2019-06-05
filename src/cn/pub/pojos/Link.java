package cn.pub.pojos;

import java.io.Serializable;
import java.util.Date;

/**
 * 友情连接对象
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-04-23 20:12:37
 */
public class Link implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6560377412333173331L;

	/**
	 * 友情连接ID
	 */
	private int linkId;

	/**
	 * 友情连接名称
	 */
	private String name;

	/**
	 * 友情连接地址
	 */
	private String url;
	
	/**
	 * 友情连接修改时间
	 */
	private Date modified;

	/**
	 * Default Constructor
	 */
	public Link() {
		//
	}

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

}
