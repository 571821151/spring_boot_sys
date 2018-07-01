package com.railway.labor.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.TeamDAO;
import com.railway.labor.score.model.dto.TeamDTO;
import com.railway.labor.score.model.query.TeamQuery;

@Service
public class TeamService extends BaseService <TeamQuery,TeamDTO>{

	@Autowired
	public TeamService(TeamDAO teamDAO) {
		super(teamDAO);
	}
	
	public List<TeamDTO> getByName(String name, Long departmentId) {
		TeamDAO teamDAO = (TeamDAO) super.getBaseDAO();
		return teamDAO.getByName(name, departmentId);
	}
	
}
