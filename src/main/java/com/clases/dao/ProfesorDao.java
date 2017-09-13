package com.clases.dao;

import java.util.List;
import com.clases.model.Profesor;

public interface ProfesorDao {
	
	List<Profesor> buscarProfesores();
	
	void guardarProfesor(Profesor profesor);
	
	void actualizarProfesor(Profesor profesor);
	
	void borrarProfesor(Long idProfesor);
	
	Profesor buscarProfesorPorId(Long idProfesor);
	
	Profesor buscarProfesorPorNombre(String nombre);
	

}
