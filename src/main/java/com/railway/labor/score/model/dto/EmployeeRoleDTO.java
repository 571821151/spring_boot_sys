package com.railway.labor.score.model.dto;

/**
 * t_employee_role
 * 
 * @author zhuanglinxiang
 * 
 */
public class EmployeeRoleDTO extends BaseDTO {
	private static final long serialVersionUID = 6515482162556507903L;
	/**
	 * 主键ID t_employee_role.collumn id
	 */
	private Long id;
	/**
	 * 角色id t_employee_role.collumn employee_id
	 */
	private Long employeeId;
	/**
	 * 权限id t_employee_role.collumn role_id
	 */
	private Long roleId;
	
	/**
	 * 员工工号 t_employee.job_number
	 */
	private String employeeJobNumber;//
	/**
	 * 员工姓名 t_employee.name
	 */
	private String employeeName;// 姓名
	/**
	 * 部门名称 t_department.collumn name
	 */
	private String departmentName;
	/**
	 * 班组 t_team.collumn name
	 */
	private String teamName;
	/**
	 * 角色名称 t_role.collumn name
	 */
	private String roleName;
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
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getEmployeeJobNumber() {
		return employeeJobNumber;
	}
	public void setEmployeeJobNumber(String employeeJobNumber) {
		this.employeeJobNumber = employeeJobNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
