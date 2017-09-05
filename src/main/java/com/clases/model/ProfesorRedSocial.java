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
@Table(name="profesor_red_social")
public class ProfesorRedSocial implements Serializable {
	
	@Id
	@Column(name="id_profesor_red_social")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProfesorRedSocial;
	
	@Column(name="nickname")
	private String nickname;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_profesor")
	private Profesor profesor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_red_social")
	private RedSocial redSocial;
	
	
	
	public ProfesorRedSocial(Profesor profesor, RedSocial redSocial, String nickname) {
		super();
		this.profesor = profesor;
		this.redSocial = redSocial;
		this.nickname = nickname;
	}
	public ProfesorRedSocial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdProfesorRedSocial() {
		return idProfesorRedSocial;
	}
	public void setIdProfesorRedSocial(Long idProfesorRedSocial) {
		this.idProfesorRedSocial = idProfesorRedSocial;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public RedSocial getRedSocial() {
		return redSocial;
	}
	public void setRedSocial(RedSocial redSocial) {
		this.redSocial = redSocial;
	}
	
	
	

}
