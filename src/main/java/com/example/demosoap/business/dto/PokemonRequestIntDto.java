package com.example.demosoap.business.dto;

import java.io.Serializable;

import com.example.demosoap.business.dto.enums.MethodIntEnum;

import lombok.Data;

@Data
public class PokemonRequestIntDto implements Serializable {
	
	private static final long serialVersionUID = 7703651123892656251L;

	private String pokemonName;
	
	private MethodIntEnum method;
	
	private DeviceInfoIntDto deviceInfo;

}
