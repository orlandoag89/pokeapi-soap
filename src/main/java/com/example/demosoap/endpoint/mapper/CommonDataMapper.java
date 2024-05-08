package com.example.demosoap.endpoint.mapper;

import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.CommonDataIntDto;
import com.example.demosoap.gen.CommonData;
import com.example.demosoap.utils.IToOuter;

@Component
public class CommonDataMapper implements IToOuter<CommonDataIntDto, CommonData> {

	@Override
	public CommonData toOuter(final CommonDataIntDto inner) {
		if (inner == null) {
			return null;
		}
		final CommonData output = new CommonData();
		output.setName(inner.getName());
		output.setUrl(inner.getUrl());
		return output;
	}

}
