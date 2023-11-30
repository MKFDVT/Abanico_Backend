package com.microservice.zuul.oaut;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourseServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(jwtTokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/api/security/oauth/**").permitAll()
		.antMatchers(HttpMethod.GET,"/api/abanicos/list","/api/departamento/list","/api/us/usuarios").permitAll()
		.antMatchers(HttpMethod.GET,"/api/abanicos/Abanico/{id}","/api/departamento/store/(id)/cantidad/(cantidad)t","/api/us/usuarios/{id}").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.POST,"/api/abanicos/Abanico","/api/us/usuarios").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/api/abanicos/Abanico/{id}","/api/us/usuarios/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/api/abanicos/Abanico/{id}","/api/us/usuarios/{id}").hasRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	@Bean
	public JwtTokenStore jwtTokenStore(){
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("llave_belica_4x4");
		return tokenConverter;
	}
	

}
