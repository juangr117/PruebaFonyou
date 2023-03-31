package com.mx.irc.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.irc.dto.AsignarExamenDTO;
import com.mx.irc.dto.ExamenDTO;
import com.mx.irc.dto.RespuestaExamenAlumnoDTO;
import com.mx.irc.entity.ExamenByAlumno;

public interface ExamenService {

	public ExamenDTO crearExamen(ExamenDTO examenVo) throws Exception;
	
	public String responderExamen(RespuestaExamenAlumnoDTO examenAlumnoVo) throws Exception;
	
	public List<ExamenByAlumno> examenByAlumno(@PathVariable long examenId ,@RequestBody  long alumno) throws Exception;

	public String asignarExamen(AsignarExamenDTO asignarExamen) throws Exception;
}
