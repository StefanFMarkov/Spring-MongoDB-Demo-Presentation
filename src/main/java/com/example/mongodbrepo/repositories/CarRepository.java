package com.example.mongodbrepo.repositories;

import com.example.mongodbrepo.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    Car findCarByColor(String color);

    Car findCarByUser_UserId(String id);


    @Query( "{user:{ 'name' : { '$regularExpression' : { 'pattern' : ?0, 'options' :''}}} }")
    Car findByUser_Name(String name);
}
