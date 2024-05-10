package com.example.demosoap.api.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.api.dto.CommonInfoApiDto;
import com.example.demosoap.business.dto.VersionDetailIntDto;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class VersionDetailApiMapperTest {

	private Mocks mocks;
	
	@InjectMocks
	private VersionDetailApiMapper mapper;
	
	@Mock
	private CommonInfoApiMapper commonInfoMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void toOuterIsOk() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		
		final VersionDetailIntDto mapped = mapper.toOuter(mocks.getVersionDetailApiDto());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getVersionDetailApiDto().getRarity(), mapped.getRarity());
		Assert.assertNotNull(mapped.getVersion());
		Assert.assertEquals(mocks.getVersionDetailApiDto().getVersion().getUrl(), mapped.getVersion().getUrl());
		Assert.assertEquals(mocks.getVersionDetailApiDto().getVersion().getName(), mapped.getVersion().getName());
		
		Mockito.verify(commonInfoMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonInfoApiDto.class));
	}
	
	@Test
	void toOuterIsNull() {
		final VersionDetailIntDto mapped = mapper.toOuter(null);
		
		Assert.assertNull(mapped);
	}
}
