package com.railway.labor.score.model.query;

public class PermissionQuery extends BaseQuery {
	private static final long serialVersionUID = 600856521293372774L;
	/**
	 * 主键ID t_permission.collumn id
	 */
	private Long id;
	/**
	 * 权限名称 t_permission.collumn name
	 */
	private String name;
	/**
	 * 权限类型 t_permission.collumn type
	 */
	private String type;
	/**
	 * 权限值 t_permission.collumn value
	 */
	private String value;
	/**
	 * 父权限ID t_permission.collumn parent_id
	 */
	private Long parentId;
	/**
	 * 层级 t_permission.collumn level
	 */
	private String level;
	/**
	 * 排序 t_permission.collumn order
	 */
	private String order;
	/**
	 * 权限描述 t_permission.collumn descr
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
}
