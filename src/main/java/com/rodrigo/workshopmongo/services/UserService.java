package com.rodrigo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.workshopmongo.domain.User;
import com.rodrigo.workshopmongo.repository.UserRepository;

/* Indica que a classe é um Serviço que pode ser injetado em outras classes da aplicação.*/
@Service
public class UserService {
	/* Autowired instancia um objeto automaticamente dentro do Serviço*/
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
