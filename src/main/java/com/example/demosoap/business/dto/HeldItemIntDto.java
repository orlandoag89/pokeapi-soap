package com.example.demosoap.business.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class HeldItemIntDto implements Serializable {
	
	private static final long serialVersionUID = 2228767628379794750L;

	private CommonDataIntDto item;
	
	private List<VersionDerailIntDto> versionDetails;

}
