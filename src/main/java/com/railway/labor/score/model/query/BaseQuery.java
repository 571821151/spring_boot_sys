package com.railway.labor.score.model.query;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.railway.labor.score.common.OrderBy;

public class BaseQuery  implements Serializable{
	private Integer pageSize;
	private Long pageIndex;
	private List<OrderBy> orderByList;
	
	private static final long serialVersionUID = 3552080653831203194L;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public List<OrderBy> getOrderByList() {
		return orderByList;
	}

	public void setOrderByList(List<OrderBy> orderByList) {
		this.orderByList = orderByList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
