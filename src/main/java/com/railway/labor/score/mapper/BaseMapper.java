package com.railway.labor.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.score.common.Pagination;

public interface BaseMapper<T1,T2> {

	List<T2> query(@Param("query") T1 query, @Param("pagination") Pagination<T1, T2> pagination);
	
	Long count(@Param("query") T1 query);

	T2 get(Long id);

	void insert(T2 dto);

	int update(T2 dto);

	void delete(Long id);
}
