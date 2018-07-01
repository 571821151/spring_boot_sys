package com.railway.labor.score.config;

//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;

//@Configuration
public class ShiroConfiguration {
//	protected static final Logger logger = LoggerFactory
//			.getLogger(ShiroConfiguration.class);
//
//	@Bean
//	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//		//filterChainDefinitionMap.put("/logout.json", "logout");
//		//filterChainDefinitionMap.put("/**", "authc");
//		//shiroFilterFactoryBean.setLoginUrl("/login.json");
//		//shiroFilterFactoryBean.setSuccessUrl("/index");
//		shiroFilterFactoryBean.setUnauthorizedUrl("/**");
//		shiroFilterFactoryBean
//				.setFilterChainDefinitionMap(filterChainDefinitionMap);
//		shiroFilterFactoryBean
//				.setFilterChainDefinitionMap(filterChainDefinitionMap);
//		return shiroFilterFactoryBean;
//	}
//
//	@Bean
//	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//		return new LifecycleBeanPostProcessor();
//	}
//
//	@Bean
//	@DependsOn("lifecycleBeanPostProcessor")
//	public ShiroRealm shiroRealm() {
//		return new ShiroRealm();
//	}
//
//	@Bean
//	public SecurityManager securityManager() {
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		securityManager.setRealm(shiroRealm());
//		return securityManager;
//	}

}
