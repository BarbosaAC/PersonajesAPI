package com.generation20.parsonajesapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation20.parsonajesapi.molde.Caracteristica;


@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Integer>{

	List<Caracteristica> findByIdPersonaje(Integer id);
}
