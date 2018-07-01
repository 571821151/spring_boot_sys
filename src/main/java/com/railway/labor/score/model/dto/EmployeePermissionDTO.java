package com.railway.labor.score.model.dto;

/**
 * t_employee_permission
 * 
 * @author zhuanglinxiang
 * 
 */
public class EmployeePermissionDTO extends BaseDTO {
	private static final long serialVersionUID = 3428115056462889318L;
	/**
	 * 主键ID t_employee_permission.collumn id
	 */
	private Long id;
	/**
	 * 角色id t_employee_permission.collumn employee_id
	 */
	private Long employeeId;
	/**
	 * 权限id t_employee_permission.collumn permission_id
	 */
	private Long permissionId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

}
