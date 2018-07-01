package com.railway.labor.score.model.dto;

/**
 * t_user_role
 * 
 * @author zhuanglinxiang
 * 
 */
public class UserRoleDTO extends BaseDTO {
	private static final long serialVersionUID = 6515482162556507903L;
	/**
	 * 主键ID t_user_role.collumn id
	 */
	private Long id;
	/**
	 * 角色id t_user_role.collumn user_id
	 */
	private Long userId;
	/**
	 * 角色id t_user.collumn name
	 */
	private String userName;
	/**
	 * 角色id t_user.collumn name
	 */
	private String userAccount;
	/**
	 * 权限id t_user_role.collumn role_id
	 */
	private Long roleId;
	/**
	 * 权限id t_role.collumn role_name
	 */
	private String roleName;
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
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
