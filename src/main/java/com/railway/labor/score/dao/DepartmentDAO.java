package com.railway.labor.score.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.DepartmentMapper;
import com.railway.labor.score.model.dto.DepartmentDTO;
import com.railway.labor.score.model.query.DepartmentQuery;

@Service
public class DepartmentDAO extends BaseDAO <DepartmentQuery,DepartmentDTO> {
	
	@Autowired
	public DepartmentDAO(DepartmentMapper departmentMapper) {
		super(departmentMapper);
	}
	
	public List<DepartmentDTO> getByName(String name) {
		DepartmentMapper departmentMapper = (DepartmentMapper) super.getBaseMapper();
		return departmentMapper.getByName(name);
	}

}
