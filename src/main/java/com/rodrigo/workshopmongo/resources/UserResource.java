package com.rodrigo.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.workshopmongo.domain.User;

/*RestController é para dizer que a Classe é de Resource.
 RequestMapping para determinar o endpoint que chama a classe*/
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	/*GetMapping determina o método GET na chamada do endpoint, assim como o 
	 @RequestMapping(method=RequestMethod.GET) */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}

}
