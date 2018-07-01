package com.railway.labor.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.score.model.dto.EmployeeDTO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.query.EmployeeQuery;

public interface EmployeeMapper extends BaseMapper<EmployeeQuery, EmployeeDTO>{

	LoginInfoDTO login(@Param("jobNumber") String jobNumber,
			@Param("password") String password);
	
	EmployeeDTO getByJobNumber(String jobNumber);

	void batchInsert(@Param("employeeDTOList") List<EmployeeDTO> employeeDTOList);

	int batchUpdate(@Param("employeeDTOList") List<EmployeeDTO> employeeDTOList);
	
	int updatePassword(@Param("password") String password, @Param("id") Long id);
	
}
