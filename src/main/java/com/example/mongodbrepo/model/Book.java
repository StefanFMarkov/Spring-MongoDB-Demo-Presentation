package com.example.mongodbrepo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Document
public class Book {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    @NotNull
    private String title;
    @Indexed(name = "pages", direction = IndexDirection.DESCENDING)
    @Min(value = 1)
    @Positive
    private int pages;
    private BookModel bookModel;

    public BookModel getBookModel() {
        return bookModel;
    }

    public Book setBookModel(BookModel bookModel) {
        this.bookModel = bookModel;
        return this;
    }

    public String getId() {
        return id;
    }

    public Book setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}
