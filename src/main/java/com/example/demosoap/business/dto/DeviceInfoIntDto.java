package com.example.demosoap.business.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class DeviceInfoIntDto implements Serializable {
	
	private static final long serialVersionUID = -4478419302578368071L;

	@NotEmpty
	@Pattern(
		regexp = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$",
		message = "ipv4 is not valid")
	private String ip;
	
	@NotEmpty
	private Date requestDate;

}
