package cn.pub.pojos;

import java.io.Serializable;

/**
 * 数据字典对象
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-17 00:29:27
 */
public class Dict implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5678800889827613084L;

	/**
	 * 字典ID
	 */
	private int dictId;

	/**
	 * 字典键
	 */
	private String key;

	/**
	 * 字典值
	 */
	private String value;

	/**
	 * Default Constructor
	 */
	public Dict() {
		//
	}

	/**
	 * 字典标识的get方法
	 * 
	 * @return
	 */
	public int getDictId() {
		return dictId;
	}

	/**
	 * 字典标识的set方法
	 * 
	 * @param dictId
	 */
	public void setDictId(int dictId) {
		this.dictId = dictId;
	}

	/**
	 * 字典键的get方法
	 * 
	 * @return
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 字典键的set方法
	 * 
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 字典值的get方法
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 字典值的set方法
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
