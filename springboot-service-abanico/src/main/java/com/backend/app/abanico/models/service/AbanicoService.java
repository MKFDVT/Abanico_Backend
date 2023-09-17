package com.backend.app.abanico.models.service;

import java.util.List;

import com.backend.app.abanico.models.entity.Abanico;

public interface AbanicoService {
	
	public List<Abanico> findAll();
	
	public Abanico findById(Long id);
	//Pendientes
		//@DeleteMapping
		//@PostMapping
		//@PutMapping
}
