package com.railway.labor.score.model.query;

public class UserPermissionQuery extends BaseQuery {

	private static final long serialVersionUID = 900062446309259659L;
	private Long id;
	//permission
	private String permissionId;
	private String permissionName;
	private String permissionType;
	private Long permissionParentId;
	
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
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionType() {
		return permissionType;
	}
	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
	public Long getPermissionParentId() {
		return permissionParentId;
	}
	public void setPermissionParentId(Long permissionParentId) {
		this.permissionParentId = permissionParentId;
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
