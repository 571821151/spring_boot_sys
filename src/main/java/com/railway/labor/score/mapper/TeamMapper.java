package com.railway.labor.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.score.model.dto.TeamDTO;
import com.railway.labor.score.model.query.TeamQuery;

public interface TeamMapper extends BaseMapper<TeamQuery, TeamDTO>{
	List<TeamDTO> getByName(@Param("name") String name, @Param("departmentId") Long departmentId);
}
