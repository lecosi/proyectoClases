package com.clases.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso implements Serializable {
	
	@Id
	@Column(name="id_curso")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCurso;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="tema")
	private String tema;
	
	@Column(name="proyecto")
	private String proyecto;
	
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_profesor")
	private Profesor profesor;
	
	
	public Curso() {
		super();
	}	

	public Long getIdCurso() {
		return idCurso;
	}


	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}


	public String getProyecto() {
		return proyecto;
	}


	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
	

}
