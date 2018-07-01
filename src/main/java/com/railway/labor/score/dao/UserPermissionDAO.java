package com.railway.labor.score.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.UserPermissionMapper;
import com.railway.labor.score.model.dto.UserPermissionDTO;
import com.railway.labor.score.model.query.UserPermissionQuery;

@Service
public class UserPermissionDAO extends BaseDAO <UserPermissionQuery,UserPermissionDTO>{
	@Autowired
	public UserPermissionDAO(UserPermissionMapper userPermissionMapper) {
		super(userPermissionMapper);
	}
}
