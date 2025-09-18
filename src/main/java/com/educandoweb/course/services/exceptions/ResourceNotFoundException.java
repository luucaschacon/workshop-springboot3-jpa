package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) { // PASSANDO O ID DO OBJETO QUE TENTOU ENCONTRAR MAS NÃO ENCONTROU
		super("Resource not found. Id " + id);
	}
}
