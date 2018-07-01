package com.railway.labor.score.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.EmployeeMapper;
import com.railway.labor.score.model.dto.EmployeeDTO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.query.EmployeeQuery;

@Service
public class EmployeeDAO extends BaseDAO <EmployeeQuery,EmployeeDTO>{
	
	@Autowired
	public EmployeeDAO(EmployeeMapper employeeMapper) {
		super(employeeMapper);
	}
	
	public LoginInfoDTO login(String jobNumber, String password) {
		EmployeeMapper employeeMapper = (EmployeeMapper) super.getBaseMapper();
		return employeeMapper.login(jobNumber, password);
	}
	
	public EmployeeDTO getByJobNumber(String jobNumber){
		EmployeeMapper employeeMapper = (EmployeeMapper) super.getBaseMapper();
		return employeeMapper.getByJobNumber(jobNumber);
	}

	public void batchInsert(List<EmployeeDTO> employeeDTOList) {
		EmployeeMapper employeeMapper = (EmployeeMapper) super.getBaseMapper();
		employeeMapper.batchInsert(employeeDTOList);
	}
	
	public int batchUpdate(List<EmployeeDTO> employeeDTOList){
		EmployeeMapper employeeMapper = (EmployeeMapper) super.getBaseMapper();
		return employeeMapper.batchUpdate(employeeDTOList);
	}
	
	public int updatePassword(String password, Long id) {
		EmployeeMapper employeeMapper = (EmployeeMapper) super.getBaseMapper();
		return employeeMapper.updatePassword(password, id);
	}
}
