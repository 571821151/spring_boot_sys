package com.railway.labor.score.mapper;

import java.util.List;

import com.railway.labor.score.model.dto.RoleDTO;
import com.railway.labor.score.model.query.RoleQuery;

public interface RoleMapper extends BaseMapper<RoleQuery, RoleDTO>{

	List<RoleDTO> getByName(String name);
	
}
