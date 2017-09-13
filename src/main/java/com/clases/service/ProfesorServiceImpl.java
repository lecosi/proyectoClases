package com.clases.service;

import com.clases.model.Profesor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clases.dao.ProfesorDao;

@Service("profesorService")
@Transactional
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	private ProfesorDao _profesorDao;
	
	@Override
	public List<Profesor> buscarProfesores() {
		// TODO Auto-generated method stub
		return _profesorDao.buscarProfesores();
	}

	@Override
	public void guardarProfesor(Profesor profesor) {
		_profesorDao.guardarProfesor(profesor);
		
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		_profesorDao.actualizarProfesor(profesor);
		
	}

	@Override
	public void borrarProfesor(Long idProfesor) {
		_profesorDao.borrarProfesor(idProfesor);
		
	}

	@Override
	public Profesor buscarProfesorPorId(Long idProfesor) {
		// TODO Auto-generated method stub
		return _profesorDao.buscarProfesorPorId(idProfesor);
	}

	@Override
	public Profesor buscarProfesorPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return _profesorDao.buscarProfesorPorNombre(nombre);
	}

}
