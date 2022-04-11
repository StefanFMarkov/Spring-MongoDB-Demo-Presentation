package com.example.mongodbrepo.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

@Document
public class Phone {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    @Field(value = "model",write = Field.Write.NON_NULL)
    private String model;
    private int size;
    @DocumentReference
    private User user;
    public Phone() {
    }

    public String getId() {
        return id;
    }

    public Phone setId(String id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Phone setModel(String model) {
        this.model = model;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Phone setSize(int size) {
        this.size = size;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Phone setUser(User user) {
        this.user = user;
        return this;
    }

}
