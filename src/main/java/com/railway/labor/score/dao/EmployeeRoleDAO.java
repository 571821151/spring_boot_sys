package com.railway.labor.score.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.EmployeeRoleMapper;
import com.railway.labor.score.model.dto.EmployeeRoleDTO;
import com.railway.labor.score.model.query.EmployeeRoleQuery;

@Service
public class EmployeeRoleDAO extends BaseDAO <EmployeeRoleQuery,EmployeeRoleDTO>{
	
	@Autowired
	public EmployeeRoleDAO(EmployeeRoleMapper employeeRoleMapper) {
		super(employeeRoleMapper);
	}
	
	public int updateByCondition(EmployeeRoleDTO employeeRoleDTO){
		EmployeeRoleMapper employeeRoleMapper = (EmployeeRoleMapper) super.getBaseMapper();
		return employeeRoleMapper.updateByCondition(employeeRoleDTO);
	}
	
}
