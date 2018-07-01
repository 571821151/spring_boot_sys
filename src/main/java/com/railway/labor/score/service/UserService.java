package com.railway.labor.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.UserDAO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.dto.UserDTO;
import com.railway.labor.score.model.query.UserQuery;

@Service
public class UserService extends BaseService <UserQuery,UserDTO>{

	@Autowired
	public UserService(UserDAO userDAO) {
		super(userDAO);
	}
	public LoginInfoDTO login(String account, String password) {
		UserDAO userDAO = (UserDAO) super.getBaseDAO();
		return userDAO.login(account, password);
	}
}
