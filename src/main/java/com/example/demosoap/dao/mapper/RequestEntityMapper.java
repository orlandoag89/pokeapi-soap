package com.example.demosoap.dao.mapper;

import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.WrapperRequestSaveIntDto;
import com.example.demosoap.business.dto.enums.MethodIntEnum;
import com.example.demosoap.dao.entites.RequestEntity;
import com.example.demosoap.dao.entites.enums.MethodEnum;
import com.example.demosoap.utils.IToInner;
import com.example.demosoap.utils.IToOuter;

@Component
public class RequestEntityMapper implements
	IToInner<RequestEntity, WrapperRequestSaveIntDto>,
	IToOuter<RequestEntity, WrapperRequestSaveIntDto> 
	{

	@Override
	public RequestEntity toInner(final WrapperRequestSaveIntDto outer) {
		if (outer == null) {
			return null;
		}
		final RequestEntity output = new RequestEntity();
		output.setIp(outer.getIp());
		output.setMethod(MethodEnum.valueOf(outer.getMethod().name()));
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
		out.setMethod(MethodIntEnum.valueOf(inner.getMethod().name()));
		out.setRequestDate(inner.getRequestDate());
		return out;
	}

}
