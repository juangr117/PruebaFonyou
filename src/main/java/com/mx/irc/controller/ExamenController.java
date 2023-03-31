package com.mx.irc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.irc.dto.AsignarExamenDTO;
import com.mx.irc.dto.ExamenDTO;
import com.mx.irc.dto.RespuestaExamenAlumnoDTO;
import com.mx.irc.service.ExamenService;

@RestController
@RequestMapping("api/")
public class ExamenController {

	@Autowired
	private ExamenService examenService;
	
	@PostMapping("crearExamen")
	public ResponseEntity<?> CrearExamen(@RequestBody ExamenDTO examenVo) throws Exception {
		return ResponseEntity.ok(examenService.crearExamen(examenVo));
	}
	
	@PostMapping("asignarExamen")
	public ResponseEntity<?> asignarExamen(@RequestBody AsignarExamenDTO asignarExamen) throws Exception {
		System.out.println(asignarExamen);
		return ResponseEntity.ok(examenService.asignarExamen(asignarExamen));
	}
	
	@PostMapping("examenByAlumno/{examenId}/{alumno}")
	public ResponseEntity<?> examenByAlumno(@PathVariable int examenId ,@PathVariable  int alumno) throws Exception {
		return ResponseEntity.ok(examenService.examenByAlumno(examenId,alumno));
	}
	
	
	@PostMapping("responderExamen")
	public ResponseEntity<?> responderExamen(@RequestBody RespuestaExamenAlumnoDTO respuestaExamenAlumnoVo) throws Exception {
		System.out.println(respuestaExamenAlumnoVo);
		return ResponseEntity.ok(examenService.responderExamen(respuestaExamenAlumnoVo));
	}
}
