package com.example.demosoap.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demosoap.business.dto.WrapperRequestSaveIntDto;
import com.example.demosoap.dao.IPokemonDao;
import com.example.demosoap.dao.entites.RequestEntity;
import com.example.demosoap.dao.mapper.RequestEntityMapper;
import com.example.demosoap.dao.repository.IPokemonRequestRepository;

@Service
public class PokemonDaoImpl implements IPokemonDao {
	
	private static final Logger logger = LogManager.getLogger(PokemonDaoImpl.class);

	@Autowired
	private IPokemonRequestRepository repository;
	
	@Autowired
	private RequestEntityMapper entityMapper;

	@Override
	public WrapperRequestSaveIntDto onSaveRequestInfo(final WrapperRequestSaveIntDto request) {
		logger.info("Saving request info");
		RequestEntity saved = repository.save(entityMapper.toInner(request));
		logger.info("request has saved!");
		return entityMapper.toOuter(saved);
	}
	
	
}
