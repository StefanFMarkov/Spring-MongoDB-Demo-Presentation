package com.example.mongodbrepo.repositories;

import com.example.mongodbrepo.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author,String> {

    Author findByNameContaining(String name);
}
