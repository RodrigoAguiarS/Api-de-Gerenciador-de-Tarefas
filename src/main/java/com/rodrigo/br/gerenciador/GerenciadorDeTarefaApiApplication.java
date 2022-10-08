package com.rodrigo.br.gerenciador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
@EnableCaching
public class GerenciadorDeTarefaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeTarefaApiApplication.class, args);
	}

}
