package com.railway.labor.score.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.EmployeePermissionDTO;
import com.railway.labor.score.model.dto.EmployeeRoleDTO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.dto.PermissionDTO;
import com.railway.labor.score.model.dto.RolePermissionDTO;
import com.railway.labor.score.model.dto.UserPermissionDTO;
import com.railway.labor.score.model.dto.UserRoleDTO;
import com.railway.labor.score.model.query.EmployeePermissionQuery;
import com.railway.labor.score.model.query.EmployeeRoleQuery;
import com.railway.labor.score.model.query.RolePermissionQuery;
import com.railway.labor.score.model.query.UserPermissionQuery;
import com.railway.labor.score.model.query.UserRoleQuery;
import com.railway.labor.score.service.EmployeePermissionService;
import com.railway.labor.score.service.EmployeeRoleService;
import com.railway.labor.score.service.PermissionService;
import com.railway.labor.score.service.RolePermissionService;
import com.railway.labor.score.service.UserPermissionService;
import com.railway.labor.score.service.UserRoleService;
@Component
@WebFilter(urlPatterns = "/*",filterName = "permissionFilter")
@Order(value = 3)
public class PermissionFilter  extends BaseFilter implements Filter{
	private UserRoleService userRoleService;
	private UserPermissionService userPermissionService;
	private EmployeeRoleService employeeRoleService;
	private EmployeePermissionService employeePermissionService;
	private RolePermissionService rolePermissionService;
	private PermissionService permissionService;
	@Override
	public void destroy() {
		log.info("destroy {}", getClass()); 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
		boolean noNeedLoginPaths = NO_NEED_LOGIN_PATHS.contains(req.getRequestURL().substring(basePath.length()));  
		if(noNeedLoginPaths){
			filterChain.doFilter(request, response); 
			return;
		}
		
		@SuppressWarnings("unchecked")
		Map<String,Object> loginSession = (Map<String, Object>) req.getSession(true).getAttribute("loginSession");
		List<PermissionDTO> permissionDTOList = null;
		if(loginSession!=null){
			permissionDTOList =  (List<PermissionDTO>) loginSession.get("permissionDTOList");
		}
		if(permissionDTOList==null){
			LoginInfoDTO loginInfoDTO = (LoginInfoDTO) loginSession.get("loginInfoDTO");
			
			RolePermissionQuery  rolePermissionQuery = new RolePermissionQuery();
			Pagination<RolePermissionQuery, RolePermissionDTO> rolePermissionDTOPagination = new Pagination<>();
			rolePermissionDTOPagination.setPageSize(10000);
			rolePermissionDTOPagination.setPageIndex(0L);
			List<RolePermissionDTO> rolePermissionDTOList = new ArrayList<>();
			List<Long> ids =null;
			
			if("user".equals(loginInfoDTO.getLoginType())){
				UserPermissionQuery  userPermissionQuery = new UserPermissionQuery();
				userPermissionQuery.setUserId(loginInfoDTO.getId());
				Pagination<UserPermissionQuery, UserPermissionDTO> userPermissionDTOPagination = new Pagination<>();
				userPermissionDTOPagination.setQuery(userPermissionQuery);
				userPermissionDTOPagination.setPageSize(10000);
				userPermissionDTOPagination.setPageIndex(0L);
				List<UserPermissionDTO> userPermissionDTOList = userPermissionService.query(userPermissionDTOPagination).getRows();
				
				UserRoleQuery userRoleQuery = new UserRoleQuery();
				userRoleQuery.setUserId(loginInfoDTO.getId());
				Pagination<UserRoleQuery, UserRoleDTO> userRoleDTOPagination = new Pagination<>();
				userRoleDTOPagination.setQuery(userRoleQuery);
				userRoleDTOPagination.setPageSize(10000);
				userRoleDTOPagination.setPageIndex(0L);
				userRoleDTOPagination = userRoleService.query(userRoleDTOPagination);
				
				for (UserRoleDTO userRoleDTO : userRoleDTOPagination.getRows()) {
					rolePermissionQuery.setRoleId(userRoleDTO.getRoleId());
					rolePermissionDTOPagination.setQuery(rolePermissionQuery);
					rolePermissionDTOList.addAll(rolePermissionService.query(rolePermissionDTOPagination).getRows());
				}
				ids = new ArrayList<>(userPermissionDTOList.size() + rolePermissionDTOList.size());
				for (UserPermissionDTO userPermissionDTO : userPermissionDTOList) {
					ids.add(userPermissionDTO.getPermissionId());
				}
				
			}else if("employee".equals(loginInfoDTO.getLoginType())){
				EmployeePermissionQuery  employeePermissionQuery = new EmployeePermissionQuery();
				employeePermissionQuery.setEmployeeId(loginInfoDTO.getId());
				Pagination<EmployeePermissionQuery, EmployeePermissionDTO> employeePermissionDTOPagination = new Pagination<>();
				employeePermissionDTOPagination.setQuery(employeePermissionQuery);
				employeePermissionDTOPagination.setPageSize(10000);
				employeePermissionDTOPagination.setPageIndex(0L);
				List<EmployeePermissionDTO> employeePermissionDTOList = employeePermissionService.query(employeePermissionDTOPagination).getRows();
				
				EmployeeRoleQuery employeeRoleQuery = new EmployeeRoleQuery();
				employeeRoleQuery.setEmployeeId(loginInfoDTO.getId());
				Pagination<EmployeeRoleQuery, EmployeeRoleDTO> employeeRoleDTOPagination = new Pagination<>();
				employeeRoleDTOPagination.setQuery(employeeRoleQuery);
				employeeRoleDTOPagination.setPageSize(10000);
				employeeRoleDTOPagination.setPageIndex(0L);
				employeeRoleDTOPagination = employeeRoleService.query(employeeRoleDTOPagination);
				
				for (EmployeeRoleDTO employeeRoleDTO : employeeRoleDTOPagination.getRows()) {
					rolePermissionQuery.setRoleId(employeeRoleDTO.getRoleId());
					rolePermissionDTOPagination.setQuery(rolePermissionQuery);
					rolePermissionDTOList.addAll(rolePermissionService.query(rolePermissionDTOPagination).getRows());
				}
				ids = new ArrayList<>(employeePermissionDTOList.size() + rolePermissionDTOList.size());
				for (EmployeePermissionDTO employeePermissionDTO : employeePermissionDTOList) {
					ids.add(employeePermissionDTO.getPermissionId());
				}
			}
			
			for (RolePermissionDTO rolePermissionDTO : rolePermissionDTOList) {
				ids.add(rolePermissionDTO.getPermissionId());
			}
			permissionDTOList = permissionService.queryByIds(ids);
			if(CollectionUtils.isNotEmpty(permissionDTOList)){
				loginSession.put("permissionDTOList", permissionDTOList);
			}
		}
		if(permissionDTOList!=null){
			for (PermissionDTO permissionDTO : permissionDTOList) {
				if(StringUtils.endsWith(req.getRequestURL(), permissionDTO.getValue())){
					filterChain.doFilter(request, response); 
					return;
				}
			}
		}
		res.sendRedirect(basePath+"/error.json?errorCode=noPermission");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("init {}",getClass()); 	
		ServletContext context = filterConfig.getServletContext();  
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        userRoleService = (UserRoleService) ctx.getBean("userRoleService"); 
        userPermissionService = (UserPermissionService) ctx.getBean("userPermissionService");
    	employeeRoleService = (EmployeeRoleService) ctx.getBean("employeeRoleService"); 
    	employeePermissionService = (EmployeePermissionService) ctx.getBean("employeePermissionService");
    	rolePermissionService = (RolePermissionService) ctx.getBean("rolePermissionService"); 
    	permissionService = (PermissionService) ctx.getBean("permissionService");
	}

}
