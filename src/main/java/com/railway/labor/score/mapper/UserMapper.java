package com.railway.labor.score.mapper;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.dto.UserDTO;
import com.railway.labor.score.model.query.UserQuery;

public interface UserMapper extends BaseMapper<UserQuery, UserDTO>{

	LoginInfoDTO login(@Param("account") String account,
			@Param("password") String password);

}
