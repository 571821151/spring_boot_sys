package com.railway.labor.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.score.model.dto.PermissionDTO;
import com.railway.labor.score.model.query.PermissionQuery;

public interface PermissionMapper extends BaseMapper<PermissionQuery, PermissionDTO>{

	List<PermissionDTO> queryByIds(@Param("ids") List<Long> ids);

}
