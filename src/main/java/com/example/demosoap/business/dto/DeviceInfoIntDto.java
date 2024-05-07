package com.example.demosoap.business.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class DeviceInfoIntDto implements Serializable {
	
	private static final long serialVersionUID = -4478419302578368071L;

	private String ip;
	
	private Date requestDate;

}
