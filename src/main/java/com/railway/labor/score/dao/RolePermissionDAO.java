package com.railway.labor.score.dao;

import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.RolePermissionMapper;
import com.railway.labor.score.model.dto.RolePermissionDTO;
import com.railway.labor.score.model.query.RolePermissionQuery;

@Service
public class RolePermissionDAO extends BaseDAO <RolePermissionQuery,RolePermissionDTO>{
	
	public RolePermissionDAO(RolePermissionMapper rolePermissionMapper) {
		super(rolePermissionMapper);
	}
}
