package com.mx.irc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.irc.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	@Query(value = "select a from Estudiante a where a.id= ?1")
	Estudiante buscarAlumnoById(Long id);
}
