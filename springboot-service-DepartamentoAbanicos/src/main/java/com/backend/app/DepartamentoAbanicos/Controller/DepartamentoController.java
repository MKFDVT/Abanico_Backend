package com.backend.app.DepartamentoAbanicos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.DepartamentoAbanicos.models.Abanico;
import com.backend.app.DepartamentoAbanicos.models.Departamento;
import com.backend.app.DepartamentoAbanicos.service.DepartamentoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	@GetMapping("/list")
	public List<Departamento> list(){
		return departamentoService.findAll();
	}
	@HystrixCommand(fallbackMethod="metodoFallas")
	@GetMapping("/store/(id)/cantidad/(cantidad)")
	public Departamento details(@PathVariable Long id, @PathVariable Integer cantidad) {
		return departamentoService.findById(id,cantidad);
	}
	public Departamento metodoFallas(Long id, Integer cantidad) {
		Departamento depa = new Departamento();
		Abanico aba = new Abanico();
		
		aba.setId(id);
		aba.setName("Abanico Desconocido");
		aba.setName("Desconocida");
		depa.setCantidad(0);
		depa.setFan(aba);
		
		return depa;
	}
}
