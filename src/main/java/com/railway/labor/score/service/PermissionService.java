package com.railway.labor.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.PermissionDAO;
import com.railway.labor.score.model.dto.PermissionDTO;
import com.railway.labor.score.model.query.PermissionQuery;

@Service
public class PermissionService extends BaseService <PermissionQuery,PermissionDTO>{

	@Autowired
	public PermissionService(PermissionDAO permissionDAO) {
		super(permissionDAO);
	}
	
	public List<PermissionDTO> queryByIds(List<Long> ids) {
		PermissionDAO permissionDAO = (PermissionDAO) super.getBaseDAO();
		return permissionDAO.queryByIds(ids);
	}
	
}
