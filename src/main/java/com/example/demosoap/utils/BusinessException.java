package com.example.demosoap.utils;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 6129546664479937268L;

	private String message;
	
	private String code;
	
	private HttpStatus httpStatus;
	
	public BusinessException(String message, String code, HttpStatus httpStatus) {
		super("[" + code + "]" + message);
	}
	
	public String getError() {
		return "[" + code + "]" + message;
	}
	
	public HttpStatus getGttpStatus() {
		return httpStatus;
	}
	
}
