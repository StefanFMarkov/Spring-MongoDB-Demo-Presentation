package com.example.mongodbrepo.repositories;

import com.example.mongodbrepo.model.BookModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookModelRepository extends MongoRepository<BookModel,String> {

    BookModel findByModel(String model);

}
