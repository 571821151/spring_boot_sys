package com.railway.labor.score.model.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 登录DTO
 * @author zhuanglinxiang
 *
 */
public class LoginInfoDTO implements Serializable{

	private static final long serialVersionUID = -8510597811497678614L;
	/**
	 * 主键ID t_employee/user.collumn id
	 */
	private Long id;
	/**
	 * 用户账号 t_user.collumn name
	 */
	private String userName;
	/**
	 * 用户名称 t_user.collumn account
	 */
	private String userAccount;
	/**
	 * 用户账号 t_employee.collumn job_number
	 */
	private String employeeJobNumber;
	/**
	 * 用户名称 t_employee.collumn name
	 */
	private String employeeName;
	
	private Long teamId;
	
	private String teamName;
	
	private Long departmentId;
	
	private String departmentName;
	
	private String loginType;//	user/employee
	
	private List<Map<String, Object>> roleList;//	user/employee
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public List<Map<String, Object>> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Map<String, Object>> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
