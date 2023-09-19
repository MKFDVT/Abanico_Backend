package com.backend.app.abanico.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.abanico.models.dao.AbanicoDto;
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
	public ResponseEntity<String> detailD(@PathVariable Long id) {
		service.DeleteAbanico(id);
		return ResponseEntity.ok("Se a borrado el registro");
	}
	@PostMapping("/Abanico")
	public ResponseEntity<String> addAbanico(@RequestBody Abanico abanico){
		service.addAbanico(abanico);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/Abanico/{id}")
	public ResponseEntity<String> putAbanico(@PathVariable Long id, @RequestBody Abanico abanico){
		Abanico NuevoAbanico = service.findById(id);
		if (NuevoAbanico==null) {
			return ResponseEntity.notFound().build();
		} 
		NuevoAbanico.setName(abanico.getName());
		NuevoAbanico.setMarca(abanico.getMarca());
		NuevoAbanico.setCreateAt(abanico.getCreateAt());
		service.putAbanico(NuevoAbanico);
		return ResponseEntity.ok("Abanico Actualizado");
	}
	
}
