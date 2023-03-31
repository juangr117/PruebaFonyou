package com.mx.irc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.irc.entity.Estudiante;
import com.mx.irc.service.EstudianteService;


@RestController
@RequestMapping("api/")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@PostMapping("crearEstudiante")
	public ResponseEntity<?> crearEstudiante(@RequestBody Estudiante estudiante) {
		return ResponseEntity.ok(estudianteService.crearEstudiante(estudiante));
	}

}
