package com.railway.labor.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.EmployeePermissionDAO;
import com.railway.labor.score.model.dto.EmployeePermissionDTO;
import com.railway.labor.score.model.query.EmployeePermissionQuery;

@Service
public class EmployeePermissionService extends BaseService <EmployeePermissionQuery,EmployeePermissionDTO>{

	@Autowired
	public EmployeePermissionService(EmployeePermissionDAO employeePermissionDAO) {
		super(employeePermissionDAO);
	}
}
