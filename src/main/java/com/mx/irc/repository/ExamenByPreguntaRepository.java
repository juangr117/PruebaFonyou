package com.mx.irc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.irc.entity.ExamenByPregunta;

public interface ExamenByPreguntaRepository extends JpaRepository<ExamenByPregunta, Long> {

	@Query(value = "select count(*) from exmen_preguntas where id_examen = ?1",nativeQuery = true)
	Long buscarTotalPregutasPorExamen(Long idExamen);
	
	@Query(value = "select b.respuestaa  from exmen_preguntas a  "
			+ "inner join preguntasexamen b on a.id_pregunta = b.id "
			+ "where id_examen  = ?1",nativeQuery = true)
	List<String> buscarRespuestasByExamen(Long idExamen);
	
}
