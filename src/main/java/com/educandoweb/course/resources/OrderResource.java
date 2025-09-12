package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController // ANOTAÇÃO PARA DIZER QUE A CLASSE É UM RECURSO WEB IMPLEMENTADO POR UM CONTROLADOR REST
@RequestMapping(value="/orders") // DAR UM NOME PARA O RECURSO (COLOCAR ENTRE ASPAS O CAMINHO DO RECURSO, QUE NO CASO É RELACIONADO A ENTIDADE OrderS)
public class OrderResource {
	
	// DEPENDENCIA PARA O SERVICE: 
	
	@Autowired
	private OrderService service;
	
	// CRIAR UM METODO PARA ACESSAR OS USUARIOS:
	
	//@GetMapping // INDICA QUE O METODO RESPONDE A REQUISICAO DO TIPO GET DO HTTP
	// public ResponseEntity<Order> findAll() {
		
		// APAGANDO ABAIXO A INSTANCIAÇÃO MANUAL PARA FAZER A DECLARAÇÃO DE UMA LISTA DE USUARIOS
		
		//Order u = new Order(1L, "Maria","maria@gmail.com", "999999999", "12345");
		
		// return ResponseEntity.ok().body(u); // O 'OK' RETORNA A RESPOSTA COM SUCESSO DO HTTP E O 'BODY' RETORNA O CORPO DA RESPOSTA DO USUARIO INSTANCIADO (U)
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// A ANOTATION '@PathVariable' SERVE PARA O FIND BY ID RECEBER O PARAMETRO DE URL ("/id") 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
