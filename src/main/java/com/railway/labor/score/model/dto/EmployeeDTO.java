package com.railway.labor.score.model.dto;

/**
 * t_employee
 * 
 * @author zhuanglinxiang
 * 
 */
public class EmployeeDTO extends BaseDTO {

	private static final long serialVersionUID = -8543541663995652230L;
	/**
	 * 主键ID t_employee.collumn id
	 */
	private Long id;
	/**
	 * 工号 t_employee.collumn job_number
	 */
	private String employeeJobNumber;
	/**
	 * 员工姓名 t_employee.collumn name
	 */
	private String employeeName;
	/**
	 * '职务id t_employee.collumn position_id
	 */
	private Long positionId;
	/**
	 * 组id t_team.collumn id
	 */
	private Long teamId;
	
	/**
	 * 班组 t_team.collumn name
	 */
	private String teamName;
	/**
	 * 班组 t_employee.collumn password
	 */
	private String password;
	/**
	 * 部门名称 t_department.collumn id
	 */
	private Long departmentId;
	/**
	 * 部门名称 t_department.collumn name
	 */
	private String departmentName;
	/**
	 * 现所属序列
	 */
	private String sequence;
	/**
	 * 现评定等级
	 */
	private String grade;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

}
