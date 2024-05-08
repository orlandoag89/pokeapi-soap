package com.example.demosoap.api.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class VersionDetailApiDto implements Serializable {

	private static final long serialVersionUID = 1314463707370549668L;

	private int rarity;
	
	private CommonInfoApiDto version;
}
