package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

// A ANOTATION '@Component' JA REGISTRA A CLASSE COMO UM COMPONENTE DO SPRING E ELE VAI PODER SER INJETADO AUTOMATICAMENTE COM O AUTOWIRED 

// A ANOTATION '@Repository' REGISTRA UM REPOSITORIO

// A ANOTATION '@Service' REGISTRA UM SERVICO NA SUA CAMADA DE SERVICO

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	// METODO PARA RETORNAR TODOS OS USUARIOS DO BANCO DE DADOS
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); // RETORNA O OBJETO DO TIPO QUE ESTIVER DENTRO DO OPTION
	}
}
