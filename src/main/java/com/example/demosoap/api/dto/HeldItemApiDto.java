package com.example.demosoap.api.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class HeldItemApiDto implements Serializable {
	
	private static final long serialVersionUID = 360884949093310903L;

	private CommonInfoApiDto item;
	
	private List<VersionDetailApiDto> version_details;

}
