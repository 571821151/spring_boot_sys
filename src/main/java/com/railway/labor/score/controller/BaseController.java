package com.railway.labor.score.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.service.DictService;

public class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected  HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	private DictService dictService;
	
	@SuppressWarnings("unchecked")
	public Map<String,Object> getLoginSession(){
		return (Map<String, Object>) request.getSession(true).getAttribute("loginSession");
	}
	
	public LoginInfoDTO getLoginInfoDTO(){
		return getLoginInfoDTO(getLoginSession());
	}
	
	public LoginInfoDTO getLoginInfoDTO(Map<String,Object> loginSession){
		return (LoginInfoDTO) loginSession.get("loginInfoDTO");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
}
