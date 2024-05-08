package com.example.demosoap.endpoint.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.AbilityItemIntDto;
import com.example.demosoap.gen.AbilityItem;
import com.example.demosoap.utils.IToOuter;

@Component
public class AbilityItemMapper implements IToOuter<AbilityItemIntDto, AbilityItem> {

	@Autowired
	private CommonDataMapper commonDataMapper;
	
	@Override
	public AbilityItem toOuter(final AbilityItemIntDto inner) {
		if (inner == null) {
			return null;
		}
		final AbilityItem item = new AbilityItem();
		item.setAbility(commonDataMapper.toOuter(inner.getAbility()));
		item.setIsHidden(inner.isHidden());
		item.setSlot(inner.getSlot());
		return item;
	}

}
