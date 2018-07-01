package com.railway.labor.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.RoleDAO;
import com.railway.labor.score.model.dto.RoleDTO;
import com.railway.labor.score.model.query.RoleQuery;

@Service
public class RoleService extends BaseService <RoleQuery,RoleDTO>{

	@Autowired
	public RoleService(RoleDAO roleDAO) {
		super(roleDAO);
	}
	public List<RoleDTO> getByName(String name){
		RoleDAO roleDAO = (RoleDAO) super.getBaseDAO();
		return roleDAO.getByName(name);
	}
}
