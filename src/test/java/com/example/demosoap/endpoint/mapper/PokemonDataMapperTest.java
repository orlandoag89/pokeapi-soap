package com.example.demosoap.endpoint.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.dto.AbilityItemIntDto;
import com.example.demosoap.business.dto.CommonDataIntDto;
import com.example.demosoap.business.dto.VersionDetailIntDto;
import com.example.demosoap.gen.PokemonData;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class PokemonDataMapperTest {
	
	private Mocks mocks;
	
	@InjectMocks
	private PokemonDataMpper pokemonDataMpper;
	
	@Mock
	private CommonDataMapper commonDataMapper;
	
	@Mock
	private VersionDetailMapper versionDetailMapper;
	
	@Mock
	private AbilityItemMapper abilityItemMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void toOuterIsOk() {
		Mockito.when(commonDataMapper.toOuter(Mockito.any(CommonDataIntDto.class))).thenReturn(mocks.getCommonData());
		Mockito.when(versionDetailMapper.toOuter(Mockito.any(VersionDetailIntDto.class))).thenReturn(mocks.getVersionDetail());
		Mockito.when(abilityItemMapper.toOuter(Mockito.any(AbilityItemIntDto.class))).thenReturn(mocks.getAbilityItem());
		
		final PokemonData pokemonData = pokemonDataMpper.toOuter(mocks.getPokemonResponseIntDto());
		
		Assert.assertNotNull(pokemonData);
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getLocationAreaEncounters(), pokemonData.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getPokemonName(), pokemonData.getName());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getBaseExperience(), pokemonData.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getId(), pokemonData.getId());
		Assert.assertNotNull(pokemonData.getSpecies());
		Assert.assertFalse(pokemonData.getAbilities().isEmpty());
		Assert.assertFalse(pokemonData.getHeldItems().isEmpty());
		
		Mockito.verify(commonDataMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonDataIntDto.class));
		Mockito.verify(versionDetailMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(VersionDetailIntDto.class));
		Mockito.verify(abilityItemMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(AbilityItemIntDto.class));
	}
	
	@Test
	void toOuterAbilitiesIsNull() {
		Mockito.when(commonDataMapper.toOuter(Mockito.any(CommonDataIntDto.class))).thenReturn(mocks.getCommonData());
		Mockito.when(versionDetailMapper.toOuter(Mockito.any(VersionDetailIntDto.class))).thenReturn(mocks.getVersionDetail());
		
		final PokemonData pokemonData = pokemonDataMpper.toOuter(mocks.getPokemonResponseAbilitiesNullIntDto());
		
		Assert.assertNotNull(pokemonData);
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getLocationAreaEncounters(), pokemonData.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getPokemonName(), pokemonData.getName());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getBaseExperience(), pokemonData.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getId(), pokemonData.getId());
		Assert.assertNotNull(pokemonData.getSpecies());
		Assert.assertTrue(pokemonData.getAbilities().isEmpty());
		Assert.assertFalse(pokemonData.getHeldItems().isEmpty());
		
		Mockito.verify(commonDataMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonDataIntDto.class));
		Mockito.verify(versionDetailMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(VersionDetailIntDto.class));
	}
	
	@Test
	void toOuterAbilitiesIsEmpty() {
		Mockito.when(commonDataMapper.toOuter(Mockito.any(CommonDataIntDto.class))).thenReturn(mocks.getCommonData());
		Mockito.when(versionDetailMapper.toOuter(Mockito.any(VersionDetailIntDto.class))).thenReturn(mocks.getVersionDetail());
		
		final PokemonData pokemonData = pokemonDataMpper.toOuter(mocks.getPokemonResponseAbilitiesEmptyIntDto());
		
		Assert.assertNotNull(pokemonData);
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getLocationAreaEncounters(), pokemonData.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getPokemonName(), pokemonData.getName());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getBaseExperience(), pokemonData.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getId(), pokemonData.getId());
		Assert.assertNotNull(pokemonData.getSpecies());
		Assert.assertTrue(pokemonData.getAbilities().isEmpty());
		Assert.assertFalse(pokemonData.getHeldItems().isEmpty());
		
		Mockito.verify(commonDataMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonDataIntDto.class));
		Mockito.verify(versionDetailMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(VersionDetailIntDto.class));
	}

	@Test
	void toOuterHeldItemsNull() {
		Mockito.when(commonDataMapper.toOuter(Mockito.any(CommonDataIntDto.class))).thenReturn(mocks.getCommonData());
		Mockito.when(abilityItemMapper.toOuter(Mockito.any(AbilityItemIntDto.class))).thenReturn(mocks.getAbilityItem());
		
		final PokemonData pokemonData = pokemonDataMpper.toOuter(mocks.getPokemonResponseHeldItemsNullIntDto());
		
		Assert.assertNotNull(pokemonData);
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getLocationAreaEncounters(), pokemonData.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getPokemonName(), pokemonData.getName());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getBaseExperience(), pokemonData.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getId(), pokemonData.getId());
		Assert.assertNotNull(pokemonData.getSpecies());
		Assert.assertFalse(pokemonData.getAbilities().isEmpty());
		Assert.assertTrue(pokemonData.getHeldItems().isEmpty());
		
		Mockito.verify(commonDataMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonDataIntDto.class));
		Mockito.verify(abilityItemMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(AbilityItemIntDto.class));
	}
	
	@Test
	void toOuterHeldItemsEmpty() {
		Mockito.when(commonDataMapper.toOuter(Mockito.any(CommonDataIntDto.class))).thenReturn(mocks.getCommonData());
		Mockito.when(abilityItemMapper.toOuter(Mockito.any(AbilityItemIntDto.class))).thenReturn(mocks.getAbilityItem());
		
		final PokemonData pokemonData = pokemonDataMpper.toOuter(mocks.getPokemonResponseHeldItemsEmptyIntDto());
		
		Assert.assertNotNull(pokemonData);
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getLocationAreaEncounters(), pokemonData.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getPokemonName(), pokemonData.getName());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getBaseExperience(), pokemonData.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getId(), pokemonData.getId());
		Assert.assertNotNull(pokemonData.getSpecies());
		Assert.assertFalse(pokemonData.getAbilities().isEmpty());
		Assert.assertTrue(pokemonData.getHeldItems().isEmpty());
		
		Mockito.verify(commonDataMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonDataIntDto.class));
		Mockito.verify(abilityItemMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(AbilityItemIntDto.class));
	}
	
	@Test
	void toOuterVersionDetailsEmpty() {
		Mockito.when(commonDataMapper.toOuter(Mockito.any(CommonDataIntDto.class))).thenReturn(mocks.getCommonData());
		Mockito.when(abilityItemMapper.toOuter(Mockito.any(AbilityItemIntDto.class))).thenReturn(mocks.getAbilityItem());
		
		final PokemonData pokemonData = pokemonDataMpper.toOuter(mocks.getPokemonResponseVersionDetailsIsEmptyIntDto());
		
		Assert.assertNotNull(pokemonData);
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getLocationAreaEncounters(), pokemonData.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getPokemonName(), pokemonData.getName());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getBaseExperience(), pokemonData.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getId(), pokemonData.getId());
		Assert.assertNotNull(pokemonData.getSpecies());
		Assert.assertFalse(pokemonData.getAbilities().isEmpty());
		Assert.assertFalse(pokemonData.getHeldItems().isEmpty());
		
		Mockito.verify(commonDataMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonDataIntDto.class));
		Mockito.verify(abilityItemMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(AbilityItemIntDto.class));
	}
	
	@Test
	void toOuterVersionDetailsNull() {
		Mockito.when(commonDataMapper.toOuter(Mockito.any(CommonDataIntDto.class))).thenReturn(mocks.getCommonData());
		Mockito.when(abilityItemMapper.toOuter(Mockito.any(AbilityItemIntDto.class))).thenReturn(mocks.getAbilityItem());
		
		final PokemonData pokemonData = pokemonDataMpper.toOuter(mocks.getPokemonResponseVersionDetailsIsNullIntDto());
		
		Assert.assertNotNull(pokemonData);
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getLocationAreaEncounters(), pokemonData.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getPokemonName(), pokemonData.getName());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getBaseExperience(), pokemonData.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonResponseIntDto().getId(), pokemonData.getId());
		Assert.assertNotNull(pokemonData.getSpecies());
		Assert.assertFalse(pokemonData.getAbilities().isEmpty());
		Assert.assertFalse(pokemonData.getHeldItems().isEmpty());
		
		Mockito.verify(commonDataMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonDataIntDto.class));
		Mockito.verify(abilityItemMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(AbilityItemIntDto.class));
	}
	
	@Test
	void toOuterNull() {
		final PokemonData pokemonData = pokemonDataMpper.toOuter(null);
		
		Assert.assertNull(pokemonData);
	}
}
