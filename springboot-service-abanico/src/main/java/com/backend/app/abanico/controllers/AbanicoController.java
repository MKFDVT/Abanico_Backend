package com.backend.app.abanico.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbanicoController {
	
	//Valores de prueba
	List<String> listaDeStrings = Arrays.asList("Valor1","Valor2","Valor3","Valor4","Valor5","Valor6","Valor7","Valor7","Valor8","Valor9","Valor10");
	//Conexion service
	
	//Definicion de endpoints
	@GetMapping("/list")
	public List<String> list(){
		
		return listaDeStrings;
	}
}
