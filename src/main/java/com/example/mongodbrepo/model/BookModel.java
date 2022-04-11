package com.example.mongodbrepo.model;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "book_model")
public class BookModel {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    private String model;

    @ReadOnlyProperty
    @DocumentReference(lookup = "{'bookModel._id': ?# { #self.id } }")
    private List<Book> books;

    public BookModel() {
    }

    public String getId() {
        return id;
    }

    public BookModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public BookModel setModel(String model) {
        this.model = model;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public BookModel setBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", books=" + books +
                '}';
    }
}
