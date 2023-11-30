package com.microservice.usuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.microservice.entity.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository <Usuario, Long>{
	
	public Usuario findByUsername(String username);
	public Usuario findByUsernameAndEmail(String username,String email);

}
