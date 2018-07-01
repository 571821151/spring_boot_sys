package com.railway.labor.score.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.UserMapper;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.dto.UserDTO;
import com.railway.labor.score.model.query.UserQuery;

@Service
public class UserDAO extends BaseDAO <UserQuery,UserDTO>{
	@Autowired
	public UserDAO(UserMapper userMapper) {
		super(userMapper);
	}
	public LoginInfoDTO login(String account, String password) {
		UserMapper userMapper = (UserMapper) super.getBaseMapper();
		return userMapper.login(account, password);
	}
}
