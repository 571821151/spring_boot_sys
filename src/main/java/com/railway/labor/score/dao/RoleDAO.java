package com.railway.labor.score.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.RoleMapper;
import com.railway.labor.score.model.dto.RoleDTO;
import com.railway.labor.score.model.query.RoleQuery;

@Service
public class RoleDAO extends BaseDAO <RoleQuery,RoleDTO>{
	
	@Autowired
	public RoleDAO(RoleMapper roleMapper) {
		super(roleMapper);
	}
	
	public List<RoleDTO> getByName(String name){
		RoleMapper roleMapper = (RoleMapper) super.getBaseMapper();
		return roleMapper.getByName(name);
	}
}
