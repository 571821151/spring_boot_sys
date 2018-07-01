package com.railway.labor.score.model.query;

public class RolePermissionQuery extends BaseQuery {
	private static final long serialVersionUID = 638125936866127363L;
	private Long id;
	//permission
	private String permissionId;
	private String permissionName;
	private String permissionType;
	private Long permissionParentId;
	//role
	private String roleName;
	private Long roleId;
	private Long roleParentId;
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getRoleParentId() {
		return roleParentId;
	}
	public void setRoleParentId(Long roleParentId) {
		this.roleParentId = roleParentId;
	}
	
}
