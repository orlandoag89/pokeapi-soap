package com.example.demosoap.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.dto.CommonDataIntDto;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class CommonInfoApiMapperTest {
	
	private CommonInfoApiMapper commonInfoApiMapper;
	
	private Mocks mocks;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
		commonInfoApiMapper = new CommonInfoApiMapper();
	}
	
	@Test
	void toOuterIsOk() {
		final CommonDataIntDto out = commonInfoApiMapper.toOuter(mocks.getCommonInfoApiDto());
		
		assertNotNull(out);
		assertEquals(mocks.getCommonInfoApiDto().getName(), out.getName());
		assertEquals(mocks.getCommonInfoApiDto().getUrl(), out.getUrl());
	}
	
	@Test
	void toOuterNull() {
		final CommonDataIntDto out = commonInfoApiMapper.toOuter(null);
		
		assertNull(out);
	}

}
