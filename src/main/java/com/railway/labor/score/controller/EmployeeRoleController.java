package com.railway.labor.score.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.score.common.BaseResult;
import com.railway.labor.score.common.ErrorEnum;
import com.railway.labor.score.common.Id;
import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.EmployeeRoleDTO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.query.EmployeeRoleQuery;
import com.railway.labor.score.service.EmployeeRoleService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/employeeRole")
public class EmployeeRoleController  extends BaseController{
	@Autowired
	private EmployeeRoleService employeeRoleService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list.json", "" })
	@ResponseBody
	public BaseResult<Pagination<EmployeeRoleQuery, EmployeeRoleDTO>> list(@RequestBody(required=false) EmployeeRoleQuery employeeRoleQuery) {
		BaseResult<Pagination<EmployeeRoleQuery, EmployeeRoleDTO>> baseResult = new BaseResult<>();
		Pagination<EmployeeRoleQuery, EmployeeRoleDTO> pagination = new Pagination<>();
		if(employeeRoleQuery==null){
			employeeRoleQuery = new EmployeeRoleQuery();
		}
		pagination.setQuery(employeeRoleQuery);
		pagination.setPageSize(employeeRoleQuery.getPageSize());
		pagination.setPageIndex(employeeRoleQuery.getPageIndex());
		
		try {
			pagination = employeeRoleService.query(pagination);
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

	
	@RequestMapping(value = "add.json")
	@ResponseBody
	public BaseResult<EmployeeRoleDTO> add(@RequestBody(required=false) EmployeeRoleDTO employeeRoleDTO) {
		BaseResult<EmployeeRoleDTO> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = getLoginInfoDTO();
			employeeRoleDTO.setCreator(loginInfo.getId());
			employeeRoleDTO.setCreateDate(new Date());
			employeeRoleDTO.setModifier(loginInfo.getId());
			employeeRoleDTO.setModifyDate(new Date());
			employeeRoleDTO.setDelFlag("0");
			employeeRoleService.insert(employeeRoleDTO);
			baseResult.setValue(employeeRoleDTO);
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
		}

		return baseResult;
	}
	
	
	@RequestMapping(value = "update.json")
	@ResponseBody
	public BaseResult<EmployeeRoleDTO> update(
			@RequestBody(required = false) EmployeeRoleDTO employeeRoleDTO) {
		logger.info("employeeRoleDTO={}", employeeRoleDTO);
		BaseResult<EmployeeRoleDTO> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = getLoginInfoDTO();
			employeeRoleDTO.setModifier(loginInfo.getId());
			employeeRoleDTO.setModifyDate(new Date());
			employeeRoleService.update(employeeRoleDTO);
			baseResult.setValue(employeeRoleDTO);
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
		}
		return baseResult;
	}
	
	@RequestMapping(value = "batchUpdate.json")
	@ResponseBody
	public BaseResult<Integer> batchUpdate(
			@RequestBody(required = false) List<EmployeeRoleDTO> employeeRoleDTOList) {
		logger.info("employeeRoleDTOList={}", employeeRoleDTOList);
		BaseResult<Integer> baseResult = new BaseResult<>();
		try {
			for (EmployeeRoleDTO employeeRoleDTO : employeeRoleDTOList) {
				LoginInfoDTO loginInfo = getLoginInfoDTO();
				employeeRoleDTO.setModifier(loginInfo.getId());
				employeeRoleDTO.setModifyDate(new Date());
				employeeRoleService.update(employeeRoleDTO);
			}
			baseResult.setValue(employeeRoleDTOList.size());
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
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
	public BaseResult<EmployeeRoleDTO> get(@RequestBody(required=false) Id id) {
		BaseResult<EmployeeRoleDTO> baseResult = new BaseResult<>();
		EmployeeRoleDTO employeeRoleDTO = null;
		try {
			employeeRoleDTO = employeeRoleService.get(id.getId());
			if (employeeRoleDTO == null) {
				baseResult.setErrorCode(ErrorEnum.USER_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.USER_NULL.getMsg());
			} else {
				baseResult.setValue(employeeRoleDTO);
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
		}

		return baseResult;
	}
	
	@RequestMapping(value = "delete.json")
	@ResponseBody
	public BaseResult<Integer> delete(@RequestBody(required = false) Id id) {
		logger.info("id={}", id);
		BaseResult<Integer> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = getLoginInfoDTO();
			EmployeeRoleDTO employeeRoleDTO = employeeRoleService.get(id.getId());
			if (employeeRoleDTO != null) {
				employeeRoleDTO.setModifier(loginInfo.getId());
				employeeRoleDTO.setModifyDate(new Date());
				int result = employeeRoleService.delete(employeeRoleDTO);
				if (result > 0) {
					baseResult.setValue(result);
					baseResult.setSuccess(true);
				} else {
					baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
					baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
				}
			} else {
				baseResult.setErrorCode(ErrorEnum.USER_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.USER_NULL.getMsg());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
		}
		return baseResult;
	}
}
