package com.example.demosoap.endpoint.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.VersionDerailIntDto;
import com.example.demosoap.gen.VersionDetail;
import com.example.demosoap.utils.IMapper;

@Component
public class VersionDetailMapper implements IMapper<VersionDerailIntDto, VersionDetail> {
	
	@Autowired
	private CommonDataMapper commonDataMapper;

	@Override
	public VersionDerailIntDto toInner(final VersionDetail outer) {
		if (outer == null) {
			return null;
		}
		final VersionDerailIntDto out = new VersionDerailIntDto();
		out.setRarity(outer.getRarity());
		out.setVersion(commonDataMapper.toInner(outer.getVersion()));
		return out;
	}

	@Override
	public VersionDetail toOuter(final VersionDerailIntDto inner) {
		if (inner == null) {
			return null;
		}
		final VersionDetail out = new VersionDetail();
		out.setRarity(inner.getRarity());
		out.setVersion(commonDataMapper.toOuter(inner.getVersion()));
		return out;
	}

}
