package com.example.mongodbrepo.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;
import org.springframework.lang.NonNullApi;

@Document
public class Car {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String carId;
    @Indexed(unique = true)
    @Field(write = Field.Write.NON_NULL)
    private String model;
    private String color;
    @DBRef
    private User user;

    public Car() {
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "Car{" + "carId='" + carId + '\'' + ", model='" + model + '\'' + ", color='" + color + '\'' + ", user=" + user + '}' + System.lineSeparator();
    }

    public String getCarId() {
        return carId;
    }

    public Car setCarId(String carId) {
        this.carId = carId;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Car setUser(User user) {
        this.user = user;
        return this;
    }
}
