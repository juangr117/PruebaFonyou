package com.mx.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mx.irc.dto.AsignarExamenDTO;
import com.mx.irc.dto.ExamenDTO;
import com.mx.irc.dto.PreguntasDTO;
import com.mx.irc.dto.RespuestaExamenAlumnoDTO;
import com.mx.irc.entity.Estudiante;
import com.mx.irc.entity.Examen;
import com.mx.irc.entity.ExamenByPregunta;
import com.mx.irc.entity.Preguntas;
import com.mx.irc.repository.EstudianteRepository;
import com.mx.irc.repository.ExamenByPreguntaRepository;
import com.mx.irc.repository.ExamenRepository;
import com.mx.irc.repository.PreguntaRepository;
import com.mx.irc.repository.RespuestaExamenRepository;
import com.mx.irc.service.impl.ExamenServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ExamenServiceTest {

	@Mock
	private ExamenRepository examenRepository;

	@Mock
	private PreguntaRepository preguntaRepository;

	@Mock
	private ExamenByPreguntaRepository examenByPreguntaRepository;

	@Mock
	private RespuestaExamenRepository respuestaExamenRepository;
	
	@Mock
	private EstudianteRepository estudianteRepository;
	
	@InjectMocks
	private ExamenServiceImpl examenServiceImpl;
	
	
	@Test
	void crearExamenTest() throws Exception {
		
		
		List<PreguntasDTO> preguntasVo = new ArrayList<>();
		PreguntasDTO objeto1 = new PreguntasDTO();
		PreguntasDTO objeto2 = new PreguntasDTO();
		objeto1.setPregunta("cuanto es 1+1");
		objeto1.setRespuestaA("2");
		objeto1.setRespuestaB("3");
		objeto1.setRespuestaC("4");
		objeto1.setRespuestaD("5");

		objeto2.setPregunta("cuanto es 1+2");
		objeto2.setRespuestaA("3");
		objeto2.setRespuestaB("4");
		objeto2.setRespuestaC("5");
		objeto2.setRespuestaD("6");
		
		preguntasVo.add(objeto1);
		preguntasVo.add(objeto2);
		ExamenDTO examenVo = new ExamenDTO();
		examenVo.setNombre("nuevo");
		examenVo.setPreguntasVo(preguntasVo);
		ExamenByPregunta byPregunta = new ExamenByPregunta();
		byPregunta.setId(1L);
		byPregunta.setExamenIid(1L);
		byPregunta.setPreguntasExamenId(1L);
		Mockito.when(examenByPreguntaRepository.saveAndFlush(byPregunta)).thenReturn(byPregunta);
		ExamenDTO examenVos = examenServiceImpl.crearExamen(examenVo);
		assertEquals(null, examenVos);
		
	}
	
	
	@Test
	void examenByAlumnoTest() throws Exception {
		assertThat(examenServiceImpl.examenByAlumno(1, 1)).isNotNull();
	}
	
	
	
	@Test
	void responderExamenTest() throws Exception {
		Examen examen = new Examen();
		examen.setNombre("Nuevo");
		given(examenRepository.save(examen)).willReturn(examen); 
		
		Preguntas preguntas = new Preguntas();
		preguntas.setPregunta("cuanto es 1+1");
		preguntas.setRespuestaA("2");
		preguntas.setRespuestaB("3");
		preguntas.setRespuestaC("4");
		preguntas.setRespuestaD("5");
		given(preguntaRepository.save(preguntas)).willReturn(preguntas);
		Preguntas preguntas2 = new Preguntas();
		preguntas2.setPregunta("cuanto es 1+1");
		preguntas2.setRespuestaA("2");
		preguntas2.setRespuestaB("3");
		preguntas2.setRespuestaC("4");
		preguntas2.setRespuestaD("5");
		given(preguntaRepository.save(preguntas2)).willReturn(preguntas2);
		
		ExamenByPregunta byPregunta = new ExamenByPregunta();
		byPregunta.setId(1L);
		byPregunta.setExamenIid(1L);
		byPregunta.setPreguntasExamenId(1L);
		given(examenByPreguntaRepository.save(byPregunta)).willReturn(byPregunta);
		
		List<String> respuestas = new ArrayList<>();
		respuestas.add("A");
		respuestas.add("B");
		
		RespuestaExamenAlumnoDTO examenAlumnoVo = new RespuestaExamenAlumnoDTO();
		examenAlumnoVo.setAlumnoId(1L);
		examenAlumnoVo.setExamenId(1L);
		examenAlumnoVo.setRespuesta(respuestas);
		assertEquals(examenServiceImpl.responderExamen(examenAlumnoVo),"");
	}
	
	@Test
	void asignarExamenTest() throws Exception {
		Examen examen = new Examen();
		examen.setNombre("Nuevo");
		given(examenRepository.save(examen)).willReturn(examen); 

		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Juan");
		estudiante.setCiudad("Bogota");
		estudiante.setEdad(18);
		estudiante.setZonaHoraria("Bogota");
		given(estudianteRepository.save(estudiante)).willReturn(estudiante);
		
		AsignarExamenDTO asignarExamen = new AsignarExamenDTO();
		asignarExamen.setAlumnoId(1L);
		asignarExamen.setExamenId(1L);
		asignarExamen.setFechaExamen("2023-03-31");
		assertThat(examenServiceImpl.asignarExamen(asignarExamen)).isNotNull();
	}
}
