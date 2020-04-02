package com.generation20.parsonajesapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation20.parsonajesapi.molde.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer>{

}
