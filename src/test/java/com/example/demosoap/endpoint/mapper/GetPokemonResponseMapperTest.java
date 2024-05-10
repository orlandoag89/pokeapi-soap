package com.example.demosoap.endpoint.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.gen.GetPokemonResponse;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class GetPokemonResponseMapperTest {
	
	private Mocks mocks;
	
	@InjectMocks
	private GetPokemonResponseMapper getPokemonResponseMapper;
	
	@Mock
	private PokemonDataMpper pokemonDataMpper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void toOuterIsOk() {
		Mockito.when(pokemonDataMpper.toOuter(Mockito.any(PokemonResponseIntDto.class))).thenReturn(mocks.getPokemonData());
		
		final GetPokemonResponse mapped = getPokemonResponseMapper.toOuter(mocks.getPokemonResponseIntDto());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getLocationAreaEncounters(), mapped.getPokemon().getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getPokemonName(), mapped.getPokemon().getName());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getBaseExperience(), mapped.getPokemon().getBaseExperience());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getId(), mapped.getPokemon().getId());
		Assert.assertFalse(mapped.getPokemon().getAbilities().isEmpty());
		Assert.assertFalse(mapped.getPokemon().getHeldItems().isEmpty());
		
		Mockito.verify(pokemonDataMpper, Mockito.atLeastOnce()).toOuter(Mockito.any(PokemonResponseIntDto.class));
	}
	
	@Test
	void toOuterIsNull() {
		final GetPokemonResponse mapped = getPokemonResponseMapper.toOuter(null);
		Assert.assertNull(mapped);
	}

}
