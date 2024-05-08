package com.example.demosoap.business.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class VersionDetailIntDto implements Serializable {

	private static final long serialVersionUID = 691480958795737588L;

	private int rarity;
	
	private CommonDataIntDto version;
}
