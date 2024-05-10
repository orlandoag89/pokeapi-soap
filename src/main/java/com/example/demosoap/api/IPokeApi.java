package com.example.demosoap.api;

import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.utils.BusinessException;

public interface IPokeApi {
	
	PokemonResponseIntDto retrievePokemonByName(String name) throws BusinessException;

}
