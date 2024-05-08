package com.example.demosoap.business.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AbilityItemIntDto implements Serializable {
	
	private static final long serialVersionUID = 7462831518800796154L;

	private CommonDataIntDto ability;
	
	private boolean isHidden;
	
	private int slot;

}
