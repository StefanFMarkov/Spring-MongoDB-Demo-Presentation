package com.example.mongodbrepo.config;

import com.example.mongodbrepo.model.BookModel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.mapping.DocumentPointer;

@WritingConverter
public class BookModelReferenceConverter implements Converter<BookModel, DocumentPointer<String>> {

    @Override
    public DocumentPointer<String> convert(BookModel source) {
        return source::getId;
    }
}
