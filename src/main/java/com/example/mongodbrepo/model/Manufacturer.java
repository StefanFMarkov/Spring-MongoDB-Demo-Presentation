package com.example.mongodbrepo.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class Manufacturer {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String manufacturerId;
    private int yearOfStarting;
    @DBRef
    private List<Car> cars;

    public Manufacturer() {
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerId='" + manufacturerId + '\'' +
                ", yearOfStarting=" + yearOfStarting +
                ", cars=" + cars +
                '}';
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public Manufacturer setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
        return this;
    }

    public int getYearOfStarting() {
        return yearOfStarting;
    }

    public Manufacturer setYearOfStarting(int yearOfStarting) {
        this.yearOfStarting = yearOfStarting;
        return this;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Manufacturer setCars(List<Car> cars) {
        this.cars = cars;
        return this;
    }
}
