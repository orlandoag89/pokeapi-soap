package com.example.demosoap.business.impl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.api.IPokeApi;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.business.dto.WrapperRequestSaveIntDto;
import com.example.demosoap.dao.IPokemonDao;
import com.example.demosoap.mocks.Mocks;
import com.example.demosoap.utils.BusinessException;

@ExtendWith(MockitoExtension.class)
public class PokemonBusinessImplTest {
	
	private Mocks mocks;
	
	@InjectMocks
	private PokemonBusinessImpl businessImpl;
	
	@Mock
	private IPokemonDao dao;
	
	@Mock
	private IPokeApi api;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void getPokemonIsOk() throws BusinessException {
		Mockito.when(dao.onSaveRequestInfo(Mockito.any(WrapperRequestSaveIntDto.class))).thenReturn(mocks.getWrapperRequestSaveIntDto());
		Mockito.when(api.retrievePokemonByName(Mockito.anyString())).thenReturn(mocks.getPokemonResponseIntDto());
		
		final PokemonResponseIntDto response = businessImpl.getPokemon(mocks.getPokemonRequestIntDto());
		
		Assert.assertNotNull(response);
		Assert.assertEquals(mocks.getPokemonRequestIntDto().getPokemonName(), response.getPokemonName());
		Assert.assertFalse(response.getAbilities().isEmpty());
		Assert.assertFalse(response.getHeldItems().isEmpty());
		
		Mockito.verify(dao, Mockito.atLeastOnce()).onSaveRequestInfo((dao.onSaveRequestInfo(Mockito.any(WrapperRequestSaveIntDto.class))));
		Mockito.verify(api, Mockito.atLeastOnce()).retrievePokemonByName(Mockito.anyString());
	}

}
