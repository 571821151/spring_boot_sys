package com.railway.labor.score.model.dto;


/**
 * t_user
 * 
 * @author zhuanglinxiang
 * 
 */
public class UserDTO extends BaseDTO {
	private static final long serialVersionUID = 4967397800781853929L;
	/**
	 * 主键ID t_user.collumn id
	 */
	private Long id;
	/**
	 * 用户名称 t_user.collumn name
	 */
	private String name;
	/**
	 * 用户账号 t_user.collumn account
	 */
	private String account;
	/**
	 * 用户电话 t_user.collumn telephone
	 */
	private String telephone;
	/**
	 * 用户邮箱 t_user.collumn email
	 */
	private String email;
	/**
	 * 用户密码 t_user.collumn password
	 */
	private String password;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
