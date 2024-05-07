package com.example.demosoap.dao;

import com.example.demosoap.business.dto.WrapperRequestSaveIntDto;

public interface IPokemonDao {
	
	WrapperRequestSaveIntDto onSaveRequestInfo(WrapperRequestSaveIntDto request);

}

