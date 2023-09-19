package com.backend.app.abanico.models.service;

import java.util.List;

import com.backend.app.abanico.models.entity.Abanico;

public interface AbanicoService {
	
	public List<Abanico> findAll();
	
	public Abanico findById(Long id);
	
	public void DeleteAbanico (Long id);
	
	public void addAbanico (Abanico abanico);
	
	public void putAbanico (Abanico abanico);
	
	
}
