package com.generation20.parsonajesapi.service;

import java.util.List;
import java.util.Optional;

import com.generation20.parsonajesapi.molde.Caracteristica;

public interface CaracteristicaService {
	
	Caracteristica save(Integer id, Caracteristica caracteristica);
	List<Caracteristica> getByIdPersonaje(Integer idPersonaje);
	List<Caracteristica> getAll();
	Optional<Caracteristica> getById(Integer id);
	Caracteristica update(Integer id, Caracteristica caracteristica);
	void remove(Integer id);
}
