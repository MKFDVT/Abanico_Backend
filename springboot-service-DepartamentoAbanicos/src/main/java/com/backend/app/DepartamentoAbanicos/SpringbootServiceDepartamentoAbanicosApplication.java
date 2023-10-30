package com.backend.app.DepartamentoAbanicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceDepartamentoAbanicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceDepartamentoAbanicosApplication.class, args);
	}

}
