package com.example.Booksdemo.service;

import com.example.Booksdemo.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceList implements BookService {

    private List<Book> books = new ArrayList<>();

    @Override
    public Book createBook(Book b) {
        books.add(b);
        Book created = this.books.get(this.books.size() - 1); // return the last element in the list
        return created;
    }

    @Override
    public Book getBook(int id) {
        if (id < this.books.size())
            return this.books.get(id);
        else
            return null;
    }

    @Override
    public List<Book> getAll() {
        return this.books;
    }

    @Override
    public Book updateBook(Integer id, String name, Integer ISBN, String author) {
        if (id >= this.books.size()) return null;
        Book toUpdate = this.books.get(id);

        if (name != null) toUpdate.setName(name);
        if (ISBN != null) toUpdate.setISBN(ISBN);
        if (author != null) toUpdate.setAuthor(author);

        return toUpdate;
    }

    @Override
    public String removeBook(int id) {
        if (id >= this.books.size()) return "NOT FOUND";
        else {
            this.books.remove(id);
            return "Book removed";
        }
    }
}
