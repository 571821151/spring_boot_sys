package com.railway.labor.score.model.query;


public class LoginInfoQuery extends BaseQuery{

	private static final long serialVersionUID = 1858126493626772170L;

	/**
	 * 主键ID t_user.collumn id
	 */
	private Long id;
	/**
	 * 用户账号 t_user.collumn account
	 */
	private String account;
	/**
	 * 用户名称 t_user.collumn name
	 */
	private String name;
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


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
