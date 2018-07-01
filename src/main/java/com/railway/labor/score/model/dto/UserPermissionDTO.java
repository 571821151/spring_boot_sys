package com.railway.labor.score.model.dto;

/**
 * t_user_permission
 * 
 * @author zhuanglinxiang
 * 
 */
public class UserPermissionDTO extends BaseDTO {
	private static final long serialVersionUID = 3428115056462889318L;
	/**
	 * 主键ID t_user_permission.collumn id
	 */
	private Long id;
	/**
	 * 角色id t_user_permission.collumn user_id
	 */
	private Long userId;
	/**
	 * 权限id t_user_permission.collumn permission_id
	 */
	private Long permissionId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

}
