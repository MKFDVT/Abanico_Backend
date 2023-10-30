package com.backend.app.DepartamentoAbanicos.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.app.DepartamentoAbanicos.models.Abanico;
import com.backend.app.DepartamentoAbanicos.models.Departamento;

@Service
public class departamentoServiceRestImpl implements departamentoService {

	@Autowired
	private RestTemplate clientRest;
	@Override
	public List<Departamento> findAll() {
		List<Abanico> Abanicos = Arrays.asList(clientRest.getForObject("https://localhost:8081/list", Abanico[].class));
		return Abanicos.stream().map(c -> new Departamento(c,5)).collect(Collectors.toList());
	}

	@Override
	public Departamento findById(Long id, Integer cantidad) {
		Map<String,String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Abanico Aban = clientRest.getForObject("https://localhost:8081/", Abanico.class,pathVariables);
		return new Departamento(Aban, cantidad);
	}

}
