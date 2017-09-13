package com.clases.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clases.model.Profesor;
import com.clases.service.ProfesorService;

@Controller
@RequestMapping("/vr1")
public class ProfesorController {
	
	@Autowired
	ProfesorService _profesorService;
	
	//GET todos los profesores
	@RequestMapping(value="/profesores", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<Profesor>> getProfesor(){
		List<Profesor> listaProfesores = new ArrayList<>();
		listaProfesores = _profesorService.buscarProfesores();
		if(listaProfesores.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Profesor>>(listaProfesores,HttpStatus.OK);
	}
	
	//GET profesor por Id
	@RequestMapping(value="/profesores/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<Profesor> getbuscarPorId(@PathVariable("id") Long idProfesor){
		if(idProfesor==null || idProfesor<=0) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		Profesor profesor = _profesorService.buscarProfesorPorId(idProfesor);
		if(profesor.getNombre()==null){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Profesor>(profesor,HttpStatus.OK);
	}
	
	//POST 
	@RequestMapping(value="/profesores", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor, UriComponentsBuilder uriComponentsBuilder){
		
		_profesorService.guardarProfesor(profesor);
		
		Profesor profesorVista = _profesorService.buscarProfesorPorNombre(profesor.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentsBuilder.path("/vr1/profesores/{id}")
				.buildAndExpand(profesorVista.getIdProfesor())
				.toUri()
				);
		
		return new ResponseEntity<Profesor>(headers, HttpStatus.CREATED);
		
	}
	
	//UPDATE
	@RequestMapping(value="/profesores/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Profesor> actualizarProfesor(@PathVariable("id") Long idProfesor, @RequestBody Profesor profesor){
		if (idProfesor == null || idProfesor <= 0) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		
		Profesor profesorVista = _profesorService.buscarProfesorPorId(idProfesor);
		if (profesorVista == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		profesorVista.setNombre(profesor.getNombre()); // enviarle los datos consultados del profesor ---buscado por Id
		profesorVista.setAvatar(profesor.getAvatar());
		
		_profesorService.actualizarProfesor(profesorVista);
		return new ResponseEntity<Profesor>(profesorVista, HttpStatus.OK);
	}
	
	//DELETE
	@RequestMapping(value="/profesores/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Profesor> borrarProfesor(@PathVariable("id") Long idProfesor){
		if (idProfesor == null || idProfesor <= 0) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		
		Profesor profeDb = _profesorService.buscarProfesorPorId(idProfesor);
		
		if(profeDb == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		_profesorService.borrarProfesor(idProfesor);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	

}
