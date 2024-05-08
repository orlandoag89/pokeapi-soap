package com.example.demosoap.endpoint.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.gen.GetPokemonResponse;
import com.example.demosoap.utils.IToOuter;

@Component
public class GetPokemonResponseMapper implements IToOuter<PokemonResponseIntDto, GetPokemonResponse> {
	
	@Autowired
	private PokemonDataMpper pokemonDataMpper;

	@Override
	public GetPokemonResponse toOuter(final PokemonResponseIntDto inner) {
		if (inner == null) {
			return null;
		}
		final GetPokemonResponse response = new GetPokemonResponse();
		response.setPokemon(pokemonDataMpper.toOuter(inner));
		return response;
	}

}
