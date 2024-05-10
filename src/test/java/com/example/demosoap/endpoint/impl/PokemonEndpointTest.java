package com.example.demosoap.endpoint.impl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.IPokemonBusiness;
import com.example.demosoap.business.dto.PokemonRequestIntDto;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.endpoint.mapper.GetPokemonRequestMapper;
import com.example.demosoap.endpoint.mapper.GetPokemonResponseMapper;
import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.gen.GetPokemonResponse;
import com.example.demosoap.mocks.Mocks;
import com.example.demosoap.utils.BusinessException;

@ExtendWith(MockitoExtension.class)
public class PokemonEndpointTest {
	
	private Mocks mocks;
	
	@InjectMocks
	private PokemonEndpoint pokemonEndpoint;
	
	@Mock
	private IPokemonBusiness business;
	
	@Mock
	private GetPokemonRequestMapper getPokemonRequestMapper;
	
	@Mock
	private GetPokemonResponseMapper getPokemonResponseMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void getPokemonRequestIsOk() throws BusinessException {
		Mockito.when(business.getPokemon(Mockito.any(PokemonRequestIntDto.class))).thenReturn(mocks.getPokemonResponseIntDto());
		Mockito.when(getPokemonRequestMapper.toInner(Mockito.any(GetPokemonRequest.class))).thenReturn(mocks.getPokemonRequestIntDto());
		Mockito.when(getPokemonResponseMapper.toOuter(Mockito.any(PokemonResponseIntDto.class))).thenReturn(mocks.getGetPokemonResponse());
		
		final GetPokemonResponse getPokemonResponse = pokemonEndpoint.getPokemonRequest(mocks.getGetPokemonRequest());
		
		Assert.assertNotNull(getPokemonResponse);
		Assert.assertNotNull(getPokemonResponse.getPokemon());
		Assert.assertEquals(mocks.getGetPokemonResponse().getPokemon().getLocationAreaEncounters(), getPokemonResponse.getPokemon().getLocationAreaEncounters());
		Assert.assertEquals(mocks.getGetPokemonResponse().getPokemon().getName(), getPokemonResponse.getPokemon().getName());
		Assert.assertEquals(mocks.getGetPokemonResponse().getPokemon().getBaseExperience(), getPokemonResponse.getPokemon().getBaseExperience());
		Assert.assertEquals(mocks.getGetPokemonResponse().getPokemon().getId(), getPokemonResponse.getPokemon().getId());
		Assert.assertFalse(getPokemonResponse.getPokemon().getAbilities().isEmpty());
		Assert.assertFalse(getPokemonResponse.getPokemon().getHeldItems().isEmpty());
		
		Mockito.verify(business, Mockito.atLeastOnce()).getPokemon(Mockito.any(PokemonRequestIntDto.class));
		Mockito.verify(getPokemonRequestMapper, Mockito.atLeastOnce()).toInner(Mockito.any(GetPokemonRequest.class));
		Mockito.verify(getPokemonResponseMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(PokemonResponseIntDto.class));
	}

}
