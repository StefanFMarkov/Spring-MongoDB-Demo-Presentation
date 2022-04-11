package com.example.mongodbrepo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Document
public class User {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String userId;
    @Indexed(name = "name", direction = IndexDirection.DESCENDING)
    @NotNull
    @Size(min = 1)
    private String name;
    @Field(name = "favourite_author")
    private List<Author> favouritesAuthors;
    private List<Book> books;

    public User() {

    }

    public List<Author> getFavouritesAuthors() {
        return favouritesAuthors;
    }

    public User setFavouritesAuthors(List<Author> favouritesAuthors) {
        this.favouritesAuthors = favouritesAuthors;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public User setBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "books=" + books +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", favouritesAuthors=" + favouritesAuthors +
                '}';
    }
}
