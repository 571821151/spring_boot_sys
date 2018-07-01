package com.railway.labor.score.common;

/**
 * 
 * @author zhuanglinxiang
 * 
 */
public enum ErrorEnum {
	
	USER_NULL(1,"U0001","用户为空"),
	USER_QUERY_EXCEPTION(2,"U0002","用户查询异常"),
	USER_EXSIT(3,"U0003","用户已存在"),
	EMPLOYEE_NULL(4,"E0001","员工为空"),
	EMPLOYEE_QUERY_EXCEPTION(5,"E0002","员工查询异常"),
	EMPLOYEE_EXSIT(6,"E0003","员工已存在"),
	DEPARTMENT_NULL(7,"D0001","部门为空"),
	DEPARTMENT_QUERY_EXCEPTION(8,"D0002","部门查询异常"),
	DEPARTMENT_EXSIT(9,"D0003","部门已存在"),
	TEAM_NULL(10,"T0001","班组为空"),
	TEAM_QUERY_EXCEPTION(11,"T0002","班组查询异常"),
	TEAM_EXSIT(12,"T0003","班组已存在"),
	ROLE_NULL(13,"R0001","角色为空"),
	ROLE_QUERY_EXCEPTION(14,"R0002","角色查询异常"),
	ROLE_EXSIT(15,"R0003","角色已存在")
	;
	
	private int index;
	private String code;
	private String msg;
	
	private ErrorEnum(int index, String code, String msg) {
		this.index = index;
		this.code = code;
		this.msg = msg;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
