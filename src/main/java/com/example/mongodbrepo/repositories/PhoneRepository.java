package com.example.mongodbrepo.repositories;

import com.example.mongodbrepo.model.Phone;
import com.example.mongodbrepo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends MongoRepository<Phone, String> {


    Phone findPhoneById(String id);


    Phone findPhoneByUser(User user);
}
