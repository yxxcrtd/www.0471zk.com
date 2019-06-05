package cn.pub.pojos;

import java.io.Serializable;
import java.util.Date;

/**
 * 搜索对象
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-16 23:33:38
 */
public class Search implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1282890792926950260L;

	/**
	 * 搜索Id
	 */
	private int searchId;
	
	/**
	 * 搜索关键字
	 */
	private String keyword;
	
	/**
	 * 出现次数
	 */
	private int counts;
	
	/**
	 * 搜索时间
	 */
	private Date createDate = new Date();

	/**
	 * Default Constructor
	 */
	public Search() {
		//
	}

	public int getSearchId() {
		return searchId;
	}

	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
