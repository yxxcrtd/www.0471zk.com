package cn.pub.pojos;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品对象
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-16 23:33:38
 */
public class Product implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 94669267030820699L;

	/**
	 * 商品ID
	 */
	private int productId;

	/**
	 * 商品分类
	 */
	private int category;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 商品原价
	 */
	private Double price;

	/**
	 * 商品现价
	 */
	private Double offPrice;

	/**
	 * 商品折扣
	 */
	private Double discount;

	/**
	 * 商品节省
	 */
	private Double economize;

	/**
	 * 商品会员价
	 */
	private Double memberPrice;

	/**
	 * 商品有效期限
	 */
	private Date endTime;
	
	/**
	 * 商品图片
	 */
	private String picture;
	
	/**
	 * 商品优惠券
	 */
	private String voucher;
	
	/**
	 * 商品的使用说明
	 */
	private String instruction;
	
	/**
	 * 商品的商家简介
	 */
	private String introduce;
	
	/**
	 * 商品的使用地址
	 */
	private String address;
	
	/**
	 * 商品的点击量
	 */
	private int hit;
	
	/**
	 * 商品的状态（0：普通商品；1：推荐；2：公告；3：团购；4：精品滚动；5：体验卡...）
	 */
	private int status;
	
	/**
	 * 商品类型
	 */
	private String type;
	
	/**
	 * 商品数量
	 */
	private int counts;
	
	/**
	 * 商品发布日期
	 */
	private Date createDate = new Date();

	/**
	 * Default Constructor
	 */
	public Product() {
		//
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
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

	public Double getEconomize() {
		return economize;
	}

	public void setEconomize(Double economize) {
		this.economize = economize;
	}

	public Double getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(Double memberPrice) {
		this.memberPrice = memberPrice;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
