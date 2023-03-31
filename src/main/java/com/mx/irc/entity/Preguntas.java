package com.mx.irc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "preguntasexamen")
public class Preguntas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "pregunta")
	private String pregunta;
	@Column(name = "respuestaA")
	private String respuestaA;
	@Column(name = "respuestaB")
	private String respuestaB;
	@Column(name = "respuestaC")
	private String respuestaC;
	@Column(name = "respuestaD")
	private String respuestaD;
	
}
