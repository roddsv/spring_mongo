package com.rodrigo.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.workshopmongo.domain.User;
import com.rodrigo.workshopmongo.dto.UserDTO;
import com.rodrigo.workshopmongo.services.UserService;

/*RestController é para dizer que a Classe é de Resource.
 RequestMapping para determinar o endpoint que chama a classe*/
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	/*GetMapping determina o método GET na chamada do endpoint, assim como o 
	 @RequestMapping(method=RequestMethod.GET) */
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	/*PathVariable é usado para indicar que o id usado na rota é o mesmo que o método vai receber.*/
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

}
