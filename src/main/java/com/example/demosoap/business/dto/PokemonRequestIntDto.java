package com.example.demosoap.business.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demosoap.business.dto.enums.MethodIntEnum;

import lombok.Data;

@Data
public class PokemonRequestIntDto implements Serializable {
	
	private static final long serialVersionUID = 7703651123892656251L;

	@NotEmpty
	private String pokemonName;
	
	@NotEmpty
	private MethodIntEnum method;
	
	@NotNull
	private DeviceInfoIntDto deviceInfo;

}
