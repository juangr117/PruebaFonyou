package com.mx.irc.dto;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaExamenAlumnoDTO {

	private Long alumnoId;
	
	private Long examenId;
	
	private List<String> respuesta;
	
}
