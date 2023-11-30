package com.microservice.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.common.users.entity.Usuario;

@FeignClient("servicio-usuarios")
public interface UsuarioFeingClient {
	
	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(RequestParam String); //Si no fundiona poner usernanme

}
