package com.example.demosoap.business;

import com.example.demosoap.business.dto.PokemonRequestIntDto;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.utils.BusinessException;

public interface IPokemonBusiness {

	 PokemonResponseIntDto getPokemon(PokemonRequestIntDto request) throws BusinessException;
}
