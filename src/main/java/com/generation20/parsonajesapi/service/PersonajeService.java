package com.generation20.parsonajesapi.service;

import java.util.List;

import com.generation20.parsonajesapi.molde.Personaje;

public interface PersonajeService {

	Personaje save(Personaje personaje);
	List<Personaje> getAll();
	Personaje getById(Integer id);
	Personaje update(Integer id, Personaje personaje);
	void remove(Integer id);
}
