package com.railway.labor.score.controller;

import com.railway.labor.score.common.BaseResult;
import com.railway.labor.score.common.ErrorEnum;
import com.railway.labor.score.common.Id;
import com.railway.labor.score.common.Pagination;
import com.railway.labor.score.model.dto.LoginInfoDTO;
import com.railway.labor.score.model.dto.TeamDTO;
import com.railway.labor.score.model.query.TeamQuery;
import com.railway.labor.score.service.TeamService;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController extends BaseController {
    @Autowired
    private TeamService teamService;

    /**
     * 获取职业生涯列表
     *
     * @return
     */
    @RequestMapping(value = { "list.json", "" })
    @ResponseBody
    public BaseResult<Pagination<TeamQuery, TeamDTO>> list(@RequestBody(required=false) TeamQuery teamQuery) {
        logger.info("teamServiceQuery={}",teamQuery);
        BaseResult<Pagination<TeamQuery, TeamDTO>> baseResult = new BaseResult<>();
        Pagination<TeamQuery, TeamDTO> pagination = new Pagination<>();
        if(teamQuery==null){
            teamQuery = new TeamQuery();
        }
        pagination.setQuery(teamQuery);
        pagination.setPageSize(teamQuery.getPageSize());
        pagination.setPageIndex(teamQuery.getPageIndex());

        try {
            pagination = teamService.query(pagination);
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
     * 获取班组信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "get.json")
    @ResponseBody
    public BaseResult<TeamDTO> get(@RequestBody(required=false) Id id) {
        logger.info("id={}",id);
        BaseResult<TeamDTO> baseResult = new BaseResult<>();
        TeamDTO teamDTO = null;
        try {
            teamDTO = teamService.get(id.getId());
            if (teamDTO == null) {
                baseResult.setErrorCode(ErrorEnum.USER_NULL.getCode());
                baseResult.setErrorMsg(ErrorEnum.USER_NULL.getMsg());
            } else {
                baseResult.setValue(teamDTO);
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
     * @param teamDTO
     * @return
     */
    @RequestMapping(value = "add.json")
    @ResponseBody
    public BaseResult<TeamDTO> add(@RequestBody(required=false) TeamDTO teamDTO) {
        BaseResult<TeamDTO> baseResult = new BaseResult<>();
        try {
            TeamDTO query = teamService.get(teamDTO.getId());
            if(query!=null){
                List<TeamDTO> list = teamService.getByName(teamDTO.getName(), teamDTO.getDepartmentId());
                if(CollectionUtils.isEmpty(list)){
                    baseResult.setErrorCode(ErrorEnum.EMPLOYEE_NULL.getCode());
                    baseResult.setErrorMsg(ErrorEnum.EMPLOYEE_NULL.getMsg());
                    return baseResult;
                }
            }
            LoginInfoDTO loginInfo = getLoginInfoDTO();
            teamDTO.setCreator(loginInfo.getId());
            teamDTO.setCreateDate(new Date());
            teamDTO.setModifier(loginInfo.getId());
            teamDTO.setModifyDate(new Date());
            teamDTO.setDelFlag("0");
            teamService.insert(teamDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            baseResult.setErrorCode(ErrorEnum.USER_QUERY_EXCEPTION.getCode());
            baseResult.setErrorMsg(ErrorEnum.USER_QUERY_EXCEPTION.getMsg());
        }
        baseResult.setValue(teamDTO);
        baseResult.setSuccess(true);
        return baseResult;
    }
}
