package com.microservice.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservice.common.users.entity.Usuario;

@FeignClient("servicio-usuarios")
public interface UsuarioFeingClient {
	
	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(String username); //Si no fundiona poner usernanme

}
