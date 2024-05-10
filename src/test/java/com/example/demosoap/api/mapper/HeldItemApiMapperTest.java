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
import com.example.demosoap.api.dto.VersionDetailApiDto;
import com.example.demosoap.business.dto.HeldItemIntDto;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class HeldItemApiMapperTest {

	private Mocks mocks;
	
	@InjectMocks
	private HeldItemApiMapper heldItemApiMapper;
	
	@Mock
	private CommonInfoApiMapper commonInfoMapper;
	
	@Mock
	private VersionDetailApiMapper versionDetailMapper;
	
	private 
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void toOuterIsOk() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		Mockito.when(versionDetailMapper.toOuter(Mockito.any(VersionDetailApiDto.class))).thenReturn(mocks.getVersionDetailIntDto());
		
		final HeldItemIntDto mapped = heldItemApiMapper.toOuter(mocks.getHeldItemApiDto());
		
		Assert.assertNotNull(mapped);
		Assert.assertNotNull(mapped.getItem());
		Assert.assertFalse(mapped.getVersionDetails().isEmpty());
		
		Mockito.verify(commonInfoMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonInfoApiDto.class));
		Mockito.verify(versionDetailMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(VersionDetailApiDto.class));
	}
	
	@Test
	void toOuterVersionDetailsNull() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		
		final HeldItemIntDto mapped = heldItemApiMapper.toOuter(mocks.getHeldItemApiDtoNullList());
		
		Assert.assertNotNull(mapped);
		Assert.assertNotNull(mapped.getItem());
		Assert.assertTrue(mapped.getVersionDetails().isEmpty());
	}
	
	@Test
	void toOuterVersionDetailsEmpty() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		
		final HeldItemIntDto mapped = heldItemApiMapper.toOuter(mocks.getHeldItemApiDtoEmptyList());
		
		Assert.assertNotNull(mapped);
		Assert.assertNotNull(mapped.getItem());
		Assert.assertTrue(mapped.getVersionDetails().isEmpty());
	}
	
	@Test
	void toOuterIsNull() {
		final HeldItemIntDto mapped = heldItemApiMapper.toOuter(null);
		
		Assert.assertNull(mapped);
	}
}
