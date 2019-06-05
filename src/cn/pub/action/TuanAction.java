package cn.pub.action;																									

import java.io.File;
import java.util.Date;

import cn.pub.action.base.BaseTuanAction;
import cn.pub.param.TuanQueryParam;
import cn.pub.pojos.Tuan;
import cn.pub.util.CommonUtil;

/**
 * 团购
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-18 15:57:55
 */
public class TuanAction extends BaseTuanAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5957786114411844664L;

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
		} else {
			return list();
		}
	}
	
	/**
	 * 列表
	 * 
	 * @return
	 * @throws Exception
	 */
	private String list() throws Exception {
		TuanQueryParam param = new TuanQueryParam();
		if (null == k || "".equals(k) || k.length() == 0) {
			// Ignore
		} else {
			k = k.trim();
			param.k = k;
		}
		tuanList = tuanService.getTuanList(param, pager);
		return SUCCESS;
	}
	
	/**
	 * 编辑
	 * 
	 * @return
	 * @throws Exception
	 */
	private String edit() throws Exception {
		if (null == tuan) {
			tuan = new Tuan();
			tuan.setTuanId(0);
		} else {
			tuan = tuanService.findById(tuan.getTuanId());
		}
		
		return EDIT_SUCCESS;
	}
	
	/**
	 * 保存
	 * 
	 * @return
	 * @throws Exception
	 */
	private String save() throws Exception {
		tuan.setDiscount((tuan.getOffPrice() / tuan.getPrice()) * 10);
		
		// 判断是：保存还是修改
		if (0 == tuan.getTuanId()) {
			if (null != file && !"".equals(fileFileName)) {
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
						CommonUtil.generateThumbnail(destFile.toString(), destFile.getParentFile() + File.separator + fileName, 200, 150); // 生成的缩略图直接覆盖原图
						
						// 数据库只保存一个文件名
						tuan.setPicture(fileName);
					}
				}
			} else {
				this.addActionError(this.getText("system.file.upload.nothing"));
				return INPUT;
			}
		}
		
		// 根据分类Id得到分类对象，再得到分类的类型
		tuanService.upsertTuan(tuan);
		
		// 生成静态文件
		generateHTML();
		
		this.addActionMessage("tuan");
		return TIP_INFO;
	}
	
	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	private String del() throws Exception {
		tuanService.delete(tuan.getTuanId());
		
		// 生成静态文件
		generateHTML();
		
		this.addActionMessage("tuan");
		return TIP_INFO;
	}

}
