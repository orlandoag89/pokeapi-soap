package com.example.demosoap.endpoint.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.dto.CommonDataIntDto;
import com.example.demosoap.gen.AbilityItem;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class AbilityItemMapperTest {
	
	private Mocks mocks;
	
	@InjectMocks
	private AbilityItemMapper abilityItemMapper;
	
	@Mock
	private CommonDataMapper commonDataMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}
	
	@Test
	void toOuterIsOk() {
		Mockito.when(commonDataMapper.toOuter(Mockito.any(CommonDataIntDto.class))).thenReturn(mocks.getCommonData());
		
		final AbilityItem abilityItem = abilityItemMapper.toOuter(mocks.getAbilityItemIntDto());
		
		Assert.assertNotNull(abilityItem);
		Assert.assertEquals(mocks.getAbilityItemIntDto().getSlot(), abilityItem.getSlot());
		Assert.assertEquals(mocks.getAbilityItemIntDto().getAbility().getName(), abilityItem.getAbility().getName());
		Assert.assertEquals(mocks.getAbilityItemIntDto().getAbility().getUrl(), abilityItem.getAbility().getUrl());
		Mockito.verify(commonDataMapper, Mockito.atLeastOnce()).toOuter(Mockito.any(CommonDataIntDto.class));
	}
	
	@Test
	void toOuterIsNull() {
		final AbilityItem abilityItem = abilityItemMapper.toOuter(null);
		Assert.assertNull(abilityItem);
	}

}
