package com.rodrigo.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.workshopmongo.domain.User;
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
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
