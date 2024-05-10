package com.example.demosoap.dao.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.business.dto.WrapperRequestSaveIntDto;
import com.example.demosoap.dao.entites.RequestEntity;
import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class RequestEntityMapperTest {

	private Mocks mocks;

	private RequestEntityMapper entityMapper;

	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
		entityMapper = new RequestEntityMapper();
	}

	@Test
	void toInnerIsOk() {
		final RequestEntity mapped = entityMapper.toInner(mocks.getWrapperRequestSaveIntDto());

		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getWrapperRequestSaveIntDto().getIp(), mapped.getIp());
		Assert.assertEquals(mocks.getWrapperRequestSaveIntDto().getMethod().name(), mapped.getMethod().name());
		Assert.assertNotNull(mapped.getRequestDate());
		Assert.assertNotSame(mocks.getWrapperRequestSaveIntDto().getId(), mapped.getIdRequest());
	}

	@Test
	void toInnerIsNull() {
		final RequestEntity mapped = entityMapper.toInner(null);

		Assert.assertNull(mapped);
	}

	@Test
	void toOuterIsOk() {
		final WrapperRequestSaveIntDto mapped = entityMapper.toOuter(mocks.getRequestEntity());

		Assert.assertNotNull(mapped);
		Assert.assertEquals(mocks.getRequestEntity().getIp(), mapped.getIp());
		Assert.assertEquals(mocks.getRequestEntity().getIdRequest(), mapped.getId());
		Assert.assertEquals(mocks.getRequestEntity().getMethod().name(), mapped.getMethod().name());
		Assert.assertNotNull(mapped.getRequestDate());
	}
	
	@Test
	void toOuterIsNull() {
		final WrapperRequestSaveIntDto mapped = entityMapper.toOuter(null);

		Assert.assertNull(mapped);
	}

}
