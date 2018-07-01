package com.railway.labor.score.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.PermissionMapper;
import com.railway.labor.score.model.dto.PermissionDTO;
import com.railway.labor.score.model.query.PermissionQuery;

@Service
public class PermissionDAO extends BaseDAO <PermissionQuery,PermissionDTO>{
	
	@Autowired
	public PermissionDAO(PermissionMapper permissionMapper) {
		super(permissionMapper);
	}
	public List<PermissionDTO> queryByIds(List<Long> ids) {
		if(CollectionUtils.isEmpty(ids)){
			return new ArrayList<>(0);
		}
		PermissionMapper permissionMapper = (PermissionMapper) super.getBaseMapper();
		return permissionMapper.queryByIds(ids);
	}
}
