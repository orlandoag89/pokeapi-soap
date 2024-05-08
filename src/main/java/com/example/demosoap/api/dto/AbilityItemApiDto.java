package com.example.demosoap.api.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AbilityItemApiDto implements Serializable {
	
	private static final long serialVersionUID = -5101840640043586610L;

	private boolean is_hidden;
	
	private int slot;
	
	private CommonInfoApiDto ability;
}
