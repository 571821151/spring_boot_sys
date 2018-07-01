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
import com.railway.labor.score.model.dto.PermissionDTO;
import com.railway.labor.score.model.query.PermissionQuery;
import com.railway.labor.score.service.PermissionService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController{
	@Autowired
	private PermissionService permissionService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<PermissionQuery, PermissionDTO>> list(@RequestBody(required=false) PermissionQuery permissionQuery) {
		BaseResult<Pagination<PermissionQuery, PermissionDTO>> baseResult = new BaseResult<>();
		Pagination<PermissionQuery, PermissionDTO> pagination = new Pagination<>();
		if(permissionQuery==null){
			permissionQuery = new PermissionQuery();
		}
		pagination.setQuery(permissionQuery);
		pagination.setPageSize(permissionQuery.getPageSize());
		pagination.setPageIndex(permissionQuery.getPageIndex());
		
		try {
			pagination = permissionService.query(pagination);
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
	@RequestMapping(value = "get")
	@ResponseBody
	public BaseResult<PermissionDTO> get(@RequestBody(required=false) Id id) {
		BaseResult<PermissionDTO> baseResult = new BaseResult<>();
		PermissionDTO permissionDTO = null;
		try {
			permissionDTO = permissionService.get(id.getId());
			if (permissionDTO == null) {
				baseResult.setErrorCode(ErrorEnum.USER_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.USER_NULL.getMsg());
			} else {
				baseResult.setValue(permissionDTO);
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
