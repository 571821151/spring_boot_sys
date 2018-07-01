package com.railway.labor.score.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.score.common.BaseResult;
import com.railway.labor.score.common.ErrorEnum;
import com.railway.labor.score.common.Id;
import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.DictDTO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.query.DictQuery;
import com.railway.labor.score.service.DictService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {
	@Autowired
	private DictService dictService;

	@ModelAttribute
	public DictDTO modelAttribute(@RequestParam(required = false) Long id) {
		return dictService.get(id);
	}

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list.json", "" })
	@ResponseBody
	public BaseResult<Pagination<DictQuery, DictDTO>> list(
			@RequestBody(required = false) DictQuery dictQuery) {
		logger.info("dictQuery={}", dictQuery);
		BaseResult<Pagination<DictQuery, DictDTO>> baseResult = new BaseResult<>();
		Pagination<DictQuery, DictDTO> pagination = new Pagination<>();
		if (dictQuery == null) {
			dictQuery = new DictQuery();
		}
		pagination.setQuery(dictQuery);
		pagination.setPageSize(dictQuery.getPageSize());
		pagination.setPageIndex(dictQuery.getPageIndex());

		try {
			pagination = dictService.query(pagination);
			if (pagination == null) {
				baseResult.setErrorCode(ErrorEnum.USER_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.USER_NULL.getMsg());
			} else {
				baseResult.setSuccess(true);
				baseResult.setValue(pagination);
			}

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
	public BaseResult<DictDTO> get(@RequestBody(required = false) Id id) {
		logger.info("id={}", id);
		BaseResult<DictDTO> baseResult = new BaseResult<>();
		DictDTO dictDTO = null;
		try {
			dictDTO = dictService.get(id.getId());
			if (dictDTO == null) {
				baseResult.setErrorCode(ErrorEnum.USER_NULL.getCode());
				baseResult.setErrorMsg(ErrorEnum.USER_NULL.getMsg());
			} else {
				baseResult.setValue(dictDTO);
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
		}

		return baseResult;
	}

	/**
	 * 添加数据字典
	 * 
	 * @param dictDTO
	 * @return
	 */
	@RequestMapping(value = "add.json")
	@ResponseBody
	public BaseResult<DictDTO> add(
			@RequestBody(required = false) DictDTO dictDTO) {
		logger.info("dictDTO={}", dictDTO);
		BaseResult<DictDTO> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = getLoginInfoDTO();
			dictDTO.setCreator(loginInfo.getId());
			dictDTO.setCreateDate(new Date());
			dictDTO.setModifier(loginInfo.getId());
			dictDTO.setModifyDate(new Date());
			dictDTO.setDelFlag("0");
			dictService.insert(dictDTO);
			baseResult.setValue(dictDTO);
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
		}

		return baseResult;
	}

	/**
	 * 修改数据字典
	 * 
	 * @param dictDTO
	 * @return
	 */
	@RequestMapping(value = "update.json")
	@ResponseBody
	public BaseResult<DictDTO> update(
			@RequestBody(required = false) DictDTO dictDTO) {
		logger.info("dictDTO={}", dictDTO);
		BaseResult<DictDTO> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = getLoginInfoDTO();
			dictDTO.setModifier(loginInfo.getId());
			dictDTO.setModifyDate(new Date());
			dictService.update(dictDTO);
			baseResult.setValue(dictDTO);
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
			baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
		}
		return baseResult;
	}

	/**
	 * 删除数据字典
	 * 
	 * @param dictDTO
	 * @return
	 */
	@RequestMapping(value = "delete.json")
	@ResponseBody
	public BaseResult<Integer> delete(@RequestBody(required = false) Id id) {
		logger.info("id={}", id);
		BaseResult<Integer> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = getLoginInfoDTO();
			DictDTO dictDTO = dictService.get(id.getId());
			if (dictDTO != null) {
				dictDTO.setModifier(loginInfo.getId());
				dictDTO.setModifyDate(new Date());
				int result = dictService.delete(dictDTO);
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
