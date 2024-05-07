package com.example.demosoap.dao.entites.enums;

public enum MethodEnum {
	
	ABILITIES("abilities");

	private String method;
	
	private MethodEnum(String method) {
		this.method = method;		
	}
	
	public String getMethod() {
		return this.method;
	}
}
