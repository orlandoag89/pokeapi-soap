package com.example.demosoap.endpoint.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.VersionDetailIntDto;
import com.example.demosoap.gen.VersionDetail;
import com.example.demosoap.utils.IToOuter;

@Component
public class VersionDetailMapper implements IToOuter<VersionDetailIntDto, VersionDetail> {
	
	@Autowired
	private CommonDataMapper commonDataMapper;
	
	@Override
	public VersionDetail toOuter(final VersionDetailIntDto inner) {
		if (inner == null) {
			return null;
		}
		final VersionDetail out = new VersionDetail();
		out.setRarity(inner.getRarity());
		out.setVersion(commonDataMapper.toOuter(inner.getVersion()));
		return out;
	}

}
