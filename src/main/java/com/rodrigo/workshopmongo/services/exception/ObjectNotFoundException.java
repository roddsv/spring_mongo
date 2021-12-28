package com.rodrigo.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		/*O super passa a mensagem para a superclasse RuntimeException */
		super(msg);
	}
}