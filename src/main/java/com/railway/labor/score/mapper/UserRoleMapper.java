package com.railway.labor.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.RoleDTO;
import com.railway.labor.score.model.dto.UserDTO;
import com.railway.labor.score.model.dto.UserRoleDTO;
import com.railway.labor.score.model.query.UserRoleQuery;

public interface UserRoleMapper extends BaseMapper<UserRoleQuery, UserRoleDTO>{

	List<RoleDTO> queryRoles(@Param("query") UserRoleQuery query, @Param("pagination") Pagination<UserRoleQuery, RoleDTO> pagination);

	List<UserDTO> queryUsers(@Param("query") UserRoleQuery query, @Param("pagination") Pagination<UserRoleQuery, RoleDTO> pagination);

}
