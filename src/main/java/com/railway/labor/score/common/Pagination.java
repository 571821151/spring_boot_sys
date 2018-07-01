package com.railway.labor.score.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 分页工具
 * 
 * @author zhuanglinxiang
 * 
 * @param <T1>
 *            查询条件
 * @param <T2>
 *            查询结果
 */
public class Pagination<T1, T2> implements Serializable {

	private static final long serialVersionUID = -4533785453545410315L;
	/**
	 * 每页条数
	 */
	private Integer pageSize = 20;
	/**
	 * 第几页
	 */
	private Long pageIndex = 1L;
	/**
	 * 查询起始，
	 */
	private Long start = 0L;
	/**
	 * 每次查询数，
	 */
	private Integer limit = 20;
	/**
	 * 页码总数，
	 */
	private Long pageTotal = 0L;
	/**
	 * 总记录数，
	 */
	private Long resultTotal = 0L;
	/**
	 * 查询条件，
	 */
	private T1 query;
	/**
	 * 查询结果，
	 */
	private List<T2> rows = new ArrayList<T2>(0);

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize ==null || pageSize < 1) {
			return;
		}
		this.pageSize = pageSize;
		this.limit = this.pageSize;
	}

	public Long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Long pageIndex) {
		if(pageIndex==null || pageIndex<1){
			return;
		}else{
			this.start = (pageIndex - 1) * this.pageSize;
			this.pageIndex = pageIndex;
		}
		
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		if(start ==null || start<1){
			this.pageIndex = 1L;
			this.start = 0L;
		}else{
			if(start==1){
				this.pageIndex =1L;
			}else{
				this.pageIndex = (start -1)/this.pageSize;
			}
			this.start = start;
		}
		
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		if (limit==null || limit < 1) {
			return;
		}
		this.limit = limit;
		this.pageSize = this.limit;
	}

	public Long getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Long pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Long getResultTotal() {
		return resultTotal;
	}

	public void setResultTotal(Long resultTotal) {
		this.resultTotal = resultTotal;
		this.pageTotal = this.resultTotal / this.pageSize;
		if (this.resultTotal % this.pageSize > 0) {
			this.pageTotal = this.pageTotal + 1;
		}
		if (this.pageTotal < this.pageIndex) {
			setPageIndex(this.pageTotal);
		}
	}

	public T1 getQuery() {
		return query;
	}

	/**
	 * 设置查询条件
	 * 
	 * @param query
	 */
	public void setQuery(T1 query) {
		this.query = query;
	}

	public List<T2> getRows() {
		return rows;
	}

	public void setRows(List<T2> rows) {
		if (rows != null) {
			this.rows = rows;
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
