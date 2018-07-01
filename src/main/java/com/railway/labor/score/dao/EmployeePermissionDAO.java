package com.railway.labor.score.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.EmployeePermissionMapper;
import com.railway.labor.score.model.dto.EmployeePermissionDTO;
import com.railway.labor.score.model.query.EmployeePermissionQuery;

@Service
public class EmployeePermissionDAO extends BaseDAO <EmployeePermissionQuery,EmployeePermissionDTO> {
	
	@Autowired
	public EmployeePermissionDAO(EmployeePermissionMapper employeePermissionMapper) {
		super(employeePermissionMapper);
	}
}
