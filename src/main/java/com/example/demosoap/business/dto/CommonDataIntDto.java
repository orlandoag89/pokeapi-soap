package com.example.demosoap.business.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CommonDataIntDto implements Serializable {
	
	private static final long serialVersionUID = -5096172406361014727L;

	private String name;
	
	private String url;

}
