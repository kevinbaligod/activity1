package com.fimc.resource;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CalcuRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String operator;
	private double number1;
	private double number2;
}
