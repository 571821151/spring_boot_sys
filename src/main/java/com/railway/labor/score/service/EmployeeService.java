package com.railway.labor.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.EmployeeDAO;
import com.railway.labor.score.model.dto.EmployeeDTO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.query.EmployeeQuery;

@Service
public class EmployeeService extends BaseService <EmployeeQuery,EmployeeDTO>{

	@Autowired
	public EmployeeService(EmployeeDAO employeeDAO) {
		super(employeeDAO);
	}
	public LoginInfoDTO login(String jobNumber, String password) {
		EmployeeDAO employeeDAO = (EmployeeDAO) super.getBaseDAO();
		return employeeDAO.login(jobNumber, password);
	}
	
	public EmployeeDTO getByJobNumber(String jobNumber){
		EmployeeDAO employeeDAO = (EmployeeDAO) super.getBaseDAO();
		return employeeDAO.getByJobNumber(jobNumber);
	}
	
	public void batchInsert(List<EmployeeDTO> employeeDTOList) {
		EmployeeDAO employeeDAO = (EmployeeDAO) super.getBaseDAO();
		employeeDAO.batchInsert(employeeDTOList);
	}
	
	public int batchUpdate(List<EmployeeDTO> employeeDTOList){
		EmployeeDAO employeeDAO = (EmployeeDAO) super.getBaseDAO();
		return employeeDAO.batchUpdate(employeeDTOList);
	}
	public int updatePassword(String password, Long id) {
		EmployeeDAO employeeDAO = (EmployeeDAO) super.getBaseDAO();
		return employeeDAO.updatePassword(password, id);
	}

}
