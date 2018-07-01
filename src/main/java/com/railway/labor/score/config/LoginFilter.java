package com.railway.labor.score.config;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
@Order(value = 2)
public class LoginFilter extends BaseFilter  implements Filter{
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
		Map<String,Object> loginSession = (Map<String, Object>) req.getSession(true).getAttribute("loginSession");
		if(loginSession!=null){
			filterChain.doFilter(request, response); 
		}else{
			res.sendRedirect(basePath+"/login.json");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("init {}",getClass());
		
	}
}
