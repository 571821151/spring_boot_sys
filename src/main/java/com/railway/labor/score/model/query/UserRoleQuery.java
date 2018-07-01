package com.railway.labor.score.model.query;

public class UserRoleQuery extends BaseQuery {
	private static final long serialVersionUID = 8668737744106438775L;
	private Long id;
	//role
	private String roleId;
	private String roleName;
	private Long roleParentId;
	private Long roleDescr;
	//user
	private String userName;
	private Long userId;
	private Long userAccount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Long getRoleParentId() {
		return roleParentId;
	}
	public void setRoleParentId(Long roleParentId) {
		this.roleParentId = roleParentId;
	}
	public Long getRoleDescr() {
		return roleDescr;
	}
	public void setRoleDescr(Long roleDescr) {
		this.roleDescr = roleDescr;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(Long userAccount) {
		this.userAccount = userAccount;
	}

	
}
