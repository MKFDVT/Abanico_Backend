package com.microservice.usuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.repository.query.Param;

import com.microservice.common.users.entity.*;

@RepositoryRestResource(path="usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository <Usuario, Long>{
	@RestResource(path="buscar-username")
	public Usuario findByUsername(@Param("nombre") String username);
	public Usuario findByUsernameAndEmail(String username,String email);

}
