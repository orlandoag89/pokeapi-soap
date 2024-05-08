package com.example.demosoap.api;

import com.example.demosoap.business.dto.PokemonResponseIntDto;

public interface IPokeApi {
	
	PokemonResponseIntDto retrievePokemonByName(String name);

}
