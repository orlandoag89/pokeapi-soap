package com.example.demosoap.dao.mapper;

import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.WrapperRequestSaveIntDto;
import com.example.demosoap.business.dto.enums.MethodIntEnum;
import com.example.demosoap.dao.entites.RequestEntity;
import com.example.demosoap.dao.entites.enums.MethodEnum;
import com.example.demosoap.utils.IMapper;

@Component
public class RequestEntityMapper implements IMapper<RequestEntity, WrapperRequestSaveIntDto> {

	@Override
	public RequestEntity toInner(final WrapperRequestSaveIntDto outer) {
		if (outer == null) {
			return null;
		}
		final RequestEntity output = new RequestEntity();
		output.setIp(outer.getIp());
		output.setMethod(MethodEnum.valueOf(outer.getMethod().getMethod()));
		output.setRequestDate(outer.getRequestDate());
		return output;
	}

	@Override
	public WrapperRequestSaveIntDto toOuter(final RequestEntity inner) {
		if (inner == null) {
			return null;
		}
		final WrapperRequestSaveIntDto out = new WrapperRequestSaveIntDto();
		out.setId(inner.getIdRequest());
		out.setIp(inner.getIp());
		out.setMethod(MethodIntEnum.valueOf(inner.getMethod().getMethod()));
		out.setRequestDate(inner.getRequestDate());
		return out;
	}

}
