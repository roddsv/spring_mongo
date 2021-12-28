package com.rodrigo.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
