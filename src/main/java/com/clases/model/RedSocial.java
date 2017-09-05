package com.clases.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Cacheable;
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
@Cacheable(false)
@Table(name="red_social")
public class RedSocial implements Serializable {
	
	@Id
	@Column(name="id_red_social")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRedSocial;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="icono")
	private String icono;
	
	@OneToMany
	@JoinColumn(name="id_red_social")
	@JsonIgnore
	private Set<ProfesorRedSocial> profesorRedSocial;
	
	public RedSocial(String nombre, String icono) {
		super();
		this.nombre = nombre;
		this.icono = icono;
	}
	public RedSocial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdRedSocial() {
		return idRedSocial;
	}
	public void setIdRedSocial(Long idRedSocial) {
		this.idRedSocial = idRedSocial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public Set<ProfesorRedSocial> getProfesorRedSocial() {
		return profesorRedSocial;
	}
	public void setProfesorRedSocial(Set<ProfesorRedSocial> profesorRedSocial) {
		this.profesorRedSocial = profesorRedSocial;
	}
		
	

}
