package com.railway.labor.score.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.TeamMapper;
import com.railway.labor.score.model.dto.TeamDTO;
import com.railway.labor.score.model.query.TeamQuery;

@Service
public class TeamDAO extends BaseDAO <TeamQuery,TeamDTO>{
	
	@Autowired
	public TeamDAO(TeamMapper teamMapper) {
		super(teamMapper);
	}
	public List<TeamDTO> getByName(String name, Long departmentId) {
		TeamMapper teamMapper = (TeamMapper) super.getBaseMapper();
		return teamMapper.getByName(name, departmentId);
	}
	
}
