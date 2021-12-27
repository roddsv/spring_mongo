package com.rodrigo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.workshopmongo.domain.User;

/* Repository permite fazer operações de CRUD básicas entre a aplicação e o banco de dados*/
@Repository
public interface UserRepository extends MongoRepository<User, String>{	
}
