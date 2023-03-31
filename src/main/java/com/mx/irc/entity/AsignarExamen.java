package com.mx.irc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "asignarExamen")
public class AsignarExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "alumnoId")
	private Long alumnoId;
	@Column(name = "fechaExamen")
	private String fechaExamen;
	@Column(name = "examenId")
	private Long examenId;
	
}
