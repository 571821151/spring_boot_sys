package com.railway.labor.score.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.query.LoginInfoQuery;
import com.railway.labor.score.service.EmployeeService;
import com.railway.labor.score.service.PermissionService;
import com.railway.labor.score.service.RoleService;

public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		LoginInfoQuery loginInfoQuery = (LoginInfoQuery) principalCollection
				.getPrimaryPrincipal();
		LoginInfoDTO loginInfoDTO = employeeService.login(loginInfoQuery.getAccount(),
				loginInfoQuery.getPassword());

		if (loginInfoDTO == null) {
			return null;
		}
		// RoleQuery roleQuery = new RoleQuery();
		// roleQuery.se
		// roleService.query(roleQuery);

		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		//
		// for (Role role:employee.getRoles()) {
		// //添加角色
		// simpleAuthorizationInfo.addRole(role.getRoleName());
		// for (Permission permission:role.getPermissions()) {
		// //添加权限
		// simpleAuthorizationInfo.addStringPermission(permission.getPermission());
		// }
		// }
		return simpleAuthorizationInfo;
	}

	// 用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		if (authenticationToken.getPrincipal() == null) {
			return null;
		}
		// 获取用户信息
		LoginInfoQuery loginInfoQuery = (LoginInfoQuery) authenticationToken
				.getPrincipal();
		LoginInfoDTO loginInfoDTO = employeeService.login(loginInfoQuery.getAccount(),
				loginInfoQuery.getPassword());
		if (loginInfoDTO == null) {
			return null;
		} else {
			return new SimpleAuthenticationInfo(loginInfoQuery,
					loginInfoQuery.getPassword(), getName());
		}
	}

}
