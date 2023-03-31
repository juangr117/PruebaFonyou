package com.mx.test.service.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mx.irc.entity.Estudiante;
import com.mx.irc.repository.EstudianteRepository;

@DataJpaTest
public class EstudianteRepositoryTest {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Test
    void testGuardarEmpleado(){
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Juan");
		estudiante.setCiudad("Bogota");
		estudiante.setEdad(18);
		estudiante.setZonaHoraria("Bogota");
		
	    estudianteRepository.save(estudiante);

		assertThat(estudianteRepository.buscarAlumnoById(1L)).isNotNull();
		
		
	}
}
