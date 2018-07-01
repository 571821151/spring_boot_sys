package com.railway.labor.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.EmployeeDTO;
import com.railway.labor.score.model.dto.EmployeeRoleDTO;
import com.railway.labor.score.model.dto.RoleDTO;
import com.railway.labor.score.model.query.EmployeeRoleQuery;

public interface EmployeeRoleMapper extends BaseMapper<EmployeeRoleQuery, EmployeeRoleDTO>{

	List<RoleDTO> queryRoles(@Param("query") EmployeeRoleQuery query, @Param("pagination") Pagination<EmployeeRoleQuery, RoleDTO> pagination);

	List<EmployeeDTO> queryEmployees(@Param("query") EmployeeRoleQuery query, @Param("pagination") Pagination<EmployeeRoleQuery, RoleDTO> pagination);

	int updateByCondition(EmployeeRoleDTO employeeRoleDTO);
	
}
