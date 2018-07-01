package com.railway.labor.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.EmployeeRoleDAO;
import com.railway.labor.score.model.dto.EmployeeRoleDTO;
import com.railway.labor.score.model.query.EmployeeRoleQuery;

@Service
public class EmployeeRoleService extends BaseService <EmployeeRoleQuery,EmployeeRoleDTO>{

	@Autowired
	public EmployeeRoleService(EmployeeRoleDAO employeeRoleDAO) {
		super(employeeRoleDAO);
	}
	
	public int updateByCondition(EmployeeRoleDTO employeeRoleDTO){
		EmployeeRoleDAO employeeRoleDAO = (EmployeeRoleDAO) super.getBaseDAO();
		return employeeRoleDAO.updateByCondition(employeeRoleDTO);
	}
}
