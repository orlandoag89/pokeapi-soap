package com.example.demosoap.api.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.api.dto.AbilityItemApiDto;
import com.example.demosoap.api.dto.CommonInfoApiDto;
import com.example.demosoap.api.dto.HeldItemApiDto;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class PokemonApiMapperTest {
	
	private Mocks mocks;
	
	@InjectMocks
	private PokemonApiMapper pokemonApiMapper;
	
	@Mock
	private HeldItemApiMapper heldItemMapper;
	
	@Mock
	private CommonInfoApiMapper commonInfoMapper;
	
	@Mock
	private AbilityItemApiMapper abilityMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void toOuterIsOk() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		Mockito.when(abilityMapper.toOuter(Mockito.any(AbilityItemApiDto.class))).thenReturn(mocks.getAbilityItemIntDto());
		Mockito.when(heldItemMapper.toOuter(Mockito.any(HeldItemApiDto.class))).thenReturn(mocks.getHeldItemIntDto());
		
		final PokemonResponseIntDto mapped = pokemonApiMapper.toOuter(mocks.getPokemonApiDto());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getPokemonApiDto().getLocation_area_encounters(), mapped.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonApiDto().getName(), mapped.getPokemonName());
		Assert.assertEquals(mocks.getPokemonApiDto().getBase_experience(), mapped.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonApiDto().getId(), mapped.getId());
		Assert.assertFalse(mapped.getAbilities().isEmpty());
		Assert.assertFalse(mapped.getHeldItems().isEmpty());
		Assert.assertNotNull(mapped.getSpecies());
		
		Mockito.verify(commonInfoMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonInfoApiDto.class));
		Mockito.verify(abilityMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(AbilityItemApiDto.class));
		Mockito.verify(heldItemMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(HeldItemApiDto.class));
	}
	
	@Test
	void toOuterAbilitiesNull() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		Mockito.when(heldItemMapper.toOuter(Mockito.any(HeldItemApiDto.class))).thenReturn(mocks.getHeldItemIntDto());
		
		final PokemonResponseIntDto mapped = pokemonApiMapper.toOuter(mocks.getPokemonApiDtoAbilitiesNull());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getPokemonApiDto().getLocation_area_encounters(), mapped.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonApiDto().getName(), mapped.getPokemonName());
		Assert.assertEquals(mocks.getPokemonApiDto().getBase_experience(), mapped.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonApiDto().getId(), mapped.getId());
		Assert.assertTrue(mapped.getAbilities().isEmpty());
		Assert.assertFalse(mapped.getHeldItems().isEmpty());
		Assert.assertNotNull(mapped.getSpecies());
		
		Mockito.verify(commonInfoMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonInfoApiDto.class));
		Mockito.verify(heldItemMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(HeldItemApiDto.class));
	}
	
	@Test
	void toOuterAbilitiesEmpty() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		Mockito.when(heldItemMapper.toOuter(Mockito.any(HeldItemApiDto.class))).thenReturn(mocks.getHeldItemIntDto());
		
		final PokemonResponseIntDto mapped = pokemonApiMapper.toOuter(mocks.getPokemonApiDtoAbilitiesEmpty());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getPokemonApiDto().getLocation_area_encounters(), mapped.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonApiDto().getName(), mapped.getPokemonName());
		Assert.assertEquals(mocks.getPokemonApiDto().getBase_experience(), mapped.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonApiDto().getId(), mapped.getId());
		Assert.assertTrue(mapped.getAbilities().isEmpty());
		Assert.assertFalse(mapped.getHeldItems().isEmpty());
		Assert.assertNotNull(mapped.getSpecies());
		
		Mockito.verify(commonInfoMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonInfoApiDto.class));
		Mockito.verify(heldItemMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(HeldItemApiDto.class));
	}
	
	@Test
	void heldItemsNull() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		Mockito.when(abilityMapper.toOuter(Mockito.any(AbilityItemApiDto.class))).thenReturn(mocks.getAbilityItemIntDto());
		
		final PokemonResponseIntDto mapped = pokemonApiMapper.toOuter(mocks.getPokemonApiDtoHeldItemsNull());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getPokemonApiDto().getLocation_area_encounters(), mapped.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonApiDto().getName(), mapped.getPokemonName());
		Assert.assertEquals(mocks.getPokemonApiDto().getBase_experience(), mapped.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonApiDto().getId(), mapped.getId());
		Assert.assertFalse(mapped.getAbilities().isEmpty());
		Assert.assertTrue(mapped.getHeldItems().isEmpty());
		Assert.assertNotNull(mapped.getSpecies());
		
		Mockito.verify(commonInfoMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonInfoApiDto.class));
		Mockito.verify(abilityMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(AbilityItemApiDto.class));
	}
	
	@Test
	void heldItemsEmpty() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		Mockito.when(abilityMapper.toOuter(Mockito.any(AbilityItemApiDto.class))).thenReturn(mocks.getAbilityItemIntDto());
		
		final PokemonResponseIntDto mapped = pokemonApiMapper.toOuter(mocks.getPokemonApiDtoHeldItemsEmpty());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getPokemonApiDto().getLocation_area_encounters(), mapped.getLocationAreaEncounters());
		Assert.assertEquals(mocks.getPokemonApiDto().getName(), mapped.getPokemonName());
		Assert.assertEquals(mocks.getPokemonApiDto().getBase_experience(), mapped.getBaseExperience());
		Assert.assertEquals(mocks.getPokemonApiDto().getId(), mapped.getId());
		Assert.assertFalse(mapped.getAbilities().isEmpty());
		Assert.assertTrue(mapped.getHeldItems().isEmpty());
		Assert.assertNotNull(mapped.getSpecies());
		
		Mockito.verify(commonInfoMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonInfoApiDto.class));
		Mockito.verify(abilityMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(AbilityItemApiDto.class));
	}
	
	@Test
	void toOuterNull() {
		final PokemonResponseIntDto mapped = pokemonApiMapper.toOuter(null);
		
		Assert.assertNull(mapped);
	}
}
