package com.microservice.oauth.service;

import com.microservice.common.users.entity.Usuario;

public interface IUsauarioService {

	public Usuario findByUsername(String username);
}
