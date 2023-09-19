package com.example.Booksdemo.service;

import com.example.Booksdemo.domain.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book p);

    Book getBook(int id);

    List<Book> getAll();

    Book updateBook(
            Integer id,
            String name,
            Integer ISBN,
            String author);

    String removeBook(int id);
}
