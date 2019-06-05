package cn.pub.pojos;

import java.io.Serializable;
import java.util.Date;

/**
 * 团购对象
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-16 23:33:38
 */
public class Tuan implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2889708880490628679L;

	/**
	 * 团购ID
	 */
	private int tuanId;
	
	/**
	 * 团购图片
	 */
	private String picture;

	/**
	 * 团购名称
	 */
	private String name;

	/**
	 * 团购原价
	 */
	private Double price;

	/**
	 * 团购现价
	 */
	private Double offPrice;

	/**
	 * 团购折扣
	 */
	private Double discount;
	
	/**
	 * 团购连接
	 */
	private String url;
	
	/**
	 * 操作时间
	 */
	private Date operateTime = new Date();

	/**
	 * Default Constructor
	 */
	public Tuan() {
		//
	}

	public int getTuanId() {
		return tuanId;
	}

	public void setTuanId(int tuanId) {
		this.tuanId = tuanId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOffPrice() {
		return offPrice;
	}

	public void setOffPrice(Double offPrice) {
		this.offPrice = offPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

}
