package com.backend.app.DepartamentoAbanicos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.DepartamentoAbanicos.models.Departamento;
import com.backend.app.DepartamentoAbanicos.service.departamentoService;

@RestController
public class DepartamentoController {

	@Autowired
	private Departamento departamentoService;
	@GetMapping("/list")
	public List<Departamento> list(){
		return departamentoService.findAll();
	}
	
	@GetMapping("/store/{id}/cantidad/{cantidad}")
	public Departamento details(@PathVariable Long id, @PathVariable Integer cantidad) {
		return departamentoService.findById(id,cantidad);
	}
}
