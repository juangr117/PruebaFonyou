package com.mx.irc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.irc.entity.Estudiante;
import com.mx.irc.repository.EstudianteRepository;
import com.mx.irc.service.EstudianteService;
import com.mx.irc.utils.UtilsZonaHoraria;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public Estudiante crearEstudiante(Estudiante estudiante) {
		switch (estudiante.getZonaHoraria().toUpperCase()) {
		case "EUA":
			estudiante.setZonaHoraria(UtilsZonaHoraria.EUA);
			break;
		case "MEXICO":
			estudiante.setZonaHoraria(UtilsZonaHoraria.MEXICO);
			break;
		case "ARGENTINA":
			estudiante.setZonaHoraria(UtilsZonaHoraria.ARGENTINAMENDOZA);
			break;
		case "MADRID":
			estudiante.setZonaHoraria(UtilsZonaHoraria.MADRID);
			break;
		case "BOGOTA":
			estudiante.setZonaHoraria(UtilsZonaHoraria.BOGOTA);
			break;
		default:
			estudiante.setZonaHoraria(UtilsZonaHoraria.MEXICO);
			break;
		}
		return estudianteRepository.save(estudiante);
		
	}

}
