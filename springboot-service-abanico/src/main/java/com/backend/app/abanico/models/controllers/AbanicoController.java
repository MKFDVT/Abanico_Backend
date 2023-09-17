package com.backend.app.abanico.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.abanico.models.entity.Abanico;
import com.backend.app.abanico.models.service.AbanicoService;

@RestController
public class AbanicoController {

	@Autowired
	private AbanicoService service;
	
	@GetMapping("/list")
	public List<Abanico> list(){
		return service.findAll();
	}
	@GetMapping("/Abanico/{id}")
	public Abanico detail(@PathVariable Long id) {
		return service.findById(id);
	}
	@DeleteMapping("/Abanico/{id}")
	public Abanico detailD(@PathVariable Long id) {
		return service.findById(id);
	}
	
	//Pendientes
	//@DeleteMapping
	//@PostMapping
	//@PutMapping
}
