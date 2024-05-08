package com.example.demosoap.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.api.dto.AbilityItemApiDto;
import com.example.demosoap.business.dto.AbilityItemIntDto;
import com.example.demosoap.utils.IToOuter;

@Component
public class AbilityItemApiMapper implements IToOuter<AbilityItemApiDto, AbilityItemIntDto> {
	
	@Autowired
	private CommonInfoApiMapper commonInfoMapper;

	@Override
	public AbilityItemIntDto toOuter(final AbilityItemApiDto inner) {
		if (inner == null) {
			return null;
		}
		final AbilityItemIntDto out = new AbilityItemIntDto();
		out.setAbility(commonInfoMapper.toOuter(inner.getAbility()));
		out.setHidden(inner.is_hidden());
		out.setSlot(inner.getSlot());
		return out;
	}

}
