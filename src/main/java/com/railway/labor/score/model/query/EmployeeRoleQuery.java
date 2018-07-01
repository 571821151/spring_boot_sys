package com.railway.labor.score.model.query;

public class EmployeeRoleQuery extends BaseQuery {
	private static final long serialVersionUID = 8668737744106438775L;
	private Long id;
	//role
	private String roleId;
	private String roleName;
	private Long roleParentId;
	private Long roleDescr;
	//employee
	private Long employeeId;
	private String employeeJobNumber;
	private String employeeName;
	private String departmentName;
	private String teamName;
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeJobNumber() {
		return employeeJobNumber;
	}
	public void setEmployeeJobNumber(String employeeJobNumber) {
		this.employeeJobNumber = employeeJobNumber;
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

	
}
