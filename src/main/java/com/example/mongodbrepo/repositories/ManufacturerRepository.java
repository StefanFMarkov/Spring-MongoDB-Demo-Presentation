package com.example.mongodbrepo.repositories;

import com.example.mongodbrepo.model.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends MongoRepository<Manufacturer, String> {

    @Query("{cars :{$id: ?0} }")
    Manufacturer findManufacturerByCarId(String id);
}
