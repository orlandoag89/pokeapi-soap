package com.example.demosoap.dao.impl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.dto.WrapperRequestSaveIntDto;
import com.example.demosoap.dao.entites.RequestEntity;
import com.example.demosoap.dao.mapper.RequestEntityMapper;
import com.example.demosoap.dao.repository.IPokemonRequestRepository;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class PokemonDaoImplTest {
	
	private Mocks mocks;
	
	@InjectMocks
	private PokemonDaoImpl daoImpl;
	
	@Mock
	private IPokemonRequestRepository repository;
	
	@Mock
	private RequestEntityMapper entityMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void onSaveRequestInfoIsOk() {
		Mockito.when(repository.save(Mockito.any())).thenReturn(mocks.getRequestEntity());
		Mockito.when(entityMapper.toInner(Mockito.any(WrapperRequestSaveIntDto.class))).thenReturn(mocks.getRequestEntity());
		Mockito.when(entityMapper.toOuter(Mockito.any(RequestEntity.class))).thenReturn(mocks.getWrapperRequestSaveIntDto());
		
		final WrapperRequestSaveIntDto saved = daoImpl.onSaveRequestInfo(mocks.getWrapperRequestSaveIntDto());
		
		Assert.assertNotNull(saved);
		Assert.assertNotNull(saved.getRequestDate());
		Assert.assertEquals(mocks.getWrapperRequestSaveIntDto().getId(), saved.getId());
		Assert.assertEquals(mocks.getWrapperRequestSaveIntDto().getMethod().name(), saved.getMethod().name());
	}

}
