package com.railway.labor.score.model.dto;

/**
 * t_role_permission
 * 
 * @author zhuanglinxiang
 * 
 */
public class RolePermissionDTO extends BaseDTO {
	private static final long serialVersionUID = 3428115056462889318L;
	/**
	 * 主键ID t_role_permission.collumn id
	 */
	private Long id;
	/**
	 * 角色id t_permission.collumn role_id
	 */
	private Long roleId;
	/**
	 * 权限id t_permission.collumn permission_id
	 */
	private Long permissionId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

}
