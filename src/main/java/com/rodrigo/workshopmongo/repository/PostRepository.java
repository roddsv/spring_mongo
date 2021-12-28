package com.rodrigo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rodrigo.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
