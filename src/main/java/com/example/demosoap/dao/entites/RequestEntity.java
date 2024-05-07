package com.example.demosoap.dao.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demosoap.dao.entites.enums.MethodEnum;

import lombok.Data;

@Data
@Entity
public class RequestEntity implements Serializable {

	private static final long serialVersionUID = -9080143476909532533L;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int idRequest;
	
	private String ip;
	
	private Date requestDate;
	
	private MethodEnum method;
}
