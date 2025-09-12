package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code; // CÓDIGO DO TIPO ENUMERADO
	
	private OrderStatus(int code) { // CONSTRUTOR PARA O TIPO ENUMERADO (ELE É PRIVATE)
		this.code = code;
	}
	
	public int getCode() { // MÉTODO PUBLICO PARA O MÉTODO FICAR ACESSÍVEL AO MUNDO EXTERIOR
		return code;
	}
	
	// MÉTODO ESTATICO PARA CONVERTER UM VALOR NUMERICO PARA UM TIPO ENUMERADO: 
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
	// PERCORRE TODOS OS VALORES DO TIPO ENUM, E TESTA SE O CÓDIGO É IGUAL AO QUE ESTOU QUERENDO	
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
