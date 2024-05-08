package com.example.demosoap.endpoint.mapper;

import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.DeviceInfoIntDto;
import com.example.demosoap.gen.DeviceInfo;
import com.example.demosoap.utils.GregorianCalendarUtils;
import com.example.demosoap.utils.IToInner;

@Component
public class DeviceInfoMapper implements IToInner<DeviceInfoIntDto, DeviceInfo> {

	@Override
	public DeviceInfoIntDto toInner(final DeviceInfo outer) {
		if (outer == null) {
			return null;
		}
		final DeviceInfoIntDto output = new DeviceInfoIntDto();
		output.setIp(outer.getIp());
		output.setRequestDate(GregorianCalendarUtils.getTime(outer.getRequestDate()));
		return output;
	}

}
