package com.mx.irc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.irc.entity.Preguntas;

public interface PreguntaRepository extends JpaRepository<Preguntas, Long> {

}
