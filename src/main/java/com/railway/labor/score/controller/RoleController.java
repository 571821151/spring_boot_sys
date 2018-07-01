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
import com.railway.labor.score.model.dto.RoleDTO;
import com.railway.labor.score.model.query.RoleQuery;
import com.railway.labor.score.service.RoleService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
	@Autowired
	private RoleService roleService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list.json", "" })
	@ResponseBody
	public BaseResult<Pagination<RoleQuery, RoleDTO>> list(@RequestBody(required=false) RoleQuery roleQuery) {
		BaseResult<Pagination<RoleQuery, RoleDTO>> baseResult = new BaseResult<>();
		Pagination<RoleQuery, RoleDTO> pagination = new Pagination<>();
		if(roleQuery==null){
			roleQuery = new RoleQuery();
		}
		pagination.setQuery(roleQuery);
		pagination.setPageSize(roleQuery.getPageSize());
		pagination.setPageIndex(roleQuery.getPageIndex());
		
		try {
			pagination = roleService.query(pagination);
			if(pagination==null){
				baseResult.setErrorCode(ErrorEnum.ROLE_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.ROLE_NULL.getMsg());
			}else{
				baseResult.setSuccess(true);
				baseResult.setValue(pagination);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.ROLE_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.ROLE_QUERY_EXCEPTION.getMsg());
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
	public BaseResult<RoleDTO> get(@RequestBody(required=false) Id id) {
		BaseResult<RoleDTO> baseResult = new BaseResult<>();
		RoleDTO roleDTO = null;
		try {
			roleDTO = roleService.get(id.getId());
			if (roleDTO == null) {
				baseResult.setErrorCode(ErrorEnum.ROLE_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.ROLE_NULL.getMsg());
			} else {
				baseResult.setValue(roleDTO);
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.ROLE_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.ROLE_QUERY_EXCEPTION.getMsg());
		}

		return baseResult;
	}
}
