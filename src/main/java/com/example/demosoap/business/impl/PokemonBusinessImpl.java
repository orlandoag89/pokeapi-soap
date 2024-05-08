package com.example.demosoap.business.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demosoap.api.IPokeApi;
import com.example.demosoap.business.IPokemonBusiness;
import com.example.demosoap.business.dto.PokemonRequestIntDto;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.business.dto.WrapperRequestSaveIntDto;
import com.example.demosoap.business.dto.enums.MethodIntEnum;
import com.example.demosoap.dao.IPokemonDao;

@Service
public class PokemonBusinessImpl implements IPokemonBusiness {

	private static final Logger logger = LogManager.getLogger(PokemonBusinessImpl.class);
	
	@Autowired
	private IPokemonDao dao;
	
	@Autowired
	private IPokeApi api;
	
	@Override
	public PokemonResponseIntDto getPokemon(final PokemonRequestIntDto request) {
		logger.info("retrieving pokemon by " + request.getMethod());
		final PokemonResponseIntDto apiResponse = api.retrievePokemonByName(request.getPokemonName());
		logger.info("saving request data");
		dao.onSaveRequestInfo(createWrapperRequest(request));
		return apiResponse;
	}
	
	private WrapperRequestSaveIntDto createWrapperRequest(final PokemonRequestIntDto request) {
		logger.info("creating wrapper");
		final WrapperRequestSaveIntDto toSave = new WrapperRequestSaveIntDto();
		toSave.setIp(request.getDeviceInfo().getIp());
		toSave.setMethod(MethodIntEnum.valueOf(request.getMethod().name()));
		toSave.setRequestDate(request.getDeviceInfo().getRequestDate());
		return toSave;
	}

}
