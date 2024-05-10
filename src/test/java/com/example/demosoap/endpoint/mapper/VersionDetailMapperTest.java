package com.example.demosoap.endpoint.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.dto.CommonDataIntDto;
import com.example.demosoap.gen.VersionDetail;
import com.example.demosoap.mocks.Mocks;

import junit.framework.Assert;

@ExtendWith(MockitoExtension.class)
public class VersionDetailMapperTest {

	private Mocks mocks;
	
	@InjectMocks
	private VersionDetailMapper versionDetailMapper;
	
	@Mock
	private CommonDataMapper commonDataMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void toOuterIsOk() {
		Mockito.when(commonDataMapper.toOuter(Mockito.any(CommonDataIntDto.class))).thenReturn(mocks.getCommonData());
		
		final VersionDetail mapped = versionDetailMapper.toOuter(mocks.getVersionDetailIntDto());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getVersionDetailIntDto().getRarity(), mapped.getRarity());
		Assert.assertNotNull(mapped.getVersion());
		Assert.assertEquals(mocks.getVersionDetailIntDto().getVersion().getUrl(), mapped.getVersion().getUrl());
		Assert.assertEquals(mocks.getVersionDetailIntDto().getVersion().getName(), mapped.getVersion().getName());
		
		Mockito.verify(commonDataMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonDataIntDto.class));
	}
	
	@Test
	void toOuterIsNull() {
		final VersionDetail mapped = versionDetailMapper.toOuter(null);
		
		Assert.assertNull(mapped);
	}
}
