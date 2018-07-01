package com.railway.labor.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.DepartmentDAO;
import com.railway.labor.score.model.dto.DepartmentDTO;
import com.railway.labor.score.model.query.DepartmentQuery;

@Service
public class DepartmentService extends BaseService <DepartmentQuery,DepartmentDTO>{

	@Autowired
	public DepartmentService(DepartmentDAO departmentDAO) {
		super(departmentDAO);
	}
	public List<DepartmentDTO> getByName(String name) {
		DepartmentDAO departmentDAO = (DepartmentDAO) super.getBaseDAO();
		return departmentDAO.getByName(name);
	}
	
}
