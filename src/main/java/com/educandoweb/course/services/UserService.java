package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // RETORNA O OBJETO DO TIPO QUE ESTIVER DENTRO DO OPTION
	}
	
	public User insert(User obj) {
		return repository.save(obj); // INSERE NO BANCO UM NOVO OBJETO DO TIPO USER
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());	
	}
}
