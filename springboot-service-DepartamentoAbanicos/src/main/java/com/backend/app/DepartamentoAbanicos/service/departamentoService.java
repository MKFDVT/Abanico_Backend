package com.backend.app.DepartamentoAbanicos.service;

import java.util.List;

import com.backend.app.DepartamentoAbanicos.models.Departamento;

public interface departamentoService {

	public List<Departamento> findAll();
	
	public Departamento findById(Long id, Integer cantidad);
}
