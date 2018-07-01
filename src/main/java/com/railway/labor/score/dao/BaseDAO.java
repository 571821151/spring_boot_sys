package com.railway.labor.score.dao;

import java.util.List;

import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.mapper.BaseMapper;

public class BaseDAO <T1,T2> {
	
	private final BaseMapper<T1,T2> baseMapper;
	
	public BaseDAO(BaseMapper<T1,T2> baseMapper) {
		this.baseMapper = baseMapper;
	}
	
	public BaseMapper<T1, T2> getBaseMapper() {
		return baseMapper;
	}

	public Long count(T1 query) {
		return baseMapper.count(query);
	}
	
	public Pagination<T1, T2> query(Pagination<T1, T2> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<T2> list = baseMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(list);
		
		return pagination;
	}
	
	public List<T2> query(T1 query) {
		return baseMapper.query(query,null);
	}
	
	public T2 get(Long id) {
		return baseMapper.get(id);
	}

	public void insert(T2 dto) {
		baseMapper.insert(dto);
	}

	public int update(T2 dto) {
		return baseMapper.update(dto);
	}

	public void delete(Long id) {
		baseMapper.delete(id);
	}
	
	public BaseMapper<T1,T2> getMapper(){
		return baseMapper;
	}
}
