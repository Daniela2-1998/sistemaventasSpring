package com.daniela.sistemaventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SistemaventasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaventasApplication.class, args);
	}

}
