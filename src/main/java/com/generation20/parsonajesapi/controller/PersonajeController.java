package com.generation20.parsonajesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation20.parsonajesapi.molde.Personaje;
import com.generation20.parsonajesapi.service.PersonajeService;


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
	public Personaje getPersonajeById(@PathVariable Integer id) {
		return service.getById(id);
	}
	@PostMapping
	public Personaje createPersonaje(@RequestBody Personaje personaje) {
		return service.save(personaje);
	}
}
