package com.example.demosoap.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.api.dto.VersionDetailApiDto;
import com.example.demosoap.business.dto.VersionDetailIntDto;
import com.example.demosoap.utils.IToOuter;

@Component
public class VersionDetailApiMapper implements IToOuter<VersionDetailApiDto, VersionDetailIntDto> {
	
	@Autowired
	private CommonInfoApiMapper commonInfoMapper;

	@Override
	public VersionDetailIntDto toOuter(final VersionDetailApiDto inner) {
		if (inner == null) {
			return null;
		}
		final VersionDetailIntDto out = new VersionDetailIntDto();
		out.setRarity(inner.getRarity());
		out.setVersion(commonInfoMapper.toOuter(inner.getVersion()));
		return out;
	}

}
