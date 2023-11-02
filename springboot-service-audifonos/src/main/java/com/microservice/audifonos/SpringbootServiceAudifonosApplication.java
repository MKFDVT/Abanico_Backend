package com.microservice.audifonos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceAudifonosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceAudifonosApplication.class, args);
	}

}
