package com.example.demosoap.business.dto.enums;

public enum MethodIntEnum {
	
	ABILITIES("abilities");

	private String method;
	
	private MethodIntEnum(String method) {
		this.method = method;		
	}
	
	public String getMethod() {
		return this.method;
	}
}
