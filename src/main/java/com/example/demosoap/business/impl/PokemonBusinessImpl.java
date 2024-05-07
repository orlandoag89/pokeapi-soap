package com.example.demosoap.business.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demosoap.business.IPokemonBusiness;
import com.example.demosoap.business.dto.PokemonRequestIntDto;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.dao.IPokemonDao;

@Service
public class PokemonBusinessImpl implements IPokemonBusiness {

	private static final Logger logger = LogManager.getLogger(PokemonBusinessImpl.class);
	
	@Autowired
	private IPokemonDao dao;
	
	@Override
	public PokemonResponseIntDto getPokemon(final PokemonRequestIntDto request) {
		logger.info("retrieving pokemon by " + request.getMethod());
		dao.onSaveRequestInfo(request);
		return null;
	}

}
