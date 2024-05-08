package com.example.demosoap.endpoint.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demosoap.business.IPokemonBusiness;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.endpoint.IPokemonEndpoint;
import com.example.demosoap.endpoint.mapper.GetPokemonRequestMapper;
import com.example.demosoap.endpoint.mapper.GetPokemonResponseMapper;
import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.gen.GetPokemonResponse;

@Endpoint
public class PokemonEndpoint implements IPokemonEndpoint {
	
	private static final Logger logger = LogManager.getLogger(PokemonEndpoint.class);

    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/gen";
    
    @Autowired
    private IPokemonBusiness business;
    
    @Autowired
    private GetPokemonRequestMapper getPokemonRequestMapper;
    
    @Autowired
    private GetPokemonResponseMapper getPokemonResponseMapper;
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemonRequest(@RequestPayload final GetPokemonRequest request) {
    	logger.info("retrieving pokemon");
    	final PokemonResponseIntDto intPokemonResponse = business.getPokemon(getPokemonRequestMapper.toInner(request));
    	logger.info("request completed");
    	return getPokemonResponseMapper.toOuter(intPokemonResponse);
    }
}
