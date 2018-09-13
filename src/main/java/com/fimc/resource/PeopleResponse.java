package com.fimc.resource;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String birthDate;
}
