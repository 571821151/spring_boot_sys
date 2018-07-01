package com.railway.labor.score.model.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DTO基类
 * 
 * @author zhuanglinxiang
 * 
 */
public class BaseDTO implements Serializable {
	private static final long serialVersionUID = -1805134330356780357L;
	/**
	 * 创建人 table.collumn creator
	 */
	private Long creator;
	/**
	 * 创建时间 table.collumn create_date
	 */
	private Date createDate;
	/**
	 * 修改人 table.collumn modifier
	 */
	private Long modifier;
	/**
	 * 修改时间 table.collumn modify_date
	 */
	private Date modifyDate;
	/**
	 * 备注 table.collumn remarks
	 */
	private String remarks;
	/**
	 * 删除标志 1-已删除，0-未删除 table.collumn del_flag
	 */
	private String delFlag = "0";

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getModifier() {
		return modifier;
	}

	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
