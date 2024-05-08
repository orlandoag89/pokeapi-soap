package com.example.demosoap.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.api.dto.HeldItemApiDto;
import com.example.demosoap.business.dto.HeldItemIntDto;
import com.example.demosoap.business.dto.VersionDetailIntDto;
import com.example.demosoap.utils.IToOuter;

@Component
public class HeldItemApiMapper implements IToOuter<HeldItemApiDto, HeldItemIntDto> {
	
	@Autowired
	private CommonInfoApiMapper commonInfoMapper;
	
	@Autowired
	private VersionDetailApiMapper versionDetailMapper;

	@Override
	public HeldItemIntDto toOuter(final HeldItemApiDto inner) {
		if (inner == null) {
			return null;
		}
		final HeldItemIntDto out = new HeldItemIntDto();
		out.setItem(commonInfoMapper.toOuter(inner.getItem()));
		
		final List<VersionDetailIntDto> versions = new ArrayList<>();
		
		if (inner.getVersion_details() != null && !inner.getVersion_details().isEmpty()) {
			inner.getVersion_details().forEach(v -> {
				versions.add(versionDetailMapper.toOuter(v));
			});
		}
		out.setVersionDetails(versions);
		return out;
	}

}
