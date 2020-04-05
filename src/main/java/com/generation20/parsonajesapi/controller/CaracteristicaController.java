package com.generation20.parsonajesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation20.parsonajesapi.molde.Caracteristica;
import com.generation20.parsonajesapi.service.CaracteristicaService;

@RestController
@RequestMapping("/v1/caracteristicas")
public class CaracteristicaController {

	@Autowired
	private CaracteristicaService service;
	
	@GetMapping
	public List<Caracteristica> getCaracteriticas(){
		return service.getAll();
	}

}
	