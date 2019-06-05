package cn.pub.action;																									

import java.io.File;
import java.util.Date;

import cn.pub.action.base.BaseProductAction;
import cn.pub.param.ProductQueryParam;
import cn.pub.pojos.Product;
import cn.pub.util.CommonUtil;

/**
 * 商品
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-18 15:57:55
 */
public class ProductAction extends BaseProductAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9185106998725151163L;

	/* (non-Javadoc)
	 * 
	 * @see cn.pub.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		if ("edit".equals(cmd)) {
			return edit();
		} else if ("save".equals(cmd)) {
			return save();
		} else if ("del".equals(cmd)) {
			return del();
		} else if ("hit".equals(cmd)) {
			return hit();
		} else if ("print".equals(cmd)) {
			return print();
		} else if ("search".equals(cmd)) {
			return search();
		} else {
			return list();
		}
	}
	
	/**
	 * Search
	 * 
	 * @return
	 * @throws Exception
	 */
	private String search() throws Exception {
		ProductQueryParam param = new ProductQueryParam();
		if (null == k || "".equals(k) || k.length() == 0) {
			// Ignore
		} else {
			k = k.trim();
			param.k = k;
		}
		param.o = obj;
		productList = productService.getProductList(param, 0);
		
		// 插入搜索表
		searchService.saveOrUpdate(k);
		
		return SEARCH_SUCCESS;
	}
	
	/**
	 * 列表
	 * 
	 * @return
	 * @throws Exception
	 */
	private String list() throws Exception {
		logger.info("当前显示信息的用户名：" + username);
		logger.info("当前显示信息的用户Id：" + userId);
		
		ProductQueryParam param = new ProductQueryParam();
		if (null == k || "".equals(k) || k.length() == 0) {
			// Ignore
		} else {
			k = k.trim();
			param.k = k;
		}
		// param.o = obj;
		// 用户Id的限定条件
		// param.userId = Integer.valueOf(userId);
		productList = productService.getProductList(param, pager);
		return SUCCESS;
	}
	
	/**
	 * 编辑
	 * 
	 * @return
	 * @throws Exception
	 */
	private String edit() throws Exception {
		if (null == product) {
			product = new Product();
			// 根据0判断是添加或修改
			product.setStatus(0);
			product.setProductId(0);
			product.setEndTime(new Date());
		} else {
			product = productService.findById(product.getProductId());
		}
		
		// 分类树
		categoryTree = categoryService.getCategoryTree(type);
		
		return EDIT_SUCCESS;
	}
	
	/**
	 * 保存
	 * 
	 * @return
	 * @throws Exception
	 */
	private String save() throws Exception {
		product.setDiscount((product.getOffPrice() / product.getPrice()) * 10);
		product.setEconomize(product.getPrice() - product.getOffPrice());
		
		// 判断是：保存还是修改
		if (0 == product.getProductId()) {
			if (null != file && !"".equals(fileFileName)) {
				// 1, Two files
				if (2 > file.size()) {
					this.addActionError(this.getText("system.file.upload.two"));
					return INPUT;
				}
				
				// 上传目录
				String root = new StringBuffer().append(servletContext.getRealPath("/")).append("upload").append(File.separator).toString();
				logger.info("Picture Upload's Destination:" + root);
				
				for (int i = 0; i < file.size(); i++) {
					// 存储到磁盘上和数据库中的文件名规则：年月日时分秒毫秒.文件后缀：20110801121212123.jpeg
					String fileName = new StringBuffer().append(String.valueOf(String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS%1$tL", new Date()))).append(".").append(fileFileName.get(i).substring(fileFileName.get(i).lastIndexOf(".") + 1, fileFileName.get(i).length()).toLowerCase()).toString();
					logger.info("存储到磁盘上和数据库中的文件名：" + fileName);
					
					// 最后上传的文件
					File destFile = new File(root, fileName);
					logger.info("最后上传的文件：" + destFile);
					
					// Upload
					CommonUtil.uploadFile(file.get(i), fileFileName.get(i), fileContentType.get(i), destFile.toString());
					
					// 保存图片路径
					if (0 == i) {
						// 生成缩略图（参数：原图片文件，生成的目标缩略图文件，宽度，高度）
						CommonUtil.generateThumbnail(destFile.toString(), destFile.getParentFile() + File.separator + "category_" + fileName, 116, 82); // 分类
						CommonUtil.generateThumbnail(destFile.toString(), destFile.getParentFile() + File.separator + "case_" + fileName, 152, 110); // 案例
						CommonUtil.generateThumbnail(destFile.toString(), destFile.getParentFile() + File.separator + "recommend_" + fileName, 174, 133); // 推荐
						CommonUtil.generateThumbnail(destFile.toString(), destFile.getParentFile() + File.separator + "show_" + fileName, 235, 178); // 最终商品显示页面的图片
						CommonUtil.generateThumbnail(destFile.toString(), destFile.getParentFile() + File.separator + "index_" + fileName, 471, 263); // 首页6个Flash滚动
						CommonUtil.generateThumbnail(destFile.toString(), destFile.getParentFile() + File.separator + "product_" + fileName, 513, 240); // 二级页面的5个上下滚动
						
						// 数据库只保存一个文件名
						product.setPicture(fileName);
					}
					
					// 保存优惠券路径
					if (1 == i) {
						// 生成优惠券的缩略图（参数：原图片文件，生成的目标缩略图文件，宽度，高度）
						CommonUtil.generateThumbnail(destFile.toString(), destFile.getParentFile() + File.separator + "voucher_" + fileName, 275, 148);
						product.setVoucher(fileName);
					}
				}
			} else {
				this.addActionError(this.getText("system.file.upload.nothing"));
				return INPUT;
			}
		}
		
		// 根据分类Id得到分类对象，再得到分类的类型
		type = categoryService.findById(product.getCategory()).getType();
		product.setType(type);
		productService.saveOrUpdateProduct(product);
		
		generateHTML();
		this.addActionMessage("product");
		return TIP_INFO;
	}
	
	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	private String del() throws Exception {
		productService.delete(product.getProductId());
		return list();
	}
	
	/**
	 * 点击量
	 * 
	 * @return
	 * @throws Exception
	 */
	private String hit() throws Exception {
		productService.increaseHit(product.getProductId());
		return NONE;
	}
	
	/**
	 * 限量抢购
	 * 
	 * @return
	 * @throws Exception
	 */
	private String print() throws Exception {
		// 1，先减少
		productService.decreaseCount(product.getProductId());
		
		// 2，生成首页限量抢购模块
		product = productService.findById(product.getProductId());
		generateProductLimitHTML(product);
		
		// 3，返回
		return NONE;
	}

}
