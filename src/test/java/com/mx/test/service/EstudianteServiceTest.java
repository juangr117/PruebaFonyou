package com.mx.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mx.irc.entity.Estudiante;
import com.mx.irc.repository.EstudianteRepository;
import com.mx.irc.service.impl.EstudianteServiceImpl;


@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {

	@Mock
	private EstudianteRepository estudianteRepository;
	
	
	@InjectMocks
	private EstudianteServiceImpl estudianteServiceImpl;
	
	
	@Test
	void guardarEmpleadoTest() {
		
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Juan");
		estudiante.setCiudad("Bogota");
		estudiante.setEdad(18);
		estudiante.setZonaHoraria("Bogota");
		
		given(estudianteRepository.save(estudiante)).willReturn(estudiante);
		Estudiante estudianteCreado = estudianteServiceImpl.crearEstudiante(estudiante);
		assertThat(estudianteCreado).isNotNull();
	}
}
