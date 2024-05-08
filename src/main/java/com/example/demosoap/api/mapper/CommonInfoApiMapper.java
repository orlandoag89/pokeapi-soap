package com.example.demosoap.api.mapper;

import org.springframework.stereotype.Component;

import com.example.demosoap.api.dto.CommonInfoApiDto;
import com.example.demosoap.business.dto.CommonDataIntDto;
import com.example.demosoap.utils.IToOuter;

@Component
public class CommonInfoApiMapper implements IToOuter<CommonInfoApiDto, CommonDataIntDto> {

	@Override
	public CommonDataIntDto toOuter(final CommonInfoApiDto inner) {
		if (inner == null) {
			return null;
		}
		final CommonDataIntDto out = new CommonDataIntDto();
		out.setName(inner.getName());
		out.setUrl(inner.getUrl());
		return out;
	}

}
