package com.rodrigo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.workshopmongo.domain.User;
import com.rodrigo.workshopmongo.dto.UserDTO;
import com.rodrigo.workshopmongo.repository.UserRepository;
import com.rodrigo.workshopmongo.services.exception.ObjectNotFoundException;

/* Indica que a classe é um Serviço que pode ser injetado em outras classes da aplicação.*/
@Service
public class UserService {
	/* Autowired instancia um objeto automaticamente dentro do Serviço*/
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	/*Método para procurar o usuário pelo id e, caso não encontre, retorna a mensagem via tratamento de exceção*/
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Not found object"));
	}
	
	/*Implementação do POST de Usuário*/
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
