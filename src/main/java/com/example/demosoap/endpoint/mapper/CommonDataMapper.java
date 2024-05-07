package com.example.demosoap.endpoint.mapper;

import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.CommonDataIntDto;
import com.example.demosoap.gen.CommonData;
import com.example.demosoap.utils.IMapper;

@Component
public class CommonDataMapper implements IMapper<CommonDataIntDto, CommonData> {

	@Override
	public CommonDataIntDto toInner(final CommonData outer) {
		if (outer == null) {
			return null;
		}
		final CommonDataIntDto output = new CommonDataIntDto();
		output.setName(outer.getName());
		output.setUrl(outer.getUrl());
		return output;
	}

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
