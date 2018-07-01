package com.railway.labor.score.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.UserRoleMapper;
import com.railway.labor.score.model.dto.UserRoleDTO;
import com.railway.labor.score.model.query.UserRoleQuery;

@Service
public class UserRoleDAO extends BaseDAO <UserRoleQuery,UserRoleDTO>{
	@Autowired
	public UserRoleDAO(UserRoleMapper userRoleMapper) {
		super(userRoleMapper);
	}
}
