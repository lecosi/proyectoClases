package com.clases.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="profesor")
public class Profesor implements Serializable {
	
	@Id
	@Column(name="id_profesor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProfesor;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="avatar")
	private String avatar;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="id_curso")
	@JsonIgnore
	private Set<Curso> cursos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_profesor")
	@JsonIgnore
	private Set<ProfesorRedSocial> profesorRedSocial;
	
	
	
	public Profesor(String nombre, String avatar, Set<Curso> cursos, Set<ProfesorRedSocial> profesorRedSocial) {
		super();
		this.nombre = nombre;
		this.avatar = avatar;
	}
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Set<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
	public Set<ProfesorRedSocial> getProfesorRedSocial() {
		return profesorRedSocial;
	}
	public void setProfesorRedSocial(Set<ProfesorRedSocial> profesorRedSocial) {
		this.profesorRedSocial = profesorRedSocial;
	}
	
	
	

}
