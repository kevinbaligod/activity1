package com.fimc.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcuResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String action;
	private String result;
}
