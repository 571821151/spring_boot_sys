package com.railway.labor.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.score.common.BaseResult;
import com.railway.labor.score.service.EmployeeService;

/**
 * 登录
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
public class ErrorController extends BaseController{
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/error.json")
	@ResponseBody
	BaseResult<String> error(String errorCode) {
		BaseResult<String> baseResult = new  BaseResult<>();
		baseResult.setSuccess(false);
		baseResult.setErrorCode(errorCode);
		//baseResult.setErrorMsg(msg);
		return baseResult;
	}

}
