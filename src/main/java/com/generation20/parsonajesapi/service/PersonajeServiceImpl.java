package com.generation20.parsonajesapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation20.parsonajesapi.dao.PersonajeRepository;
import com.generation20.parsonajesapi.error.PersonajeNotFoundException;
import com.generation20.parsonajesapi.molde.Personaje;
@Service
public class PersonajeServiceImpl implements PersonajeService{
@Autowired
private PersonajeRepository repository;

	@Override
	public Personaje save(Personaje personaje) {
		return repository.save(personaje);
	}
	
	@Override
	public List<Personaje> getAll(){
		return repository.findAll();
	}
	@Override
	public Optional<Personaje> getById(Integer id) {
		return repository.findById(id);
	}
	@Override
	public Personaje update(Integer id, Personaje personaje) {
		Personaje personajeDB = getById(id).orElseThrow(() -> new PersonajeNotFoundException(id));
		personajeDB.setNombre(personaje.getNombre());
		personajeDB.setAparicion(personaje.getAparicion());
		personajeDB.setTipo(personaje.getTipo());
		return repository.save(personajeDB);
	}
	public void remove(Integer id) {
		repository.deleteById(id);
	}
}
