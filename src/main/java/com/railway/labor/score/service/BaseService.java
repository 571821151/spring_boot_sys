package com.railway.labor.score.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.dao.BaseDAO;
import com.railway.labor.score.model.dto.BaseDTO;

public class BaseService <T1,T2>{
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private final BaseDAO <T1,T2> baseDAO;

	public BaseService(BaseDAO <T1,T2> baseDAO) {
		this.baseDAO = baseDAO;
	}
	
	public BaseDAO<T1, T2> getBaseDAO() {
		return baseDAO;
	}

	public Pagination<T1, T2> query(Pagination<T1, T2> pagination) {
		return baseDAO.query(pagination);
	}

	public List<T2> query(T1 query) {
		return baseDAO.query(query);
	}
	
	public T2 get(Long id) {
		return baseDAO.get(id);
	}

	public void insert(T2 dto) {
		baseDAO.insert(dto);
	}

	public int update(T2 dto) {
		return baseDAO.update(dto);
	}
	
	public int delete(T2 dto) {
		BaseDTO baseDTO = (BaseDTO) dto;
		baseDTO.setDelFlag("1");
		return baseDAO.update(dto);
	}
	void delete(Long id) {
		baseDAO.delete(id);
	}
}
