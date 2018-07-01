package com.railway.labor.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.UserRoleDAO;
import com.railway.labor.score.model.dto.UserRoleDTO;
import com.railway.labor.score.model.query.UserRoleQuery;

@Service
public class UserRoleService extends BaseService <UserRoleQuery,UserRoleDTO>{

	@Autowired
	public UserRoleService(UserRoleDAO userRoleDAO) {
		super(userRoleDAO);
	}
}
