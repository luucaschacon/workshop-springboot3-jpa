package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//CLASSE ESPECÍFICA DE CONFIGURAÇÃO

@Configuration
@Profile("test") // PARA FALAR QUE A CLASSE ELA VAI SER UMA CONFIGURAÇÃO ESPECIFICA PARA O PERFIL DE TESTE. O "TESTE" É O QUE ESTA NO PROFILE (APLICATION.PROPERTIES) 
public class TestConfig implements CommandLineRunner { 

	// 'AUTOWIRED' --> PARA QUE O SPRING CONSIGA RESOLVER A DEPENDENCIA E ASSOCIAR UMA INSTANCIA DO USERREPOSITORY NO TEST CONFIG
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		// INSTANCIANDO DOIS USUARIOS:
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");
		
		// SALVANDO OS DOIS USUARIOS NO BANCO DE DADOS:
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
}
