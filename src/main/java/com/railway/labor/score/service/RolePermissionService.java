package com.railway.labor.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.RolePermissionDAO;
import com.railway.labor.score.model.dto.RolePermissionDTO;
import com.railway.labor.score.model.query.RolePermissionQuery;

@Service
public class RolePermissionService extends BaseService <RolePermissionQuery,RolePermissionDTO>{

	@Autowired
	public RolePermissionService(RolePermissionDAO rolePermissionDAO) {
		super(rolePermissionDAO);
	}
}
