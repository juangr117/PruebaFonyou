package com.mx.irc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.irc.entity.ExamenByAlumno;

public interface RespuestaExamenRepository extends JpaRepository<ExamenByAlumno, Long> {

	@Query(value = "select a from ExamenByAlumno a where a.alumnoId=?1 and   a.examenId.id =?2  ")
	List<ExamenByAlumno> listaRespuestasByAlumno(long alumnoID, long examenID);
}
