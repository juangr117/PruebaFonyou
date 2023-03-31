package com.mx.irc.dto;

import java.util.List;

import lombok.Data;

@Data
public class AsignacionExamenDTO {

	private String fecha;
	
	private List<Integer> alumno;
}
