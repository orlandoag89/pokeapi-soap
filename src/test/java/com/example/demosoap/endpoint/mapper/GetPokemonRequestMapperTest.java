package com.example.demosoap.endpoint.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.dto.PokemonRequestIntDto;
import com.example.demosoap.gen.DeviceInfo;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class GetPokemonRequestMapperTest {
	
	private Mocks mocks;
	
	@InjectMocks
	private GetPokemonRequestMapper getPokemonRequestMapper;
	
	@Mock
	private DeviceInfoMapper deviceInfoMapper;

	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void toInnerIsOk() {
		Mockito.when(deviceInfoMapper.toInner(Mockito.any(DeviceInfo.class))).thenReturn(mocks.getDeviceInfoIntDto());
		
		final PokemonRequestIntDto mapped = getPokemonRequestMapper.toInner(mocks.getGetPokemonRequest());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getGetPokemonRequest().getMethod(), mapped.getMethod().name());
		Assert.assertEquals(mocks.getGetPokemonRequest().getPokemonName(), mapped.getPokemonName());
		Assert.assertEquals(mocks.getGetPokemonRequest().getDevice().getIp(), mapped.getDeviceInfo().getIp());
		Assert.assertNotNull(mapped.getDeviceInfo().getRequestDate());
		
		Mockito.verify(deviceInfoMapper, Mockito.atLeastOnce()).toInner(Mockito.any(DeviceInfo.class));
	}
	
	@Test
	void toInnerIsNull() {
		final PokemonRequestIntDto mapped = getPokemonRequestMapper.toInner(null);
		
		Assert.assertNull(mapped);
	}
}
