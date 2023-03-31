package com.mx.irc.dto;

import java.util.List;

import lombok.Data;

@Data
public class ExamenDTO {

	private String nombre;
	
	private List<PreguntasDTO> preguntasVo;
}
