package com.example.demosoap.endpoint.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.dto.DeviceInfoIntDto;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class DeviceInfoMapperTest {
	
	private Mocks mocks;
	
	private DeviceInfoMapper deviceInfoMapper;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
		deviceInfoMapper = new DeviceInfoMapper();
	}

	@Test
	void toInnerIsOk() {
		final DeviceInfoIntDto mapped = deviceInfoMapper.toInner(mocks.getDeviceInfo());
		
		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getDeviceInfo().getIp(), mapped.getIp());
		Assert.assertNotNull(mapped.getRequestDate());
	}
	
	@Test
	void toInnerIsNull() {
		final DeviceInfoIntDto mapped = deviceInfoMapper.toInner(null);
		Assert.assertNull(mapped);
	}
}
