package com.railway.labor.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.score.common.BaseResult;
import com.railway.labor.score.common.ErrorEnum;
import com.railway.labor.score.common.Id;
import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.UserDTO;
import com.railway.labor.score.model.query.UserQuery;
import com.railway.labor.score.service.UserService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list.json", "" })
	@ResponseBody
	public BaseResult<Pagination<UserQuery, UserDTO>> list(@RequestBody(required=false) UserQuery userQuery) {
		BaseResult<Pagination<UserQuery, UserDTO>> baseResult = new BaseResult<>();
		Pagination<UserQuery, UserDTO> pagination = new Pagination<>();
		if(userQuery==null){
			userQuery = new UserQuery();
		}
		pagination.setQuery(userQuery);
		pagination.setPageSize(userQuery.getPageSize());
		pagination.setPageIndex(userQuery.getPageIndex());
		
		try {
			pagination = userService.query(pagination);
			if(pagination==null){
				baseResult.setErrorCode(ErrorEnum.USER_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.USER_NULL.getMsg());
			}else{
				baseResult.setSuccess(true);
				baseResult.setValue(pagination);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
		}
	
		return baseResult;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "get.json")
	@ResponseBody
	public BaseResult<UserDTO> get(@RequestBody(required=false) Id id) {
		BaseResult<UserDTO> baseResult = new BaseResult<>();
		UserDTO userDTO = null;
		try {
			userDTO = userService.get(id.getId());
			if (userDTO == null) {
				baseResult.setErrorCode(ErrorEnum.USER_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.USER_NULL.getMsg());
			} else {
				baseResult.setValue(userDTO);
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
		}

		return baseResult;
	}
}
