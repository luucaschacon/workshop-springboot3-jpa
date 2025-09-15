package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

// A ANOTATION '@Component' JA REGISTRA A CLASSE COMO UM COMPONENTE DO SPRING E ELE VAI PODER SER INJETADO AUTOMATICAMENTE COM O AUTOWIRED 

// A ANOTATION '@Repository' REGISTRA UM REPOSITORIO

// A ANOTATION '@Service' REGISTRA UM SERVICO NA SUA CAMADA DE SERVICO

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	// METODO PARA RETORNAR TODOS OS USUARIOS DO BANCO DE DADOS
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get(); // RETORNA O OBJETO DO TIPO QUE ESTIVER DENTRO DO OPTION
	}
}
