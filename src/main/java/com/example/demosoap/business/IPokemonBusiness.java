package com.example.demosoap.business;

import com.example.demosoap.business.dto.PokemonRequestIntDto;
import com.example.demosoap.business.dto.PokemonResponseIntDto;

public interface IPokemonBusiness {

	 PokemonResponseIntDto getPokemon(PokemonRequestIntDto request);
}
