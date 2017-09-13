package com.clases.dao;

import com.clases.model.Profesor;

import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clases.dao.sesionAbstracta;

@Repository
@Transactional
public class ProfesorDaoImpl extends sesionAbstracta implements ProfesorDao {

	@Override
	public List<Profesor> buscarProfesores() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Profesor").list();
	}

	@Override
	public void guardarProfesor(Profesor profesor) {
		getSession().persist(profesor);
		
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		getSession().update(profesor);
		
	}

	@Override
	public void borrarProfesor(Long idProfesor) {
		
		Profesor profesor = buscarProfesorPorId(idProfesor);
		if(profesor!=null) {
			profesor.getProfesorRedSocial().clear();
			getSession().delete(profesor);
		}
		
	}

	@Override
	public Profesor buscarProfesorPorId(Long idProfesor) {
		// TODO Auto-generated method stub
		return (Profesor) getSession().get(Profesor.class, idProfesor);
	}

	@Override
	public Profesor buscarProfesorPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return (Profesor) getSession().createQuery("from Profesor where nombre = :nombre").setParameter("nombre", nombre).uniqueResult();
		
	}

}
