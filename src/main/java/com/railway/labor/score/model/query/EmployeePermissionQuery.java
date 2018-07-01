package com.railway.labor.score.model.query;

public class EmployeePermissionQuery extends BaseQuery {

	private static final long serialVersionUID = 900062446309259659L;
	private Long id;
	//permission
	private String permissionId;
	private String permissionName;
	private String permissionType;
	private Long permissionParentId;
	
	//employee
	private String employeeName;
	private Long employeeId;
	private Long employeeJobNumber;
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
	public Long getEmployeeJobNumber() {
		return employeeJobNumber;
	}
	public void setEmployeeJobNumber(Long employeeJobNumber) {
		this.employeeJobNumber = employeeJobNumber;
	}
	
}
