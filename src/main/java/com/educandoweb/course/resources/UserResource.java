package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController // ANOTAÇÃO PARA DIZER QUE A CLASSE É UM RECURSO WEB IMPLEMENTADO POR UM CONTROLADOR REST
@RequestMapping(value="/users") // DAR UM NOME PARA O RECURSO (COLOCAR ENTRE ASPAS O CAMINHO DO RECURSO, QUE NO CASO É RELACIONADO A ENTIDADE USERS)
public class UserResource {
	
	// CRIAR UM METODO PARA ACESSAR OS USUARIOS:
	
	@GetMapping // INDICA QUE O METODO RESPONDE A REQUISICAO DO TIPO GET DO HTTP
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria","maria@gmail.com", "999999999", "12345");
		return ResponseEntity.ok().body(u); // O 'OK' RETORNA A RESPOSTA COM SUCESSO DO HTTP E O 'BODY' RETORNA O CORPO DA RESPOSTA DO USUARIO INSTANCIADO (U)
	}

}
