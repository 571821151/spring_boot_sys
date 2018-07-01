package com.railway.labor.score.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.score.mapper.DictMapper;
import com.railway.labor.score.model.dto.DictDTO;
import com.railway.labor.score.model.query.DictQuery;

@Service
public class DictDAO extends BaseDAO <DictQuery,DictDTO>{
	
	@Autowired
	public DictDAO(DictMapper dictMapper) {
		super(dictMapper);
	}
}
