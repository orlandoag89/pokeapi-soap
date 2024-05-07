package com.example.demosoap.endpoint.mapper;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.DeviceInfoIntDto;
import com.example.demosoap.gen.DeviceInfo;
import com.example.demosoap.utils.IMapper;

@Component
public class DeviceInfoMapper implements IMapper<DeviceInfoIntDto, DeviceInfo> {

	@Override
	public DeviceInfoIntDto toInner(final DeviceInfo outer) {
		if (outer == null) {
			return null;
		}
		final DeviceInfoIntDto output = new DeviceInfoIntDto();
		output.setIp(outer.getIp());
		output.setRequestDate(outer.getRequestDate().toGregorianCalendar().getTime());
		return output;
	}

	@Override
	public DeviceInfo toOuter(final DeviceInfoIntDto inner) {
		if (inner == null) {
			return null;
		}
		final DeviceInfo out = new DeviceInfo();
		out.setIp(inner.getIp());
		out.setRequestDate(getXmlGregorianDate(inner.getRequestDate()));
		return out;
	}
	
	private XMLGregorianCalendar getXmlGregorianDate(final Date date) {
		try {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (DatatypeConfigurationException e) {
			return null;
		}
	}

}
