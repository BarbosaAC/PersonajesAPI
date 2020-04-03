package com.generation20.parsonajesapi.service;

import java.util.List;
import java.util.Optional;

import com.generation20.parsonajesapi.molde.Personaje;

public interface PersonajeService {

	Personaje save(Personaje personaje);
	List<Personaje> getAll();
	Optional<Personaje> getById(Integer id);
	Personaje update(Integer id, Personaje personaje);
	void remove(Integer id);
}
