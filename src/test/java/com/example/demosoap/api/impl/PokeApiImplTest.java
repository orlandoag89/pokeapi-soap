package com.example.demosoap.api.impl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.example.demosoap.api.dto.PokemonApiDto;
import com.example.demosoap.api.mapper.PokemonApiMapper;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.mocks.Mocks;
import com.example.demosoap.utils.BusinessException;

@ExtendWith(MockitoExtension.class)
public class PokeApiImplTest {

	private Mocks mocks;
	
	@InjectMocks
	private PokeApiImpl pokeApiImpl;
	
	@Mock
	private PokemonApiMapper mapper;
	
	@Mock
	private RestTemplate restTemplate;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
		ReflectionTestUtils.setField(pokeApiImpl, "url", "https://pokeapi.co/api/v2");
		ReflectionTestUtils.setField(pokeApiImpl, "pokemon", "/pokemon/{name}");

	}
	
	@Test
	void retrievePokemonByNameIsOk() throws BusinessException {
		Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.eq(PokemonApiDto.class))).thenReturn(mocks.createResponseEntity());
		Mockito.when(mapper.toOuter(Mockito.any(PokemonApiDto.class))).thenReturn(mocks.getPokemonResponseIntDto());
		
		final PokemonResponseIntDto response = pokeApiImpl.retrievePokemonByName(mocks.getPokemonName());
		
		Assert.assertNotNull(response);
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getLocationAreaEncounters(), response.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getPokemonName(), response.getPokemonName());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getBaseExperience(), response.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getId(), response.getId());
		Assert.assertNotNull(response.getSpecies());
		Assert.assertFalse(response.getAbilities().isEmpty());
		Assert.assertFalse(response.getHeldItems().isEmpty());
		
		Mockito.verify(mapper, Mockito.atLeastOnce()).toOuter(Mockito.any(PokemonApiDto.class));
		Mockito.verify(restTemplate, Mockito.atLeastOnce()).getForEntity(Mockito.anyString(), Mockito.eq(PokemonApiDto.class));
	}
}
