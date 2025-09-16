package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // ANOTAÇÃO PARA DIZER QUE A CLASSE É UM RECURSO WEB IMPLEMENTADO POR UM CONTROLADOR REST
@RequestMapping(value="/users") // DAR UM NOME PARA O RECURSO (COLOCAR ENTRE ASPAS O CAMINHO DO RECURSO, QUE NO CASO É RELACIONADO A ENTIDADE USERS)
public class UserResource {
	
	// DEPENDENCIA PARA O SERVICE: 
	
	@Autowired
	private UserService service;
	
	// CRIAR UM METODO PARA ACESSAR OS USUARIOS:
	
	//@GetMapping // INDICA QUE O METODO RESPONDE A REQUISICAO DO TIPO GET DO HTTP
	// public ResponseEntity<User> findAll() {
		
		// APAGANDO ABAIXO A INSTANCIAÇÃO MANUAL PARA FAZER A DECLARAÇÃO DE UMA LISTA DE USUARIOS
		
		//User u = new User(1L, "Maria","maria@gmail.com", "999999999", "12345");
		
		// return ResponseEntity.ok().body(u); // O 'OK' RETORNA A RESPOSTA COM SUCESSO DO HTTP E O 'BODY' RETORNA O CORPO DA RESPOSTA DO USUARIO INSTANCIADO (U)
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// A ANOTATION '@PathVariable' SERVE PARA O FIND BY ID RECEBER O PARAMETRO DE URL ("/id") 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) { // PARA DIZER QUE O OBJETO CHEGA NO MODO JSON
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) { // 'VOID' POIS A RESPOSTA DA REQUISIÇÃO NÃO ME RETORNA NENHUM CORPO, APENAS DELETAR
		service.delete(id);
		return ResponseEntity.noContent().build(); // 'NO CONTENT' RETORNA UAM RESPOSTA VAZIA COM CÓDIGO HTTP 204
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
