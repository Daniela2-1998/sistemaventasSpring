package com.daniela.RegistrosSistemaVentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RegistrosSistemaVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrosSistemaVentasApplication.class, args);
	}

}
