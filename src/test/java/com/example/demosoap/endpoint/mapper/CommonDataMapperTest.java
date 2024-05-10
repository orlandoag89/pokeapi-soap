package com.example.demosoap.endpoint.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.gen.CommonData;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class CommonDataMapperTest {
	
	private Mocks mocks;
	
	private CommonDataMapper commonDataMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
		commonDataMapper = new CommonDataMapper();
	}

	@Test
	void toOuterIsOk() {
		final CommonData data = commonDataMapper.toOuter(mocks.getCommonDataIntDto());
		
		Assert.assertNotNull(data);
		Assert.assertEquals(mocks.getCommonDataIntDto().getName(), data.getName());
		Assert.assertEquals(mocks.getCommonDataIntDto().getUrl(), data.getUrl());
	}
	
	@Test
	void toOuterIsNull() {
		final CommonData data = commonDataMapper.toOuter(null);
		
		Assert.assertNull(data);
	}
}
