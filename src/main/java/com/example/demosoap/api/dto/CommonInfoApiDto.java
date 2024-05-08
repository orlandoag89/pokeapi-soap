package com.example.demosoap.api.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CommonInfoApiDto implements Serializable {

	private static final long serialVersionUID = -1139304452391957409L;

	private String name;
	
	private String url;
}
