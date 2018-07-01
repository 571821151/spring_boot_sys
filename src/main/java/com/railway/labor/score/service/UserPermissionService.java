package com.railway.labor.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.UserPermissionDAO;
import com.railway.labor.score.model.dto.UserPermissionDTO;
import com.railway.labor.score.model.query.UserPermissionQuery;

@Service
public class UserPermissionService extends BaseService <UserPermissionQuery,UserPermissionDTO>{

	@Autowired
	public UserPermissionService(UserPermissionDAO userPermissionDAO) {
		super(userPermissionDAO);
	}
}
