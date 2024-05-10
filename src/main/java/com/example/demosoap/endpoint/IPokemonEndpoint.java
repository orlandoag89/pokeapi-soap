package com.example.demosoap.endpoint;

import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.gen.GetPokemonResponse;
import com.example.demosoap.utils.BusinessException;

public interface IPokemonEndpoint {
	
	GetPokemonResponse getPokemonRequest(GetPokemonRequest request) throws BusinessException;

}
