package com.railway.labor.score.model.dto;

/**
 * t_department
 * 
 * @author zhuanglinxiang
 * 
 */
public class DepartmentDTO extends BaseDTO {

	private static final long serialVersionUID = -1680064442699304409L;
	/**
	 * 主键ID t_team.collumn id
	 */
	private Long id;
	/**
	 * 部门名称 t_team.collumn name
	 */
	private String name;
	/**
	 * 父部门id t_team.collumn parent_id
	 */
	private Long parentId;
	/**
	 * 部门描述 t_team.collumn descr
	 */
	private String descr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}
