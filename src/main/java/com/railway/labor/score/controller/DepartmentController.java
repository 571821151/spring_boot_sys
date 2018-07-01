package com.railway.labor.score.controller;

import com.railway.labor.score.common.BaseResult;
import com.railway.labor.score.common.ErrorEnum;
import com.railway.labor.score.common.Id;
import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.DepartmentDTO;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.query.DepartmentQuery;
import com.railway.labor.score.service.DepartmentService;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController{
    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取部门列表
     *
     * @return
     */
    @RequestMapping(value = { "list.json", "" })
    @ResponseBody
    public BaseResult<Pagination<DepartmentQuery, DepartmentDTO>> list(@RequestBody(required=false) DepartmentQuery departmentQuery) {
        logger.info("departmentServiceQuery={}",departmentQuery);
        BaseResult<Pagination<DepartmentQuery, DepartmentDTO>> baseResult = new BaseResult<>();
        Pagination<DepartmentQuery, DepartmentDTO> pagination = new Pagination<>();
        if(departmentQuery==null){
            departmentQuery = new DepartmentQuery();
        }
        pagination.setQuery(departmentQuery);
        pagination.setPageSize(departmentQuery.getPageSize());
        pagination.setPageIndex(departmentQuery.getPageIndex());

        try {
            pagination = departmentService.query(pagination);
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

    /**
     * 获取职业生涯
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "get.json")
    @ResponseBody
    public BaseResult<DepartmentDTO> get(@RequestBody(required=false) Id id) {
        logger.info("id={}",id);
        BaseResult<DepartmentDTO> baseResult = new BaseResult<>();
        DepartmentDTO departmentDTO = null;
        try {
            departmentDTO = departmentService.get(id.getId());
            if (departmentDTO == null) {
                baseResult.setErrorCode(ErrorEnum.USER_NULL.getCode());
                baseResult.setErrorMsg(ErrorEnum.USER_NULL.getMsg());
            } else {
                baseResult.setValue(departmentDTO);
                baseResult.setSuccess(true);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
            baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
        }

        return baseResult;
    }

    /**
     * 部门新增
     *
     * @param departmentDTO
     * @return
     */
    @RequestMapping(value = "add.json")
    @ResponseBody
    public BaseResult<DepartmentDTO> add(@RequestBody(required=false) DepartmentDTO departmentDTO) {
        BaseResult<DepartmentDTO> baseResult = new BaseResult<>();
        try {
            DepartmentDTO query = departmentService.get(departmentDTO.getId());
            if(query!=null){
                List<DepartmentDTO> list = departmentService.getByName(departmentDTO.getName());
                if(CollectionUtils.isEmpty(list)){
                    baseResult.setErrorCode(ErrorEnum.EMPLOYEE_NULL.getCode());
                    baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_NULL.getMsg());
                    return baseResult;
                }
            }
            LoginInfoDTO loginInfo = getLoginInfoDTO();
            departmentDTO.setCreator(loginInfo.getId());
            departmentDTO.setCreateDate(new Date());
            departmentDTO.setModifier(loginInfo.getId());
            departmentDTO.setModifyDate(new Date());
            departmentDTO.setDelFlag("0");
            departmentService.insert(departmentDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
            baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
        }
        baseResult.setValue(departmentDTO);
        baseResult.setSuccess(true);
        return baseResult;
    }
}
