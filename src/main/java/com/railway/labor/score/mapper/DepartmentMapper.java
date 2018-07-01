package com.railway.labor.score.mapper;

import java.util.List;

import com.railway.labor.score.model.dto.DepartmentDTO;
import com.railway.labor.score.model.query.DepartmentQuery;

public interface DepartmentMapper extends BaseMapper<DepartmentQuery, DepartmentDTO>{
	List<DepartmentDTO> getByName(String name);
}
