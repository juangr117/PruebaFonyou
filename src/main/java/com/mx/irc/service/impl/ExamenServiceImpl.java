package com.mx.irc.service.impl;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.irc.dto.AsignarExamenDTO;
import com.mx.irc.dto.ExamenDTO;
import com.mx.irc.dto.PreguntasDTO;
import com.mx.irc.dto.RespuestaExamenAlumnoDTO;
import com.mx.irc.entity.AsignarExamen;
import com.mx.irc.entity.Estudiante;
import com.mx.irc.entity.Examen;
import com.mx.irc.entity.ExamenByAlumno;
import com.mx.irc.entity.ExamenByPregunta;
import com.mx.irc.entity.Preguntas;
import com.mx.irc.repository.AsignarExamenRepository;
import com.mx.irc.repository.EstudianteRepository;
import com.mx.irc.repository.ExamenByPreguntaRepository;
import com.mx.irc.repository.ExamenRepository;
import com.mx.irc.repository.PreguntaRepository;
import com.mx.irc.repository.RespuestaExamenRepository;
import com.mx.irc.service.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	private ExamenRepository examenRepository;

	@Autowired
	private PreguntaRepository preguntaRepository;

	@Autowired
	private ExamenByPreguntaRepository examenByPreguntaRepository;

	@Autowired
	private RespuestaExamenRepository respuestaExamenRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;

	@Autowired
	private AsignarExamenRepository asignarExamenRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ExamenDTO crearExamen(ExamenDTO examenVo) throws Exception {

		if (examenVo.getNombre().length()   == 0) {
			throw new Exception("Se necesita un nombre para el examen");
		}

		Examen examen = new Examen();
		examen.setNombre(examenVo.getNombre());
		Examen resExamen = examenRepository.save(examen);
		for (PreguntasDTO data : examenVo.getPreguntasVo()) {
			Preguntas preguntas = new Preguntas();
			ExamenByPregunta examenByPregunta = new ExamenByPregunta();
			preguntas.setPregunta(data.getPregunta());
			preguntas.setRespuestaA(data.getRespuestaA());
			preguntas.setRespuestaB(data.getRespuestaB());
			preguntas.setRespuestaC(data.getRespuestaC());
			preguntas.setRespuestaD(data.getRespuestaD());
			Preguntas resPregunta = preguntaRepository.saveAndFlush(preguntas);
			examenByPregunta.setExamenIid(resExamen.getId());
			examenByPregunta.setPreguntasExamenId(resPregunta.getId());
			examenByPreguntaRepository.saveAndFlush(examenByPregunta);
		}
		return examenVo;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public String responderExamen(RespuestaExamenAlumnoDTO examenAlumnoVo) throws Exception {
		Long totalPreguntas = examenByPreguntaRepository.buscarTotalPregutasPorExamen(examenAlumnoVo.getExamenId());
		int calificacion = 0;
		if (totalPreguntas == 0) {
			throw new Exception("Examen sin preguntas");
		} else {
			List<String> respuestasByExamen = examenByPreguntaRepository
					.buscarRespuestasByExamen(examenAlumnoVo.getExamenId());
			int correctas = 0;
			for (String elemento : respuestasByExamen) {
				if (examenAlumnoVo.getRespuesta().contains(elemento)) {
					correctas++;
				}
			}
			examenAlumnoVo.getRespuesta().stream().forEach(data -> {
				ExamenByAlumno examenByAlumno = new ExamenByAlumno();
				Examen examenId = new Examen();
				examenByAlumno.setAlumnoId(examenAlumnoVo.getAlumnoId());
				examenId.setId(examenAlumnoVo.getExamenId());
				examenByAlumno.setExamenId(examenId);
				examenByAlumno.setRespuesta(data);
				respuestaExamenRepository.saveAndFlush(examenByAlumno);
			});
			calificacion = (int) (correctas * 100 / totalPreguntas);
		}

		return "Tu calificaion es " + calificacion + " de 100 puntos ";
	}

	@Override
	public List<ExamenByAlumno> examenByAlumno(long examenId, long alumno) throws Exception {
		if (examenId == 0) {
			throw new Exception("Id de examen necesario");
		}
		if (alumno == 0) {
			throw new Exception("id alumno necesario");
		}
		return respuestaExamenRepository.listaRespuestasByAlumno(alumno, examenId);
	}

	@Override
	public String asignarExamen(AsignarExamenDTO asignarExamen) throws Exception {
		Estudiante estudiante = estudianteRepository.buscarAlumnoById(asignarExamen.getAlumnoId());
		ZoneId zonaAlumno = ZoneId.of(estudiante.getZonaHoraria());
		LocalTime horaAlumno = LocalTime.now(zonaAlumno);
		AsignarExamen entity = new AsignarExamen();
		entity.setAlumnoId(asignarExamen.getAlumnoId());
		entity.setExamenId(asignarExamen.getExamenId());
		entity.setFechaExamen(asignarExamen.getFechaExamen()+"  "+horaAlumno);
		asignarExamenRepository.save(entity);
		return "Tu fecha de examen es "+asignarExamen.getFechaExamen()+"  "+horaAlumno;
	}
	
	

	

}
