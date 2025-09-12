package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

// A ANOTATION '@Component' JA REGISTRA A CLASSE COMO UM COMPONENTE DO SPRING E ELE VAI PODER SER INJETADO AUTOMATICAMENTE COM O AUTOWIRED 

// A ANOTATION '@Repository' REGISTRA UM REPOSITORIO

// A ANOTATION '@Service' REGISTRA UM SERVICO NA SUA CAMADA DE SERVICO

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	// METODO PARA RETORNAR TODOS OS USUARIOS DO BANCO DE DADOS
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); // RETORNA O OBJETO DO TIPO QUE ESTIVER DENTRO DO OPTION
	}
}
