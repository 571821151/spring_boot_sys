package com.railway.labor.score.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.score.common.BaseResult;
import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.DepartmentDTO;
import com.railway.labor.score.model.dto.EmployeeRoleDTO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.dto.TeamDTO;
import com.railway.labor.score.model.dto.UserRoleDTO;
import com.railway.labor.score.model.query.EmployeeRoleQuery;
import com.railway.labor.score.model.query.LoginInfoQuery;
import com.railway.labor.score.model.query.UserRoleQuery;
import com.railway.labor.score.service.DepartmentService;
import com.railway.labor.score.service.EmployeeRoleService;
import com.railway.labor.score.service.EmployeeService;
import com.railway.labor.score.service.TeamService;
import com.railway.labor.score.service.UserRoleService;
import com.railway.labor.score.service.UserService;

/**
 * 登录
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
public class LoginController extends BaseController{
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRoleService employeeRoleService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping("/")
	@ResponseBody
	BaseResult<String> home() {
		BaseResult<String> baseResult = new BaseResult<>();
		baseResult.setSuccess(false);
		baseResult.setErrorCode("0001");
		baseResult.setErrorMsg("请登录");
		return baseResult;
	}

	@RequestMapping("/login.json")
	@ResponseBody
	BaseResult<LoginInfoDTO> login(@RequestBody(required=false) LoginInfoQuery loginInfoQuery) {
		BaseResult<LoginInfoDTO> baseResult = new BaseResult<>();
		baseResult.setSuccess(false);
		if(loginInfoQuery==null|| StringUtils.isBlank(loginInfoQuery.getAccount())){
			baseResult.setErrorCode("0001");
			baseResult.setErrorMsg("请登录");
			return baseResult;
		}
		Map<String,Object> loginSession = new HashMap<>();
		LoginInfoDTO loginInfoDTO = null;
		try {
//			loginInfoDTO = userService.login(loginInfoQuery.getAccount(),EncryptUtil.entrypt(loginInfoQuery.getPassword()));
			loginInfoDTO = userService.login(loginInfoQuery.getAccount(),loginInfoQuery.getPassword());
			if(loginInfoDTO!=null){
				loginInfoDTO.setLoginType( "user");
				loginInfoDTO.setEmployeeJobNumber(loginInfoDTO.getUserAccount());
				loginInfoDTO.setEmployeeName(loginInfoDTO.getUserName());
				loginSession.put("loginInfoDTO", loginInfoDTO);
				request.getSession().setAttribute("loginSession", loginSession);
				UserRoleQuery userRoleQuery = new UserRoleQuery();
				userRoleQuery.setUserId(loginInfoDTO.getId());
				Pagination<UserRoleQuery, UserRoleDTO> userRoleDTOPagination = new Pagination<>();
				userRoleDTOPagination.setQuery(userRoleQuery);
				userRoleDTOPagination.setPageSize(10000);
				userRoleDTOPagination.setPageIndex(0L);
				userRoleDTOPagination = userRoleService.query(userRoleDTOPagination);
				List<Map<String, Object>> roleList = new ArrayList<>(userRoleDTOPagination.getRows().size());
				Map<String, Object> roleMap = null;
				for (UserRoleDTO userRoleDTO : userRoleDTOPagination.getRows()) {
					roleMap = new HashMap<>();
					roleMap.put("roleId", userRoleDTO.getRoleId());
					roleMap.put("roleName", userRoleDTO.getRoleName());
					roleList.add(roleMap);
				}
				loginInfoDTO.setRoleList(roleList);
				baseResult.setSuccess(true);
				baseResult.setValue(loginInfoDTO);
				return baseResult;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		try {
//			loginInfoDTO = employeeService.login(loginInfoQuery.getAccount(),
//					EncryptUtil.entrypt(loginInfoQuery.getPassword()));
			loginInfoDTO = employeeService.login(loginInfoQuery.getAccount(),loginInfoQuery.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		if (loginInfoDTO != null) {
			loginInfoDTO.setLoginType( "employee");
			loginInfoDTO.setUserAccount(loginInfoDTO.getEmployeeJobNumber());
			loginInfoDTO.setUserName(loginInfoDTO.getEmployeeName());
			loginSession.put("loginInfoDTO", loginInfoDTO);
			TeamDTO teamDTO = teamService.get(loginInfoDTO.getTeamId());
			if(teamDTO!=null){
				loginInfoDTO.setTeamName(teamDTO.getName());
				loginInfoDTO.setDepartmentId(teamDTO.getDepartmentId());
				loginSession.put("teamDTO", teamDTO);
				DepartmentDTO departmentDTO = departmentService.get(teamDTO.getDepartmentId());
				if(departmentDTO!=null){
					loginInfoDTO.setDepartmentName(departmentDTO.getName());
					loginSession.put("departmentDTO", departmentDTO);
				}
			}
			request.getSession().setAttribute("loginSession", loginSession);
			EmployeeRoleQuery employeeRoleQuery = new EmployeeRoleQuery();
			employeeRoleQuery.setEmployeeId(loginInfoDTO.getId());
			Pagination<EmployeeRoleQuery, EmployeeRoleDTO> employeeRoleDTOPagination = new Pagination<>();
			employeeRoleDTOPagination.setQuery(employeeRoleQuery);
			employeeRoleDTOPagination.setPageSize(10000);
			employeeRoleDTOPagination.setPageIndex(0L);
			employeeRoleDTOPagination = employeeRoleService.query(employeeRoleDTOPagination);
			List<Map<String, Object>> roleList = new ArrayList<>(employeeRoleDTOPagination.getRows().size());
			Map<String, Object> roleMap = null;
			for (EmployeeRoleDTO employeeRoleDTO : employeeRoleDTOPagination.getRows()) {
				roleMap = new HashMap<>();
				roleMap.put("roleId", employeeRoleDTO.getRoleId());
				roleMap.put("roleName", employeeRoleDTO.getRoleName());
				roleList.add(roleMap);
			}
			loginInfoDTO.setRoleList(roleList);
			baseResult.setSuccess(true);
			baseResult.setValue(loginInfoDTO);
		}
		return baseResult;
	}

	@RequestMapping("/logout.json")
	@ResponseBody
	Object logout() {
		BaseResult<Long> baseResult = new BaseResult<>();
		try {
			Map<String, Object> loginSession = (Map<String, Object>) request.getSession().getAttribute("loginSession");
			if(loginSession!=null){
				request.getSession().removeAttribute("loginSession");
				LoginInfoDTO loginInfoDTO = ((LoginInfoDTO) loginSession.get("loginInfoDTO"));
				baseResult.setValue(loginInfoDTO.getId());
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return baseResult;
	}
	
	@RequestMapping("/resetPassword.json")
	@ResponseBody
	Object resetPassword(String account, String oldPassword, String newPassword) {
		BaseResult<Long> baseResult = new BaseResult<>();
		try {
			Map<String, Object> loginSession = (Map<String, Object>) request.getSession().getAttribute("loginSession");
			if(loginSession!=null){
				request.getSession().removeAttribute("loginSession");
				LoginInfoDTO loginInfoDTO = ((LoginInfoDTO) loginSession.get("loginInfoDTO"));
				baseResult.setValue(loginInfoDTO.getId());
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return baseResult;
	}
	
	/**
	 * 直接修改密码，权限给管理员开放
	 * @param account
	 * @param newPassword
	 * @return
	 */
	@RequestMapping("/updatePassword.json")
	@ResponseBody
	Object resetPassword(String account, String newPassword) {
		BaseResult<Long> baseResult = new BaseResult<>();
		try {
			//login();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return baseResult;
	}
}
