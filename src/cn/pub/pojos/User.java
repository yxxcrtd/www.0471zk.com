package cn.pub.pojos;

import java.io.Serializable;

/**
 * 用户对象
 * 
 * @author Yang XinXin
 * @version 1.0.0, 2012-03-07 21:22:52
 */
public class User implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 466263313528193668L;

	/**
	 * 用户标识
	 */
	private int userId;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 重复密码
	 */
	private String repassword;
	
	/**
	 * 用户角色（0:代表会员；1:代表系统管理员；2:代表商户；... ；9:代表用户已被删除）
	 */
	private int role;
	
	/**
	 * 邮件地址
	 */
	private String email;
	
	/**
	 * 验证码
	 */
	private String verifyCode;
	
	/** 
	 * Default Constructor
	 */
	public User() {
		// 
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

}
