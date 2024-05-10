package com.example.demosoap.api.mapper;

import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.ArgumentMatchers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.api.dto.CommonInfoApiDto;
import com.example.demosoap.business.dto.AbilityItemIntDto;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class AbilityItemApiMapperTest {

	private Mocks mocks;
	
	@InjectMocks
	private AbilityItemApiMapper abilityItemApiMapper;

	@Mock
	private CommonInfoApiMapper commonInfoMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}

	@Test
	void toOuterIsOk() {
		Mockito.when(commonInfoMapper.toOuter(Mockito.any(CommonInfoApiDto.class))).thenReturn(mocks.getCommonDataIntDto());
		final AbilityItemIntDto mapped = abilityItemApiMapper.toOuter(mocks.getAbilityItemApiDto());
		
		Mockito.verify(commonInfoMapper, Mockito.atLeastOnce()).toOuter(ArgumentMatchers.any(CommonInfoApiDto.class));
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getAbilityItemApiDto().getSlot(), mapped.getSlot());
		Assert.assertEquals(mocks.getAbilityItemApiDto().is_hidden(), mapped.isHidden());
		Assert.assertNotNull(mapped.getAbility());
		Assert.assertEquals(mocks.getAbilityItemApiDto().getAbility().getName(), mapped.getAbility().getName());
		Assert.assertEquals(mocks.getAbilityItemApiDto().getAbility().getUrl(), mapped.getAbility().getUrl());
	}
	
	@Test
	void toOuterNull() {
		final AbilityItemIntDto mapped = abilityItemApiMapper.toOuter(null);
		
		Assert.assertNull(mapped);
	}
}
