package com.generation20.parsonajesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation20.parsonajesapi.error.PersonajeNotFoundException;
import com.generation20.parsonajesapi.molde.Personaje;
import com.generation20.parsonajesapi.service.PersonajeService;

//Configurar el bean para que pueda ser alcanzado como un tendedor de aplicacion
@RestController 
@RequestMapping("/v1/personajes")
public class PersonajeController {

	@Autowired
	private PersonajeService service;
	
	@GetMapping
	public List<Personaje> getPersonajes(){
		return service.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Personaje> getPersonajeById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(
				service.getById(id).orElseThrow(() -> new PersonajeNotFoundException(id)), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Personaje> createPersonaje(@RequestBody Personaje personaje) {
		return new ResponseEntity<>(service.save(personaje), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Personaje> updatePersonaje(@PathVariable("id") Integer id, @RequestBody Personaje personaje){
		return new ResponseEntity<>(service.update(id, personaje), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePersonaje(@PathVariable("id") Integer id){
		service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
