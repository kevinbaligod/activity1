package com.fimc.resource;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class PeopleRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private Date birthDate;
}
