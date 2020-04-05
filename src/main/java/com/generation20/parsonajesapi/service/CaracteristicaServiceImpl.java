package com.generation20.parsonajesapi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation20.parsonajesapi.dao.CaracteristicaRepository;
import com.generation20.parsonajesapi.molde.Caracteristica;
import com.generation20.parsonajesapi.molde.Personaje;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService{

	@Autowired
	private CaracteristicaRepository repository;
	
	@Override
	public List<Caracteristica> getAll(){
		return repository.findAll();
	}
	
	@Override
	public Caracteristica save(Integer idPersonaje, Caracteristica caracteristica) {
		//Personaje personaje = personajeRepository.findById(idPersonaje).orElseThrow(() -> new PersonajeNotFoundException(idPersonaje));
		caracteristica.setPersonaje(idPersonaje);
		caracteristica.setFechaCreacion(new Date());
		return repository.save(caracteristica);
	}
	
	@Override
	public Optional<Caracteristica> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public Caracteristica update(Integer id, Caracteristica caracteristica) {
		Caracteristica caracteristicaDB = getById(id).get();
		caracteristicaDB.setNombre(caracteristica.getNombre());
		caracteristicaDB.setValor(caracteristica.getValor());
		caracteristicaDB.setTipo(caracteristica.getTipo());
		return repository.save(caracteristicaDB);
		
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);		
	}
	@Override
	public List<Caracteristica> getByIdPersonaje(Integer idPersonaje) {
		Personaje personaje = new Personaje();
		personaje.setId(idPersonaje);
		return repository.findByIdPersonaje(idPersonaje);
	}
}
