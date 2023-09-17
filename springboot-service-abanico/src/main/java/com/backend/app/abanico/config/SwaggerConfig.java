package com.backend.app.abanico.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDoker () {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.backend.app.microfono.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
		
	}

	private ApiInfo getApiInfo() {
		
		return new ApiInfo(
				"microfono",
				"servicio para registrar microfonos",
				"1.0.0",
				"Terminos del servicio (...)",
				new Contact("Felipe","https://www.google.com","valladarestf@gmail.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}

}
