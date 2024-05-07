package com.example.demosoap.business.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demosoap.business.dto.enums.MethodIntEnum;

import lombok.Data;

@Data
public class WrapperRequestSaveIntDto implements Serializable {
	
	private static final long serialVersionUID = -8728324686366058518L;

	private int id;

	private String ip;
	
	private Date requestDate;
	
	private MethodIntEnum method;
}
