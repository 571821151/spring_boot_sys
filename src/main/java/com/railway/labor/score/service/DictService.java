package com.railway.labor.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.dao.DictDAO;
import com.railway.labor.score.model.dto.DictDTO;
import com.railway.labor.score.model.query.DictQuery;

@Service
public class DictService extends BaseService <DictQuery,DictDTO>{

	@Autowired
	public DictService(DictDAO dictDAO) {
		super(dictDAO);
	}
}
