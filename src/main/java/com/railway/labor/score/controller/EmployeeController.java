package com.railway.labor.score.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.score.common.BaseResult;
import com.railway.labor.score.common.ErrorEnum;
import com.railway.labor.score.common.Id;
import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.DepartmentDTO;
import com.railway.labor.score.model.dto.EmployeeDTO;
import com.railway.labor.score.model.dto.EmployeeRoleDTO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.dto.RoleDTO;
import com.railway.labor.score.model.dto.TeamDTO;
import com.railway.labor.score.model.query.EmployeeQuery;
import com.railway.labor.score.service.DepartmentService;
import com.railway.labor.score.service.EmployeeRoleService;
import com.railway.labor.score.service.EmployeeService;
import com.railway.labor.score.service.RoleService;
import com.railway.labor.score.service.TeamService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController  extends BaseController{
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private EmployeeRoleService employeeRoleService;
	
	private static final String  EMPLOYEE_ROLE = "普通员工";
	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list.json", "" })
	@ResponseBody
	public BaseResult<Pagination<EmployeeQuery, EmployeeDTO>> list(@RequestBody(required=false) EmployeeQuery employeeQuery) {
		BaseResult<Pagination<EmployeeQuery, EmployeeDTO>> baseResult = new BaseResult<>();
		Pagination<EmployeeQuery, EmployeeDTO> pagination = new Pagination<>();
		if(employeeQuery==null){
			employeeQuery = new EmployeeQuery();
		}
		pagination.setQuery(employeeQuery);
		pagination.setPageSize(employeeQuery.getPageSize());
		pagination.setPageIndex(employeeQuery.getPageIndex());
		
		try {
			pagination = employeeService.query(pagination);
			if(pagination==null){
				baseResult.setErrorCode(ErrorEnum.EMPLOYEE_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_NULL.getMsg());
			}else{
				baseResult.setSuccess(true);
				baseResult.setValue(pagination);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getMsg());
		}
	
		return baseResult;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getByEmployeeJobNumber.json")
	@ResponseBody
	public BaseResult<EmployeeDTO> getByEmployeeJobNumber(@RequestBody(required=false) EmployeeQuery employeeQuery) {
		BaseResult<EmployeeDTO> baseResult = new BaseResult<>();
		EmployeeDTO employeeDTO = null;
		try {
			employeeDTO = employeeService.getByJobNumber(employeeQuery.getEmployeeJobNumber());
			if (employeeDTO == null) {
				baseResult.setErrorCode(ErrorEnum.EMPLOYEE_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_NULL.getMsg());
			} else {
				baseResult.setValue(employeeDTO);
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getMsg());
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
	public BaseResult<EmployeeDTO> get(@RequestBody(required=false) Id id) {
		BaseResult<EmployeeDTO> baseResult = new BaseResult<>();
		EmployeeDTO employeeDTO = null;
		try {
			employeeDTO = employeeService.get(id.getId());
			if (employeeDTO == null) {
				baseResult.setErrorCode(ErrorEnum.EMPLOYEE_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_NULL.getMsg());
			} else {
				baseResult.setValue(employeeDTO);
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getMsg());
		}

		return baseResult;
	}
	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "batchAdd.json")
	@ResponseBody
	public BaseResult<Object> batchAdd(@RequestBody(required=false) List<EmployeeDTO> employeeDTOList) {
		BaseResult<Object> baseResult = new BaseResult<>();
		try {
			logger.info("employeeDTOList={}",employeeDTOList);
			LoginInfoDTO loginInfo = getLoginInfoDTO();
			List<DepartmentDTO> departmentDTOList = null;
			List<TeamDTO> teamDTOList = null;
			DepartmentDTO departmentDTO = null;
			TeamDTO teamDTO = null;
			if(CollectionUtils.isNotEmpty(employeeDTOList)){
				for (EmployeeDTO employeeDTO : employeeDTOList) {
					
//					EmployeeDTO employeeDTO2 = employeeService.getByJobNumber(employeeDTO.getEmployeeJobNumber());
//					if(employeeDTO2!=null){
//						 baseResult.setErrorCode(ErrorEnum.EMPLOYEE_EXSIT.getCode());
//						 baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_EXSIT.getMsg() + ":工号 " + employeeDTO.getEmployeeJobNumber());
//						 return baseResult;
//					}
					
					departmentDTOList = departmentService.getByName(employeeDTO.getDepartmentName());
					if(CollectionUtils.isEmpty(departmentDTOList)){
//						 baseResult.setErrorCode(ErrorEnum.DEPARTMENT_NULL.getCode());
//						 baseResult.setErrorMsg(ErrorEnum.DEPARTMENT_NULL.getMsg() + ":部门 " + employeeDTO.getDepartmentName());
//						 return baseResult;
							departmentDTO = new DepartmentDTO();
							departmentDTO.setName(employeeDTO.getDepartmentName());
							departmentDTO.setCreator(loginInfo.getId());
							departmentDTO.setCreateDate(new Date());
							departmentDTO.setModifier(loginInfo.getId());
							departmentDTO.setModifyDate(new Date());
							departmentDTO.setDelFlag("0");
							departmentService.insert(departmentDTO);
					}else{
						departmentDTO = departmentDTOList.get(0);
					}
					
					teamDTOList = teamService.getByName(employeeDTO.getTeamName(),departmentDTO.getId());
					if(CollectionUtils.isEmpty(teamDTOList)){
//						 baseResult.setErrorCode(ErrorEnum.TEAM_NULL.getCode());
//						 baseResult.setErrorMsg(ErrorEnum.TEAM_NULL.getMsg() + ":工号 " + employeeDTO.getEmployeeJobNumber());
//						 return baseResult;
						teamDTO = new TeamDTO();
						teamDTO.setDepartmentId(departmentDTO.getId());
						teamDTO.setName(employeeDTO.getTeamName());
						teamDTO.setCreator(loginInfo.getId());
						teamDTO.setCreateDate(new Date());
						teamDTO.setModifier(loginInfo.getId());
						teamDTO.setModifyDate(new Date());
						teamDTO.setDelFlag("0");
						teamService.insert(teamDTO);
					}else{
						teamDTO = teamDTOList.get(0);
					}
					//employeeDTO.setPassword(EncryptUtil.entrypt(employeeDTO.getEmployeeJobNumber()));
					employeeDTO.setPassword(employeeDTO.getEmployeeJobNumber());
					employeeDTO.setTeamId(teamDTO.getId());
					employeeDTO.setDepartmentId(departmentDTO.getId());
					employeeDTO.setCreator(loginInfo.getId());
					employeeDTO.setCreateDate(new Date());
					employeeDTO.setModifier(loginInfo.getId());
					employeeDTO.setModifyDate(new Date());
					employeeDTO.setDelFlag("0");
				}
				
				List<RoleDTO> roleDTOList = roleService.getByName(EMPLOYEE_ROLE);
				RoleDTO roleDTO;
				if(CollectionUtils.isEmpty(roleDTOList)){
					baseResult.setErrorCode(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getCode());
					baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getMsg());
					return baseResult;
				}else{
					roleDTO = roleDTOList.get(0);
				}
				//employeeService.batchInsert(employeeDTOList);
				EmployeeRoleDTO employeeRoleDTO = new EmployeeRoleDTO();
				employeeRoleDTO.setCreator(loginInfo.getId());
				employeeRoleDTO.setCreateDate(new Date());
				employeeRoleDTO.setModifier(loginInfo.getId());
				employeeRoleDTO.setModifyDate(new Date());
				//EmployeeRoleDTO deleteEmployeeRoleDTO = new EmployeeRoleDTO();
				for (EmployeeDTO employeeDTO : employeeDTOList) {
					EmployeeDTO employeeDTO2 = employeeService.getByJobNumber(employeeDTO.getEmployeeJobNumber());
					if(employeeDTO2!=null){
						logger.info("员工已存在，更新");
						 //baseResult.setErrorCode(ErrorEnum.EMPLOYEE_EXSIT.getCode());
						 //baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_EXSIT.getMsg() + ":工号 " + employeeDTO.getEmployeeJobNumber());
						 //return baseResult;
						teamDTO.setCreator(null);
						teamDTO.setCreateDate(null);
						employeeDTO.setPassword(null);
						employeeDTO.setPositionId(null);
						employeeDTO.setDelFlag(null);
						employeeDTO.setId(employeeDTO2.getId());
						employeeService.update(employeeDTO);
					}else{
						employeeService.insert(employeeDTO);
//						deleteEmployeeRoleDTO.setEmployeeId(employeeDTO.getId());
//						deleteEmployeeRoleDTO.setDelFlag("1");
//						employeeRoleService.updateByCondition(deleteEmployeeRoleDTO);
						
						employeeRoleDTO.setEmployeeId(employeeDTO.getId());
						employeeRoleDTO.setRoleId(roleDTO.getId());
						employeeRoleService.insert(employeeRoleDTO);
					}
					
				}
				baseResult.setSuccess(true);
			}else{
				baseResult.setErrorCode(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getCode());
				baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getMsg());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getMsg());
		}
		return baseResult;
	}
	
	@RequestMapping(value = "batchUpdate.json")
	@ResponseBody
	public BaseResult<Object> batchUpdate(@RequestBody(required=false) List<EmployeeDTO> employeeDTOList) {
		BaseResult<Object> baseResult = new BaseResult<>();
		try {
			logger.info("employeeDTOList={}",employeeDTOList);
			LoginInfoDTO loginInfo = getLoginInfoDTO();
			List<DepartmentDTO> departmentDTOList = null;
			List<TeamDTO> teamDTOList = null;
			DepartmentDTO departmentDTO = null;
			TeamDTO teamDTO = null;
			if(CollectionUtils.isNotEmpty(employeeDTOList)){
				for (EmployeeDTO employeeDTO : employeeDTOList) {
					
					EmployeeDTO employeeDTO2 = employeeService.getByJobNumber(employeeDTO.getEmployeeJobNumber());
					if(employeeDTO2==null){
						 baseResult.setErrorCode(ErrorEnum.EMPLOYEE_NULL.getCode());
						 baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_NULL.getMsg() + ":工号 " + employeeDTO.getEmployeeJobNumber());
						 return baseResult;
					}
					
					departmentDTOList = departmentService.getByName(employeeDTO.getDepartmentName());
					if(CollectionUtils.isEmpty(departmentDTOList)){
						 departmentDTO = new DepartmentDTO();
							departmentDTO.setName(employeeDTO.getDepartmentName());
							departmentDTO.setCreator(loginInfo.getId());
							departmentDTO.setCreateDate(new Date());
							departmentDTO.setModifier(loginInfo.getId());
							departmentDTO.setModifyDate(new Date());
							departmentDTO.setDelFlag("0");
							departmentService.insert(departmentDTO);
					}else{
						departmentDTO = departmentDTOList.get(0);
					}
					
					teamDTOList = teamService.getByName(employeeDTO.getTeamName(),departmentDTO.getId());
					if(CollectionUtils.isEmpty(teamDTOList)){
						teamDTO = new TeamDTO();
						teamDTO.setDepartmentId(departmentDTO.getId());
						teamDTO.setName(employeeDTO.getTeamName());
						teamDTO.setCreator(loginInfo.getId());
						teamDTO.setCreateDate(new Date());
						teamDTO.setModifier(loginInfo.getId());
						teamDTO.setModifyDate(new Date());
						teamDTO.setDelFlag("0");
						teamService.insert(teamDTO);
					}else{
						teamDTO = teamDTOList.get(0);
					}
					employeeDTO.setId(employeeDTO2.getId());
					employeeDTO.setPassword(null);
					employeeDTO.setPositionId(null);
					employeeDTO.setTeamId(teamDTO.getId());
					employeeDTO.setDepartmentId(departmentDTO.getId());
					employeeDTO.setModifier(loginInfo.getId());
					employeeDTO.setModifyDate(new Date());
					employeeDTO.setDelFlag(null);
				}
				
				for (EmployeeDTO employeeDTO : employeeDTOList) {
					employeeService.update(employeeDTO);
				}
				//employeeService.batchUpdate(employeeDTOList);
				
				baseResult.setSuccess(true);
			}else{
				baseResult.setErrorCode(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getCode());
				baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getMsg());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_QUERY_EXCEPTION.getMsg());
		}
		return baseResult;
	}
}
